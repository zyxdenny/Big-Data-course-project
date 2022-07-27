package org.example;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.jhdf.HdfFile;
import io.jhdf.api.Dataset;
import io.jhdf.api.Group;
import io.jhdf.api.Node;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class H5_parser {
    int para=0;
    private HdfFile hdfFile;
    private List<String> summary_list = new ArrayList<String>();
    private List<String> artists_list = new ArrayList<String>();

    private Boolean is_stored = false;
    private List<String> nodes_path_list=new ArrayList<String>();
    private Map<String,Object> all_data=new HashMap<String, Object>();
    public H5_parser(int para,HdfFile hdfFile){
        this.para=para;
        this.hdfFile=hdfFile;
        if (!this.nodes_path_list.isEmpty()){
            this.nodes_path_list.clear();
        }
        this.load_path(hdfFile,0);
        this.summary_list_init();
        this.artists_list_init();

    }

    private void summary_list_init (){
        this.summary_list.add("/musicbrainz/songs/year");
        this.summary_list.add("/metadata/songs/song_hotttnesss");
        this.summary_list.add("/analysis/songs/duration");
        this.summary_list.add("/analysis/songs/energy");
        this.summary_list.add("/analysis/songs/tempo");
        this.summary_list.add("/metadata/songs/title");
        this.summary_list.add("/metadata/songs/release");
        this.summary_list.add("/metadata/songs/artist_name");


    }

    private void artists_list_init (){
        this.artists_list.add("/metadata/songs/artist_name");
        this.artists_list.add("/metadata/songs/artist_id");
        this.artists_list.add("/metadata/songs/artist_hotttnesss");
        this.artists_list.add("/metadata/songs/artist_latitude");
        this.artists_list.add("/metadata/songs/artist_longitude");
        this.artists_list.add("/metadata/songs/artist_familiarity");
        this.artists_list.add("/metadata/similar_artists");
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
    public void recursivePrintGroup(Group group, int level, Boolean is_indent) {
        level++;
        String indent = StringUtils.repeat("    ", level);
        for (Node node : group) {
            if (is_indent){
                System.out.println(indent + node.getName()); //NOSONAR - sout in example
            }
            System.out.println(node.getPath());
            if (node instanceof Group) {
                recursivePrintGroup((Group) node, level,is_indent);
            }
        }
    }


    public void printPath (){
        for (String s:this.nodes_path_list
             ) {
            System.out.println(s);
        }
    }
    public void storeData (){
        if (this.is_stored){
            System.out.println("Already store data, do nothing to avoid potential issues!");
            return;
        }
        for (String s:this.nodes_path_list
        ) {
            this.hdfFile.getFile();
            Dataset dataset = this.hdfFile.getDatasetByPath(s);
            // data will be a java array of the dimensions of the HDF5 dataset
            Object data = dataset.getData();

            if (data instanceof LinkedHashMap){
                ((LinkedHashMap<?, ?>) data).forEach((key, value) -> {
                    //System.out.println("Current store "+s+"/"+key.toString()+": ");
                    this.all_data.put(s+"/"+key.toString(),retrieveCompoundData(value));
                });
            }else {
                //System.out.println("Current store "+s+": ");
                this.all_data.put(s,retrieveCompoundData(data));
            }

        }
        this.is_stored=true;
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
                if (data == null){
                    System.out.println("Null");
                    continue;
                }
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

    public Map<String, Object> getAll_data() {
        return all_data;
    }

    public Boolean getIs_stored() {
        return is_stored;
    }

    public GenericRecord fillSchema(Schema schema){
        return this.fillSchemaHelper(this.hdfFile,schema);
    }

    public GenericRecord fillSchemaHelper(Group group, Schema schema) {
        GenericRecord genericRecord = new GenericData.Record(schema);

        for (Node node : group) {
            /*if (schema.getField(node.getName()) == null) {
                System.out.println(node.getName());
                continue;
            }*/ //todo:verify whether need

            if (node instanceof Group) {
                Schema newSchema = schema.getField(node.getName()).schema();
                genericRecord.put(node.getName(), fillSchemaHelper((Group) node, newSchema));
                //System.out.println("Current Group location: "+node.getName());
            } else {
                /*System.out.println("Current location: "+node.getName());
                if (this.all_data.get(node.getPath())==null){
                    System.out.println("haha");
                }//debug usage */
                Object data=this.hdfFile.getDatasetByPath(node.getPath()).getData();
                if (data instanceof LinkedHashMap){
                    Schema newSchema = schema.getField(node.getName()).schema();
                    GenericRecord newRecord = new GenericData.Record(newSchema);

                    ((LinkedHashMap<?, ?>) data).forEach((key, value) -> {
                        if (newSchema.getField(key.toString()) != null) {
                            newRecord.put(key.toString(), this.all_data.get(node.getPath()+"/"+key.toString()));
                        }
                    });

                    genericRecord.put(node.getName(), newRecord);
                }else {
                    genericRecord.put(node.getName(), this.all_data.get(node.getPath()));
                }


            }
        }
        return genericRecord;
    }
    /**
     * effect: /musicbrainz/songs/year --> year
     * used to fetch out the record from key to insert it at correct record for song_summary
     */
    private String fetchLastRecord(String s){

        return s.substring(s.lastIndexOf("/")+1);
    }
    public GenericRecord fillSummarySchema(Schema schema){
        GenericRecord genericRecord = new GenericData.Record(schema);
        for (String s:this.summary_list
             ) {
            this.all_data.forEach((key,value)->{
                if (Objects.equals(key,s)){
                    String last_str=fetchLastRecord(s);
                    Object data_out = (all_data.get(key) == null)? null: ((List<?>) all_data.get(key)).get(0);
                    genericRecord.put(last_str, data_out);
                }
            });
        }
        return genericRecord;

    }

    public GenericRecord fillArtistsSchema(Schema schema){
        GenericRecord genericRecord = new GenericData.Record(schema);
        for (String s:this.artists_list
        ) {
            this.all_data.forEach((key,value)->{
                if (Objects.equals(key,s)){
                    String last_str=fetchLastRecord(s);

                    Object data_out = (all_data.get(key) == null)? null: ((List<?>) all_data.get(key)).get(0);
                    if (Objects.equals(key,"/metadata/similar_artists")){
                        data_out=all_data.get(key);
                    }
                    genericRecord.put(last_str, data_out);
                }
            });
        }
        return genericRecord;

    }
}
