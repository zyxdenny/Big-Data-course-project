package org.example;
import io.jhdf.HdfFile;
import io.jhdf.api.Dataset;
import io.jhdf.api.Group;
import io.jhdf.api.Node;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class H5_parser {
    int para=0;
    private HdfFile hdfFile;
    private List<String> nodes_path_list=new ArrayList<String>();
    public H5_parser(int para,HdfFile hdfFile){
        this.para=para;
        this.hdfFile=hdfFile;
        if (!this.nodes_path_list.isEmpty()){
            this.nodes_path_list.clear();
        }
        this.load_path(hdfFile,0);
    }

    private void load_path(Group group, int level){
        level++;
        String indent = StringUtils.repeat("    ", level);
        for (Node node : group) {
            System.out.println(indent + node.getName()); //NOSONAR - sout in example
            System.out.println(node.getPath());
            if (node instanceof Group) {
                load_path((Group) node, level);
            }else {
                System.out.println(indent + "Name:"+node.getName()+" Path:"+ node.getPath()+" added");
                this.nodes_path_list.add(node.getPath());
            }
        }
    }

    //todo: verify whether the load path is correct comparing the print results
    //todo: They should only differentiate in the folder
    public void recursivePrintGroup(Group group, int level) {
        level++;
        String indent = StringUtils.repeat("    ", level);
        for (Node node : group) {
            System.out.println(indent + node.getName()); //NOSONAR - sout in example
            System.out.println(node.getPath());
            if (node instanceof Group) {
                recursivePrintGroup((Group) node, level);
            }
        }
    }

    public void printPath (){
        for (String s:this.nodes_path_list
             ) {
            System.out.println(s);
        }
    }

    public void printData (){
        for (String s:this.nodes_path_list
        ) {
            this.hdfFile.getFile();
            Dataset dataset = this.hdfFile.getDatasetByPath(s);


            // data will be a java array of the dimensions of the HDF5 dataset
            Object data = dataset.getData();
            System.out.println("Current print "+s+": ");
            if (data instanceof LinkedHashMap){
                ((LinkedHashMap<?, ?>) data).forEach((key, value) -> {
                   System.out.println(key.toString()+" "+retrieveCompoundData(value).toString());
                });
            }else {
                System.out.println(ArrayUtils.toString(data));
            }

        }
    }

    public void printDataType (){
        for (String s:this.nodes_path_list
        ) {
            this.hdfFile.getFile();
            Dataset dataset = this.hdfFile.getDatasetByPath(s);


            // data will be a java array of the dimensions of the HDF5 dataset
            Object data = dataset.getData();
            System.out.println("Current print "+s+": ");
            if (data instanceof LinkedHashMap){
                ((LinkedHashMap<?, ?>) data).forEach((key, value) -> {
                    System.out.println(key.toString()+" "+value.getClass());
                });
            }else {
                System.out.println(ArrayUtils.toString(data.getClass()));
            }

        }
    }

    //@Retrieve data from compound data form (array) (like in songs) List<?>
    private List<?> retrieveCompoundData(Object value){
        if (value instanceof int[]){
            List<Integer> res = new ArrayList<Integer>();
            for (int i: (int[]) value
                 ) {
                res.add(i);
            }

            return res;
        } else if (value instanceof double[]) {
            List<Double> res = new ArrayList<Double>();
            for (double i: (double[]) value
            ) {
                res.add(i);
            }

            return res;
        } else if (value instanceof String[]) {
            List<String> res = new ArrayList<String>();
            for (String i: (String[]) value
            ) {
                res.add(i);
            }

            return res;
        } else if (value instanceof  double[][]) {
            //Current print /analysis/segments_pitches:
            //class [[D
            List<List<Double>> res = new ArrayList<>();

            for (double[] i : (double[][]) value) {
                List<Double> temp  = new ArrayList<Double>();
                for (double j : i) {
                    temp.add(j);
                }
                res.add(temp);
            }

            return res;
        }
        return null;
    }
}
