package Encrpytion.util;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class TotalProcessing {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuratiogin(); // Hadoop 환경 구성하기 위한 Configuration 객체
        Job job = Job.getInstance(conf, "Total Processing"); // Map-Reduce 작업 실행하기 위한 Job 객체 생성
        job.setJarByClass(TotalProcessing.class); // jar파일의 클래스 선정
        
        // Mapper 클래스와 Reducer 클래스 매핑
        job.setMapperClass(Mapper.class);
        job.setReducerClass(Reducer.class);

         // 출력값 클래스 설정
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
         // 출력값 클래스 설정
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 입력과 출력 경로 설정
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // MapReduce 작업을 실행하고 완료될 때까지 대기합니다. 작업이 성공적으로 완료되면 프로그램은 0으로 종료됩니다.
         // 그렇지 않은 경우 1로 종료됩니다.
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
