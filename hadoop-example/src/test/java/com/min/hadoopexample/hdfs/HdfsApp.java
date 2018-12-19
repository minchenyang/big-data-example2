package com.min.hadoopexample.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;

/**
 * @program: big-data-example2
 * @description:
 * @author: mcy
 * @create: 2018-11-13 11:27
 **/

public class HdfsApp {

    public static void main(String[] args) throws Exception {
        HdfsApp hdfsApp = new HdfsApp();

        hdfsApp.setUp();
        /*InputStream in = new BufferedInputStream(
                new FileInputStream(
                        new File("E:\\tttt\\页面es命令.txt")));

        FSDataOutputStream output = hdfsApp.fileSystem.create(new Path("/alldata/pcap/10-1.pcap"),
                ()-> {
                    System.out.println("----------");  //带进度提醒信息
                });
        IOUtils.copyBytes(in, output, 4096);*/

    }

    public static final String HDFS_PATH = "hdfs://192.168.0.61:8020";

    FileSystem fileSystem = null;
    Configuration configuration = null;


    public void setUp() throws Exception {
        System.out.println("HDFSApp.setUp");
        configuration = new Configuration();
        fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration, "hdfs");
    }

    public void tearDown() throws Exception {
        configuration = null;
        fileSystem = null;
        System.out.println("HDFSApp.tearDown");
    }

}
