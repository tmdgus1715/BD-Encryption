package Encrpytion.reducer;

import Encrpytion.domain.ItemGenerator;
import Encrpytion.domain.UserPhysicalEncrpytForm;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TotalProcessingReducer extends Reducer<Text, Text, Text, Text> {

    private final Text outputKey = new Text();
    private final Text outputValue = new Text();
    @Override//key(성별 + 범주화된 나이)별로 sorting이 됨.
    protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
        List<UserPhysicalEncrpytForm> collect = StreamSupport.stream(values.spliterator(), false)
                .map(text -> ItemGenerator.getUserPhysicalEncrpytFormForTP(text))
                .collect(Collectors.toList());//values의 각 요소를 객체로 변환하여 저장

        //평균 신장
        double tallAvg = collect.stream().mapToDouble(UserPhysicalEncrpytForm::getTall).average().orElse(0.0);
        //평균 몸무게
        double weightAvg = collect.stream().mapToDouble(UserPhysicalEncrpytForm::getWeight).average().orElse(0.0);
        //values에 저장된 레코드의 개수
        long count = collect.size();

        outputKey.set(key);//key(성별 + 범주화된 나이)
        outputValue.set("평균 몸무게 : " + tallAvg + " 평균 신장 : " + weightAvg + " " + "총 " + count + "명");//value 출력 형식
        context.write(outputKey, outputValue);
    }
}
