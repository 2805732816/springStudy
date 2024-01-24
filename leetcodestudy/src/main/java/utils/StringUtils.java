package utils;

public class StringUtils {
    public static String stingArrayToString(String[] strs){
        String result = String.join(",",strs);
        return "["+result+"]";
    }


    public static void main(String[] args) {
        System.out.println(StringUtils.stingArrayToString(new String[]{"1","2","3"}));
    }
}
