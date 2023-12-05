package Encrpytion.mapper;

public class Mapper {
    public Mapper() {
    }
    // 나이 범주화 메서드
    private Integer categorizeAge_int(int age) {
        return (age % 10) * 10;
    }
    private String categorizeAge_string(int age) {
        int categorizeAge = (age % 10) * 10;
        return String.format("%d~%d", categorizeAge, categorizeAge +9);
    }
}
