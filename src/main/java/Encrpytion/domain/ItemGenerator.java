package Encrpytion.domain;

import org.apache.hadoop.io.Text;

import java.time.LocalDate;

/**
 * 도메인 객체 생성을 위한 팩토리 클래스
 */
public class ItemGenerator {

    public static UserPhysicalInfo getUserPhysicalInfoForMR(Text text) {
        String[] strings = text.toString().split(",");
        return new UserPhysicalInfo.UserPhysicalInfoBuilder()
                .name(strings[0])
                .age(Integer.parseInt(strings[1]))
                .tall(Double.parseDouble(strings[7]))
                .weight(Double.parseDouble(strings[6]))
                .gender(UserPhysicalInfo.Gender.getGender(strings[3]))
                .build();
    }

    public static UserPhysicalEncrpytForm getUserPhysicalEncrpytFormForMR(Text text) {
        String[] strings = text.toString().split("\\s+");
        return new UserPhysicalEncrpytForm.UserPhysicalEncrpytFormBuilder()
                .name(strings[1])
                .age(strings[2])
                .tall(Double.parseDouble(strings[3]))
                .weight(Double.parseDouble(strings[4]))
                .gender(strings[5])
                .build();
    }

    public static UserPhysicalEncrpytForm getUserPhysicalEncrpytFormForTP(Text text) {
        String[] strings = text.toString().split("\\s");
        return new UserPhysicalEncrpytForm.UserPhysicalEncrpytFormBuilder()
                .name(strings[0])
                .age(strings[1])
                .tall(Double.parseDouble(strings[2]))
                .weight(Double.parseDouble(strings[3]))
                .gender(strings[4])
                .build();
    }

}
