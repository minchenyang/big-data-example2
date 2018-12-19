package com.min.hadoopexample.mapReduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FixedLengthInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileAsBinaryInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileAsBinaryOutputFormat;

import java.io.*;



public class WordCountApp2 {



    public static class MyMapper extends Mapper<LongWritable, BytesWritable, LongWritable, Text>{

        @Override
        protected void map(LongWritable key, BytesWritable value, Context context) throws IOException, InterruptedException {
            byte[] bytes = value.getBytes();
            context.write(key,new Text(bytes.length+""));
            context.write(key,new Text(bytes[bytes.length-1]+""));
        }
    }


    public static class MyReducer extends Reducer<LongWritable, Text, LongWritable, Text> {

        @Override
        protected void reduce(final LongWritable key, final Iterable<Text> values, final Context context) throws IOException, InterruptedException {

            for(Text t:values){
                byte[] bytes = t.getBytes();
                Integer length = bytes.length;

                context.write(new LongWritable(0),t);

            }

        }
    }



    public static void run(String s1, String s2) throws Exception{
        //创建Configuration
        Configuration configuration = new Configuration();
        FixedLengthInputFormat.setRecordLength(configuration, 1024 * 1024 * 128);
        configuration.set("mapreduce.reduce.memory.mb","5000");

        //创建Job
        Job job = Job.getInstance(configuration, "wordcount");

        //设置job的处理类
        job.setJarByClass(WordCountApp2.class);
        job.setInputFormatClass(FixedLengthInputFormat.class);

        //设置作业处理的输入路径
        FileInputFormat.setInputPaths(job, new Path(s1));
        //设置作业处理的输出路径
        FileOutputFormat.setOutputPath(job, new Path(s2));

        //设置map相关参数
        job.setMapperClass(WordCountApp2.MyMapper.class);
        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);

        //设置reduce相关参数
        job.setReducerClass(WordCountApp2.MyReducer.class);
        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(1);

        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }



    public static void main(String[] args) {//"/alldata/128/128.pcap"  //
        try {
            run("/alldata/128/128.pcap",
                    "/alldata/min/test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}















