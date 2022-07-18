package org.example;
import io.jhdf.HdfFile;
import io.jhdf.api.Dataset;
import org.apache.commons.lang3.ArrayUtils;
import org.example.H5_parser;
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
            System.out.println(hdfFile.getFile().getName()); //NOSONAR - sout in example
            H5_parser h5_parser=new H5_parser(2,hdfFile);
            h5_parser.recursivePrintGroup(hdfFile, 0);
            h5_parser.printPath();
        }
        if (Objects.equals(args[2], "1")){
            try (HdfFile hdfFile = new HdfFile(Paths.get(args[0]))) {
                hdfFile.getFile();
                Dataset dataset = hdfFile.getDatasetByPath(args[1]);
                // data will be a java array of the dimensions of the HDF5 dataset
                Object data = dataset.getData();
                System.out.println(ArrayUtils.toString(data)); //NOSONAR - sout in example
            }
        }

    }
}