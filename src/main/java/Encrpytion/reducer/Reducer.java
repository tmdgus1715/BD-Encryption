package Encrpytion.reducer;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class ReducerClass extends Reducer<Text, IntWritable, Text, IntWritable> {

    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int totalTall = 0;
        int totalWeight = 0;
        
        for (IntWritable value : values) {
            // tall(신장)와 weight(몸무게)를 더합니다.
            totalTall += value.get();
            if (values.iterator().hasNext()) {
                totalWeight += values.iterator().next().get();
            }
        }

        // 결과를 출력합니다.
        context.write(key, new IntWritable(totalTall));
        context.write(key, new IntWritable(totalWeight));
    }
}
