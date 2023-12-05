package Encrpytion.mapper;

import Encrpytion.domain.ItemGenerator;
import Encrpytion.domain.UserPhysicalEncrpytForm;
import Encrpytion.domain.UserPhysicalInfo;
import Encrpytion.util.DataMasker;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

public class SuppressionMapper extends Mapper<LongWritable, Text, LongWritable, Text> {

    private final LongWritable outputKey = new LongWritable();
    private final Text outputValue = new Text();

    private static AtomicLong id = new AtomicLong(1);

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, LongWritable, Text>.Context context) throws IOException, InterruptedException {
        UserPhysicalInfo info = ItemGenerator.getUserPhysicalInfoForMR(value);//한 개의 레코드로 UserPhycalInfo 객체 생성

        UserPhysicalEncrpytForm form = new UserPhysicalEncrpytForm(info);//나이 범주화 하여 UserPhysicalEncrpytForm 객체 생성
        form.setName(DataMasker.mask(form.getName()));//이름에 데이터 마스킹 적용

        outputKey.set(Long.valueOf(id.getAndIncrement()));//id 증가해서 key로 저장
        outputValue.set(form.toString());//UserPhysicalEncrpytForm 객체를 value로 저장

        context.write(outputKey, outputValue);
    }
}
