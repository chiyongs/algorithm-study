package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class BOJ_S5_1181_단어정렬 {

    static class MyString implements Comparable<MyString> {
        String str;

        public MyString(String str) {
            this.str = str;
        }

        @Override
        public int compareTo(MyString o) {
            if (this.str.length() == o.str.length()) {
                return this.str.compareTo(o.str);
            }
            return this.str.length() - o.str.length();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<MyString> treeSet = new TreeSet<>();
        for(int n=0;n<N;n++) {
            treeSet.add(new MyString(br.readLine()));
        }
        StringBuilder sb = new StringBuilder();
        for(MyString ms : treeSet) {
            sb.append(ms.str).append("\n");
        }
        System.out.print(sb.toString());
    }
}
