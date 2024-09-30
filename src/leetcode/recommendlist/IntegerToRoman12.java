package leetcode.recommendlist;

public class IntegerToRoman12 {
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();

        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                roman.append(strs[i]);
            }
        }
        return roman.toString();
    }
}
