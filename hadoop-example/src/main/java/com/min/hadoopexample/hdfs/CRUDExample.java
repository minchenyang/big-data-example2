/*
package com.min.hadoopexample.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

*/
/**
 * @program: big-data-example2
 * @description:  原生
 * @author: mcy
 * @create: 2018-11-13 11:14
 **//*

public class CRUDExample {

    public static final String HDFS_PATH = "hdfs://192.168.0.201:8082";

    FileSystem fileSystem = null;
    Configuration configuration = null;


    public void setUp() throws Exception {
        System.out.println("HDFSApp.setUp");
        configuration = new Configuration();
        fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration, "root");
    }

    public void tearDown() throws Exception {
        configuration = null;
        fileSystem = null;

        System.out.println("HDFSApp.tearDown");
    }


    */
/**
     * 创建HDFS目录
     *//*

    public void mkdir() throws Exception {
        setUp();
        fileSystem.mkdirs(new Path("/hdfsapi/test"));
        tearDown();
    }

    */
/**
     * 创建文件
     *//*

    public void create() throws Exception {
        setUp();
        FSDataOutputStream output = fileSystem.create(new Path("/hdfsapi/test/a.txt"));
        output.write("hello hadoop".getBytes());
        output.flush();
        output.close();
        tearDown();
    }

    */
/**
     * 查看HDFS文件的内容
     *//*

    public void cat() throws Exception {
        setUp();
        FSDataInputStream in = fileSystem.open(new Path("/hdfsapi/test/a.txt"));
        IOUtils.copyBytes(in, System.out, 1024);
        in.close();
        tearDown();
    }

    */
/**
     * 重命名
     *//*

    public void rename() throws Exception {
        setUp();
        Path oldPath = new Path("/hdfsapi/test/a.txt");
        Path newPath = new Path("/hdfsapi/test/b.txt");
        fileSystem.rename(oldPath, newPath);
        tearDown();
    }

    */
/**
     * 上传文件到HDFS
     *//*

    public void copyFromLocalFileWithProgress() throws Exception {
        setUp();
        InputStream in = new BufferedInputStream(
                new FileInputStream(
                        new File("/min/10-1.pcap")));

        FSDataOutputStream output = fileSystem.create(new Path("/hdfsapi/test/10-1.pcap"),
                ()-> {
                        System.out.println("----------");  //带进度提醒信息
                });
        IOUtils.copyBytes(in, output, 4096);
        tearDown();
    }

    */
/**
     * 下载HDFS文件
     *//*

    public void copyToLocalFile() throws Exception {
        setUp();
        Path localPath = new Path("/min/222.pcap");
        Path hdfsPath = new Path("/hdfsapi/test/10-1.pcap");
        fileSystem.copyToLocalFile(hdfsPath, localPath);
        tearDown();
    }


    */
/**
     * 查看某个目录下的所有文件
     *//*

    public void listFiles() throws Exception {
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/"));

        for(FileStatus fileStatus : fileStatuses) {
            String isDir = fileStatus.isDirectory() ? "文件夹" : "文件";
            short replication = fileStatus.getReplication();
            long len = fileStatus.getLen();
            String path = fileStatus.getPath().toString();

            System.out.println(isDir + "\t" + replication + "\t" + len + "\t" + path);
        }
    }

    */
/**
     * 删除
     * boolean : 是否递归删除
     *//*

    public void delete() throws Exception{
        fileSystem.delete(new Path("/"), true);
    }


}




*/
