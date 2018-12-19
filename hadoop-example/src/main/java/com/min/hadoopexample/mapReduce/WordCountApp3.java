/*
package com.min.hadoopexample.mapReduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.ByteWritable;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FixedLengthInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileAsBinaryOutputFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

*/
/**
 *
 * 使用MapReduce开发WordCount应用程序
 *
 * 只写map
 *//*

public class WordCountApp3 {

    */
/**
     * Map：读取输入的文件
     *//*

    public static class MyMapper extends Mapper<LongWritable, BytesWritable, BytesWritable, BytesWritable>{

        @Override
        protected void map(LongWritable key, BytesWritable value, Context context) throws IOException, InterruptedException {
            BytesWritable BytesWritable = new BytesWritable();

            byte[] bytes = value.getBytes();

            context.write(BytesWritable,value);
        }
    }


    */
/**
     * 定义Driver：封装了MapReduce作业的所有信息
     *//*

    public static void run(String s1, String s2) throws Exception{
        //创建Configuration
        Configuration configuration = new Configuration();
        FixedLengthInputFormat.setRecordLength(configuration, 1024 * 1024 * 128);
        configuration.set("mapreduce.reduce.memory.mb","5000");
        configuration.set("mapreduce.map.memory.mb","5000");

        //创建Job
        Job job = Job.getInstance(configuration, "wordcount");

        //设置job的处理类
        job.setJarByClass(WordCountApp3.class);
        job.setInputFormatClass(FixedLengthInputFormat.class);
        job.setOutputFormatClass(SequenceFileAsBinaryOutputFormat.class);
        //设置作业处理的输入路径
        FileInputFormat.setInputPaths(job, new Path(s1));
        //设置作业处理的输出路径
        FileOutputFormat.setOutputPath(job, new Path(s2));

        //设置map相关参数
        job.setMapperClass(WordCountApp3.MyMapper.class);
        job.setMapOutputKeyClass(BytesWritable.class);
        job.setMapOutputValueClass(BytesWritable.class);

        //设置reduce相关参数
        job.setNumReduceTasks(0);

        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }


    */
/**
     * 定义Driver：封装了MapReduce作业的所有信息
     *//*

    public static void main(String[] args) {//"/alldata/128/128.pcap"  //
        try {
            run("/alldata/128/128.pcap",
                    "/alldata/min/test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}















*/
