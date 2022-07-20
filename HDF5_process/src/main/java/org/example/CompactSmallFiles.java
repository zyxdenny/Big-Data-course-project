package org.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

import io.jhdf.HdfFile;
import org.apache.avro.Schema;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.FastReaderBuilder;
import org.apache.avro.specific.SpecificDatumWriter;

public class CompactSmallFiles {
    private ArrayList<Path> all_files;
    private String avsc_dir;
    Boolean is_file_load= false;
    CompactSmallFiles(String in){
        this.all_files=new ArrayList<>();
        this.avsc_dir=in;
    }
    public void serialize(String h5_dir,String out_name) throws IOException {
        if (!is_file_load){
            System.out.println("File not loaded in!");
            System.out.println("Now we load h5 files in "+h5_dir);
            this.readDir(h5_dir);
        }
        System.out.println("Serialize initialize ......");
        Schema schema = new Schema.Parser().parse(new File(this.avsc_dir));
        Schema schemaBackup= new Schema.Parser().parse(new File(this.avsc_dir));
        DatumWriter<GenericRecord> DatumWriter = new GenericDatumWriter<GenericRecord>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(DatumWriter);
        //dataFileWriter.setCodec(CodecFactory.snappyCodec());
        dataFileWriter.create(schema, new File(out_name));
        //DatumWriter<Csvfile> DatumWriter = new SpecificDatumWriter<Csvfile>(Csvfile.class);
        //DataFileWriter<Csvfile> dataFileWriter = new DataFileWriter<Csvfile>(DatumWriter);
        //Csvfile paradigm=new Csvfile();
        //dataFileWriter.create(paradigm.getSchema(), new File(out_name));
        String initialize_message="Serialize begins, target dir: "+ all_files.get(0).toRealPath().getParent();
        System.out.println(initialize_message);
        for (Path file:this.all_files
        ) {
            String file_name = file.getFileName().toString();
            StringBuilder SHA_text = new StringBuilder();
            Charset charset = StandardCharsets.US_ASCII;
            //todo set data to special field
            H5_parser h5_parser = new H5_parser(1, new HdfFile(file));
            h5_parser.storeData();


            GenericRecord genericRecord = h5_parser.fillSchema(schemaBackup);
            dataFileWriter.append(genericRecord);


        /*
            try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    SHA_text.append(line);
                    SHA_text.append("\n");
                }
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
            String SHA_value=new DigestUtils("SHA1").digestAsHex(SHA_text.toString());
            //https://www.baeldung.com/sha-256-hashing-java

            ByteBuffer byteBuffer = ByteBuffer.wrap(SHA_text.toString().getBytes(charset));
            Csvfile csvfile = Csvfile.newBuilder()
                    .setFilename(file_name)
                    .setFilecontent(byteBuffer)
                    .setChecksum(SHA_value)
                    .build();
            dataFileWriter.append(csvfile);
            byteBuffer.clear();

         */
        }
        dataFileWriter.close();
        System.out.println("Serialize finished!");


    }

    public void serializeSummary(String h5_dir,String out_name) throws IOException {
        if (!is_file_load){
            System.out.println("File not loaded in!");
            System.out.println("Now we load h5 files in "+h5_dir);
            this.readDir(h5_dir);
        }
        System.out.println("Serialize initialize ......");
        Schema schema = new Schema.Parser().parse(new File(this.avsc_dir));
        Schema schemaBackup= new Schema.Parser().parse(new File(this.avsc_dir));
        DatumWriter<GenericRecord> DatumWriter = new GenericDatumWriter<GenericRecord>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(DatumWriter);
        dataFileWriter.create(schema, new File(out_name));

        String initialize_message="Serialize begins, target dir: "+ all_files.get(0).toRealPath().getParent();
        System.out.println(initialize_message);
        for (Path file:this.all_files
        ) {
            String file_name = file.getFileName().toString();
            StringBuilder SHA_text = new StringBuilder();
            Charset charset = StandardCharsets.US_ASCII;
            //todo set data to special field
            H5_parser h5_parser = new H5_parser(1, new HdfFile(file));
            h5_parser.storeData();


            GenericRecord genericRecord = h5_parser.fillSummarySchema(schemaBackup);
            dataFileWriter.append(genericRecord);
        }
        dataFileWriter.close();
        System.out.println("Serialize finished!");


    }


    public void readDir(String dirName) {
        Path Path;
        Path= Paths.get(dirName);
        //test for path correctness
        //Path Full=hallPath.toAbsolutePath();
        //System.out.format("toString: %s%n", Full.toString());
        if (Files.notExists(Path)){
            throw new RuntimeException("No Specified Path: " + dirName);
        }/*else {
            System.out.println("Path Valid!");
        }*/

        //https://docs.oracle.com/javase/tutorial/essential/io/dirs.html
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Path)) {
            for (Path file: stream) {
                if (file.getFileName().toString().contains(".h5")){
                    this.all_files.add(file);
                }

            }
        } catch ( IOException  | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println();
        }
        is_file_load=true;
    }

    public void printDir() throws IOException {
        for (Path a:this.all_files
        ) {
            System.out.println(a.toRealPath());
        }
    }

    @Deprecated //to be deleted
    public void fillSchema (H5_parser h5_parser,Schema schema){
        Map<String,?> all_data=h5_parser.getAll_data();
        all_data.forEach((key, value) -> {
            Schema newSchema=schema;
            List<String> Key_list=new ArrayList<String>();
            //key=key.substring(1);
            while (key.contains("/")){
                key=key.substring(key.indexOf("/")+1);
                if (key.contains("/")){
                    String fieldName = key.substring(0,key.indexOf("/"));

                    newSchema = newSchema.getField(fieldName).schema();
                    Key_list.add(fieldName);
                }else {
                    //last separation
                    String fieldName = key.substring(0);
                    /*if (fieldName == "time_signature"){
                        System.out.println("haha");
                    }*/
                    Key_list.add(fieldName);
                }
            }

            System.out.println(Key_list.size()+" "+Key_list.toString()+" "+value);

        });
    }



}
