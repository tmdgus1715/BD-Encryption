package Encrpytion.mapper;

import Encrpytion.domain.UserPhysicalInfo;
public class Mapper {
    public Mapper() {
    }
    // 나이 범주화 메서드
    public Integer categorizeAge(UserPhysicalInfo userInfo) {
        Integer age = userInfo.getAge();
        return (age / 10) * 10;
    }
}