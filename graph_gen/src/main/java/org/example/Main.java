package org.example;
import java.io.*;

//import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;
import java.nio.*;

import io.jhdf.HdfFile;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.commons.lang3.ArrayUtils;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.util.Utf8;

import org.apache.commons.lang3.StringUtils;

public class Main {


    //todo: commandline parser
    public static void main(String[] args) throws IOException {
        String all_schema_path = new String("./src/avro/song.avsc");
        String summary_schema_path = new String("./src/avro/song_summary.avsc");
        String artists_schema_path = new String("./src/avro/artists.avsc");
        Schema schema = new Schema.Parser().parse(new File(all_schema_path));
        Schema summary_schema = new Schema.Parser().parse(new File(summary_schema_path));
        Schema artists_schema = new Schema.Parser().parse(new File(artists_schema_path));

        File in_file = new File(args[0]);
        File out_file = new File(args[1]);
        // artist_id | similar artist_id | distance | state (0: untouched,1: expandable,2: visited)
        BufferedWriter out = new BufferedWriter(new FileWriter(out_file));

        DatumReader<GenericRecord> userDatumReader = new GenericDatumReader<GenericRecord>(artists_schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(in_file, userDatumReader);
        DataFileReader<GenericRecord> dataFileReader2 = new DataFileReader<GenericRecord>(in_file, userDatumReader);
        while(dataFileReader.hasNext()){
            GenericRecord tmp = dataFileReader.next();
            String content = tmp.get("artist_id") + "|";

            List<Utf8> similar_artists = new ArrayList<Utf8>();
            similar_artists = (List<Utf8>) tmp.get("similar_artists") ;
            if (similar_artists != null)
                for (Utf8 similar_artist: similar_artists){
                    content = content + similar_artist.toString() +" ";
                }
            content = content + "|";
            content = content + "9999|0\n";
            out.write(content);
        }
        out.close();
        GraphGen graphGen=new GraphGen();
        graphGen.serializeNodes(dataFileReader2,"trial_graph.avro");
    }
}