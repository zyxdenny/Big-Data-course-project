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
    public static void main(String[] args) throws IOException {
        String all_schema_path = new String("./src/avro/song.avsc");
        String summary_schema_path = new String("./src/avro/song_summary.avsc");
        String artists_schema_path = new String("./src/avro/artists.avsc");
        Schema schema = new Schema.Parser().parse(new File(all_schema_path));
        Schema summary_schema = new Schema.Parser().parse(new File(summary_schema_path));
        Schema artists_schema = new Schema.Parser().parse(new File(artists_schema_path));
        if (Objects.equals(args[0], "h5")) {
            try (HdfFile hdfFile = new HdfFile(Paths.get(args[1]))) {
                H5_parser h5_parser = new H5_parser(2, hdfFile);
                h5_parser.printPath();
                if (Objects.equals(args[2], "-pd")) {
                    h5_parser.printData();
                } else if (Objects.equals(args[2], "-pt")) {
                    h5_parser.printDataType();
                } else if (Objects.equals(args[2], "-pg")) {
                    System.out.println("start print group!");
                    h5_parser.recursivePrintGroup(hdfFile, 0,false);
                }
            }
        }else if (Objects.equals(args[0], "avro")){
            System.out.println("Avro Mode");
            if (Objects.equals(args[1], "--all"))
            {
                CompactSmallFiles c=new CompactSmallFiles(all_schema_path);
                //GenericRecord record= h5_parser.fillSchema(schema); debug usage
                c.serialize("./test","trial.avro");
                System.out.println("here");
            } else if (Objects.equals(args[1], "--summary")) {
                //GenericRecord test_record=h5_parser.fillSummarySchema(summary_schema);
                //System.out.println(test_record);
                CompactSmallFiles c2=new CompactSmallFiles(summary_schema_path);
                c2.serializeSummary("./test","trial_summary.avro");
                System.out.println("finished");
            } else if (Objects.equals(args[1], "--read")) {
                CompactSmallFiles c2=new CompactSmallFiles(summary_schema_path);
                c2.readDir("./test");
            } else if (Objects.equals(args[1], "--artists")) {
                CompactSmallFiles c2=new CompactSmallFiles(artists_schema_path);
                c2.serializeArtists("./test","trial_artists.avro");
                System.out.println("finished");
            }
        }


    }
}