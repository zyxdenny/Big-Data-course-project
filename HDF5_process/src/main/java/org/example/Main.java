package org.example;
import io.jhdf.HdfFile;
import io.jhdf.api.Dataset;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.commons.lang3.ArrayUtils;
import org.example.H5_parser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

import io.jhdf.HdfFile;
import io.jhdf.api.Group;
import io.jhdf.api.Node;
import org.apache.commons.lang3.StringUtils;

public class Main {
    //todo: commandline parser
    public static void main(String[] args) {

        try (HdfFile hdfFile = new HdfFile(Paths.get(args[0]))) {
            Schema schema = new Schema.Parser().parse(new File("./src/avro/song.avsc"));
            Schema summary_schema =new Schema.Parser().parse(new File("./src/avro/song_summary.avsc"));
            System.out.println(schema.getFields());
            System.out.println(hdfFile.getFile().getName()); //NOSONAR - sout in example
            H5_parser h5_parser=new H5_parser(2,hdfFile);
            h5_parser.printPath();
            if (Objects.equals(args[1], "1")){
                h5_parser.printData();
            } else if (Objects.equals(args[1], "2")) {
                h5_parser.printDataType();
            }else if (Objects.equals(args[1], "3")){
                System.out.println("Avro begin!");

                CompactSmallFiles c=new CompactSmallFiles("./src/avro/song.avsc");
                //GenericRecord record= h5_parser.fillSchema(schema); debug usage
                c.serialize("./test","trial.avro");
                System.out.println("here");

                //System.out.println(h5_parser.getAll_data().toString());
            }else if (Objects.equals(args[1], "p")){
                System.out.println("start print group!");
                h5_parser.recursivePrintGroup(hdfFile, 0,false);
            } else if (Objects.equals(args[1], "t")) {
                h5_parser.storeData();
                //GenericRecord test_record=h5_parser.fillSummarySchema(summary_schema);
                //System.out.println(test_record);
                CompactSmallFiles c2=new CompactSmallFiles("./src/avro/song_summary.avsc");
                c2.serializeSummary("./test","trial_summary.avro");
                System.out.println("finished");

            }else if (Objects.equals(args[1], "a")){
                CompactSmallFiles c2=new CompactSmallFiles("./src/avro/song_summary.avsc");
                c2.readDir("./test");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}