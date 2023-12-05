package Encrpytion.util;

/**
 * 데이터 마스킹
 */
public class DataMasker {
    public static String mask(String str) {
        if (str.length() <= 1) {
            return str;
        }

        String firstName = str.substring(0, 1);
        String maskedName = firstName + "x".repeat(str.length() - 1);

        return maskedName;
    }
}
