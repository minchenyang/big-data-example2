package com.min.hadoopexample.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.net.URI;

/**
 * @program: big-data-example2
 * @description:
 * @author: mcy
 * @create: 2018-12-06 18:15
 **/
public class Test {

    public static void main(String[] args) {
        /*HdfsBolt hdfsBolt = new HdfsBolt();
        hdfsBolt.setHdfsUrl("hdfs://192.168.0.61:8020");
        hdfsBolt.setUser("hdfs");
        try {
            hdfsBolt.init();
        } catch (Exception e) {
            System.out.println("error");
        }*/
        try {
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public void init() throws Exception {
        this.configuration = new Configuration();
        this.fileSystem = FileSystem.get(new URI(this.hdfsUrl), this.configuration, this.user);
    }*/

    public static void setUp() throws Exception {
        System.out.println("HDFSApp.setUp");
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.0.61:8020"), configuration, "hdfs");
    }
}
