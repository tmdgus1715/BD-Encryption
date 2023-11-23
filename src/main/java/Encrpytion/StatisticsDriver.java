package Encrpytion;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.util.StringTokenizer;

public class StatisticsDriver extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        ToolRunner.run(new StatisticsDriver(), args);
    }

    public int run(String[] args) throws Exception {
        return 0;
    }

}