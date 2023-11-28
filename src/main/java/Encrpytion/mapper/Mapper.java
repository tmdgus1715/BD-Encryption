package Encrpytion.mapper;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class MapperClass extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 여기서 입력 데이터를 파싱하여 필요한 부분을 추출합니다.
        String[] data = value.toString().split(","); // 예를 들어, CSV로 데이터가 구성되어 있다고 가정합니다.

        // 이름과 나이를 추출
        String name = data[0]; // 이름
        int age = Integer.parseInt(data[1]); // 나이
        // 범주화된 데이터가 있는 경우, 그에 맞게 처리합니다.

        // age(나이) 기준으로 tall(신장)과 weight(몸무게)를 추출
        int tall = Integer.parseInt(data[2]); // tall(신장)
        int weight = Integer.parseInt(data[3]); // weight(몸무게)

        // age(나이)를 키로 하고 tall(신장)과 weight(몸무게)를 값으로 전달합니다.
        word.set(Integer.toString(age));
        context.write(word, new IntWritable(tall));
        context.write(word, new IntWritable(weight));
    }
}
