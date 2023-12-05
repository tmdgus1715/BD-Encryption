package Encrpytion.domain;

import Encrpytion.util.AgeCategorizer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 암호화 기법이 적용된 데이터를 담는 객체
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPhysicalEncrpytForm {
    private String name;
    private String age;
    private Double tall;
    private Double weight;
    private String gender;

    public UserPhysicalEncrpytForm(UserPhysicalInfo info) {
        this.name = info.getName();
        this.age = AgeCategorizer.categorize(info.getAge());//나이를 범주화하여 저장
        this.tall = info.getTall();
        this.weight = info.getWeight();
        this.gender = info.getGender().toString();
    }

    @Override
    public String toString() {
        return name + " " + age +  " " + tall +  " " + weight + " " +  gender;
    }
}
