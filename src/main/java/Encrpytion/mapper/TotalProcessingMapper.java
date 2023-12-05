package Encrpytion.mapper;

import Encrpytion.domain.ItemGenerator;
import Encrpytion.domain.UserPhysicalEncrpytForm;
import Encrpytion.domain.UserPhysicalInfo;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TotalProcessingMapper extends Mapper<LongWritable, Text, Text, Text> {
    private final Text outputKey = new Text();
    private final Text outputValue = new Text();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context) throws IOException, InterruptedException {
        UserPhysicalEncrpytForm info = ItemGenerator.getUserPhysicalEncrpytFormForMR(value);//객체 생성

        outputKey.set(info.getGender() + info.getAge());//성별과 범주화된 나이로 키 저장
        outputValue.set(info.toString());//UserPhysicalEncrpytForm 객체를 value로 저장

        context.write(outputKey, outputValue);
    }
}
