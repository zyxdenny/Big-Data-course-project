package org.example;
import io.jhdf.HdfFile;
import io.jhdf.api.Dataset;
import org.apache.avro.Schema;
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
            System.out.println(schema.getFields());
            System.out.println(hdfFile.getFile().getName()); //NOSONAR - sout in example
            H5_parser h5_parser=new H5_parser(2,hdfFile);
            //h5_parser.recursivePrintGroup(hdfFile, 0);
            //h5_parser.printPath();
            if (Objects.equals(args[1], "1")){
                h5_parser.printData();
            } else if (Objects.equals(args[1], "2")) {
                h5_parser.printDataType();
            }else if (Objects.equals(args[1], "3")){
                h5_parser.storeData();
                System.out.println(h5_parser.getAll_data().toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}