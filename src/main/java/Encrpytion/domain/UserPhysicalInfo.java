package Encrpytion.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPhysicalInfo {
    private String name;
    private Integer age;
    private Integer tall;
    private Integer weight;
    private Gender gender;

    static enum Gender {
        M, W;
    }

}
