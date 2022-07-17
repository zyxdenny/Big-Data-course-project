package org.example;
import io.jhdf.HdfFile;
import io.jhdf.api.Dataset;
import org.apache.commons.lang3.ArrayUtils;

import java.nio.file.Paths;
import java.util.Objects;

import io.jhdf.HdfFile;
import io.jhdf.api.Group;
import io.jhdf.api.Node;
import org.apache.commons.lang3.StringUtils;

public class Main {
    private static void recursivePrintGroup(Group group, int level) {
        level++;
        String indent = StringUtils.repeat("    ", level);
        for (Node node : group) {
            System.out.println(indent + node.getName()); //NOSONAR - sout in example
            if (node instanceof Group) {
                recursivePrintGroup((Group) node, level);
            }
        }
    }
    public static void main(String[] args) {
        try (HdfFile hdfFile = new HdfFile(Paths.get(args[0]))) {
            System.out.println(hdfFile.getFile().getName()); //NOSONAR - sout in example
            recursivePrintGroup(hdfFile, 0);
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