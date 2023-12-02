import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class Reducer extends Reducer<Text, Text, Text, Text> {

    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int totalWeight = 0;
        int totalTall = 0;
        int count = 0;

        for (Text value : values) {
            String[] data = value.toString().split(",");
            for (String entry : data) {
                String[] pair = entry.split(":");
                if (pair[0].equals("weight")) {
                    totalWeight += Integer.parseInt(pair[1]);
                } else if (pair[0].equals("tall")) {
                    totalTall += Integer.parseInt(pair[1]);
                }
                count++;
            }
        }

        // 해당하는 몸무게와 신장의 평균을 계산하여 출력합니다.
        if (count > 0) {
            double avgWeight = (double) totalWeight / count;
            double avgTall = (double) totalTall / count;

            context.write(key, new Text("Average Weight: " + avgWeight + ", Average Tall: " + avgTall));
        }
    }
}
