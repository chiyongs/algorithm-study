package leetcode.recommendlist;

public class DetectCapital520 {
    public boolean detectCapitalUse(String word) {
        char firstCh = word.charAt(0);

        if (Character.isUpperCase(firstCh)) {
            int upperCnt = 0;
            int lowerCnt = 0;
            for (int i=1;i<word.length();i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    upperCnt++;
                } else {
                    lowerCnt++;
                }
            }
            return (upperCnt == 0 && lowerCnt == 0)
                    || (upperCnt > 0 && lowerCnt == 0)
                    || (upperCnt == 0 && lowerCnt > 0);
        } else {
            for (char ch : word.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    return false;
                }
            }
            return true;
        }
    }
}
