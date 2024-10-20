package leetcode.recommendlist;

import java.util.*;

public class LargestNumber179 {
    static class MyNumber implements Comparable<MyNumber> {
        String str;

        public MyNumber(int n) {
            this.str = String.valueOf(n);
        }

        public int compareTo(MyNumber m) {
            String s1 = this.str + m.str;
            String s2 = m.str + this.str;
            return s2.compareTo(s1);
        }
    }

    public String largestNumber(int[] nums) {
        List<MyNumber> list = new ArrayList<>();
        for (int num : nums) {
            list.add(new MyNumber(num));
        }

        Collections.sort(list);
        if (list.get(0).str.charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (MyNumber mn : list) {
            sb.append(mn.str);
        }
        return sb.toString();
    }
}
