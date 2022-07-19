package org.example;
import io.jhdf.HdfFile;
import io.jhdf.api.Dataset;
import io.jhdf.api.Group;
import io.jhdf.api.Node;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

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
            System.out.println(ArrayUtils.toString(data));
        }
    }
}
