package org.example;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;

import java.io.File;
import java.io.IOException;

public class GraphGen {
    public GraphGen(){

    }
    public void serializeNodes(DataFileReader<GenericRecord> dataFileReader, String out_name) throws IOException {
        System.out.println("Serialize initialize ......");
        Schema schema = new Schema.Parser().parse(new File("./src/avro/graph_node.avsc"));
        Schema schemaBackup= new Schema.Parser().parse(new File("./src/avro/graph_node.avsc"));
        DatumWriter<GenericRecord> DatumWriter = new GenericDatumWriter<GenericRecord>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(DatumWriter);
        dataFileWriter.create(schema, new File(out_name));
        while(dataFileReader.hasNext()){
            GenericRecord tmp = dataFileReader.next();
            GenericRecord genericRecord = new GenericData.Record(schema);
            genericRecord.put("artist_id",tmp.get("artist_id"));
            genericRecord.put("similar_artists",tmp.get("similar_artists"));
            genericRecord.put("distance",9999);
            genericRecord.put("state",0);
            dataFileWriter.append(genericRecord);
        }
        dataFileWriter.close();
        System.out.println("Serialize finished!");


    }
}
