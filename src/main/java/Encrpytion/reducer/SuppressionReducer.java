package Encrpytion.reducer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SuppressionReducer extends Reducer<LongWritable, Text, LongWritable, Text> {

    private final LongWritable outputKey = new LongWritable();
    private final Text outputValue = new Text();

    @Override
    protected void reduce(LongWritable key, Iterable<Text> values, Reducer<LongWritable, Text, LongWritable, Text>.Context context) throws IOException, InterruptedException {
        outputKey.set(key.get());//key 그대로 저장

        for (Text value : values ) {
            outputValue.set(value);//value도 그대로 저장
        }

        context.write(outputKey, outputValue);
    }
}
