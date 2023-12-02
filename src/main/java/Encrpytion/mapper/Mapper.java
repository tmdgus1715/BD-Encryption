import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class Mapper extends Mapper<LongWritable, Text, Text, Text> {

    private Text ageGroupKey = new Text();
    private Text weightTallValue = new Text();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] data = value.toString().split(","); // CSV로 데이터가 구성되어 있다고 가정합니다.

        String ageString = data[1]; // 나이 데이터 추출
        int age = Integer.parseInt(ageString);

        // 나이대에 따라 그룹화
        String ageGroup = getAgeGroup(age);

        // 나이대를 키로 하고 몸무게와 신장을 값으로 전달합니다.
        String weight = data[6]; // 몸무게
        String tall = data[7]; // 신장

        ageGroupKey.set(ageGroup);
        weightTallValue.set("weight:" + weight + ",tall:" + tall);

        context.write(ageGroupKey, weightTallValue);
    }

    // 나이대를 설정하는 메서드
    private String getAgeGroup(int age) {
        if (age >= 0 && age <= 9) {
            return "0-9";
        } else if (age >= 10 && age <= 19) {
            return "10-19";
        } else if (age >= 20 && age <= 29) {
            return "20-29";
        } else if (age >= 30 && age <= 39) {
            return "30-39";
        } else if (age >= 40 && age <= 49) {
            return "40-49";
        } else if (age >= 50 && age <= 59) {
            return "50-59";
        } else if (age >= 60 && age <= 69) {
            return "60-69";
        } else if (age >= 70 && age <= 79) {
            return "70-79";
        } else {
            return "80-89"; // 80세 이상
        }
    }
}
