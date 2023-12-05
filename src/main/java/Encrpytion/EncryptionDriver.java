package Encrpytion;

import Encrpytion.mapper.SuppressionMapper;
import Encrpytion.mapper.TotalProcessingMapper;
import Encrpytion.reducer.SuppressionReducer;
import Encrpytion.reducer.TotalProcessingReducer;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class EncryptionDriver extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        ToolRunner.run(new EncryptionDriver(), args);
    }

    public int run(String[] args) throws Exception {
        //첫번째 job, 데이터 마스킹 + 데이터 범주화
        Job job = Job.getInstance(getConf());
        job.setJarByClass(EncryptionDriver.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);
        job.setMapperClass(SuppressionMapper.class);
        job.setReducerClass(SuppressionReducer.class);
        FileInputFormat.addInputPath(job, new Path("member_info.csv"));//입력파일
        FileOutputFormat.setOutputPath(job, new Path("sample.out"));//출력파일
        job.waitForCompletion(true);

        //두번째 job, 데이터 총계처리
        Job job1 = Job.getInstance(getConf());
        job1.setJarByClass(EncryptionDriver.class);
        job1.setInputFormatClass(TextInputFormat.class);
        job1.setOutputFormatClass(TextOutputFormat.class);
        job1.setMapOutputKeyClass(Text.class);
        job1.setMapOutputValueClass(Text.class);
        job1.setMapperClass(TotalProcessingMapper.class);
        job1.setReducerClass(TotalProcessingReducer.class);
        FileInputFormat.addInputPath(job1, new Path("sample.out/part-r-00000"));//입력파일
        FileOutputFormat.setOutputPath(job1, new Path("sample1.out"));//출력파일
        job1.waitForCompletion(true);
        return 0;
    }

}