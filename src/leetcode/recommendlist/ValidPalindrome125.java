package leetcode.recommendlist;

public class ValidPalindrome125 {

    static String regex = "[^0-9a-zA-Z]";

    public boolean isPalindrome(String s) {
        s = s.replaceAll(regex, "").toLowerCase();

        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome125 v = new ValidPalindrome125();
        v.isPalindrome("A man, a plan, a canal: Panama");
    }
}
