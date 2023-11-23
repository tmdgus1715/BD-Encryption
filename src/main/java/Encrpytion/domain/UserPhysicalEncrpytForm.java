package Encrpytion.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPhysicalEncrpytForm {
    private String name;
    private String age;
    private Integer tall;
    private Integer weight;
    private UserPhysicalInfo.Gender gender;
}
