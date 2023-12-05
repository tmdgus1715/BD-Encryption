package Encrpytion.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 암호화 기법 적용 전의 데이터를 담는 객체
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPhysicalInfo {
    private String name;
    private Integer age;
    private Double tall;
    private Double weight;
    private Gender gender;


    //성별 enum클래스
    static enum Gender {
        M, W;//M : Man, W : Women

        //인자에 따라 남자 또는 여자 객체 반환
        public static Gender getGender(String input) {
            if (input.equalsIgnoreCase("남")) {
                return M;
            } else if (input.equalsIgnoreCase("여")) {
                return W;
            }
            throw new RuntimeException("올바르지 않은 성별 입력입니다(\"남\" or \"여\")");
        }
    }

}
