package com.min.hadoopexample.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.net.URI;
import java.net.URISyntaxException;

public class Connection {

    public static final String HDFS_PATH = "hdfs://192.168.0.201:8082";


    public static void main(String[] args) throws Exception {
        //连接
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration, "root");
        //操作

        //释放
        fileSystem = null;
        configuration = null;
    }

}
