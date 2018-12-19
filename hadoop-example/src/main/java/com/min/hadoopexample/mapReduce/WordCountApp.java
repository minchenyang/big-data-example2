/*
package com.min.hadoopexample.mapReduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

*/
/**
 * @program: big-data-example2
 * @description:
 * @author: mcy
 * @create: 2018-11-15 16:17
 **//*

public class WordCountApp {

    */
/**
     * Map： 读取输入的文件
     * LongWritable: 文件的偏移 (相当于 int)
     * Text:文件每行内容 (相当于 String)
     *
     *//*

    public static class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable>{
        LongWritable one = new LongWritable(1);

        @Override
        protected void map(final LongWritable key, final Text value, final Context context) throws IOException, InterruptedException {
            // 接收到的每一行数据
            String line = value.toString();

            //按照指定分隔符进行拆分
            String[] words = line.split(" ");

            for(String word :  words) {
                // 通过上下文把map的处理结果输出
                context.write(new Text(word), one);
            }

        }
    }

    */
/**
     * Reduce：归并操作
     *//*

    public static class MyReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {

            long sum = 0;
            for(LongWritable value : values) {
                // 求key出现的次数总和
                sum += value.get();
            }

            // 最终统计结果的输出
            context.write(key, new LongWritable(sum));
        }
    }

    */
/**
     * 定义Driver：封装了MapReduce作业的所有信息
     *//*

    public static void run(String s1, String s2) throws Exception{
        //创建Configuration
        Configuration configuration = new Configuration();

        //创建Job
        Job job = Job.getInstance(configuration, "wordcount");

        //设置job的处理类
        job.setJarByClass(WordCountApp.class);

        //设置作业处理的输入路径
        FileInputFormat.setInputPaths(job, new Path(s1));

        //设置map相关参数
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        //设置reduce相关参数
            job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        job.setNumReduceTasks(1);

        //设置作业处理的输出路径
        FileOutputFormat.setOutputPath(job, new Path(s2));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

    public static void main(String[] args) {
        try {
            run("/alldata/min/wordcount/wordcount.txt",
                    "/alldata/min/wc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/