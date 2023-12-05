package Encrpytion.util;

/**
 * 나이 범주화
 */
public class AgeCategorizer {

    public static String categorize(Integer age) {
        return (age / 10) *10 + "대";
    }
}
