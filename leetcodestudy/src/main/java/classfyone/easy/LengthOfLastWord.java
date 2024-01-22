package classfyone.easy;

/**
 * 最后一个单词的长度：给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int result = 0;
        if(s.length()<1){
            return result;
        }
        //去除前后空格
        String[] wordLengthList = s.split(" ");
        return wordLengthList[wordLengthList.length-1].length();
    }

    public static void main(String[] args) {
        String s = "luffy is still joyboy  ";
        System.out.println(LengthOfLastWord.lengthOfLastWord(s));

    }
}
