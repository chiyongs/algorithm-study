package leetcode.recommendlist;

public class NumberOfEmployeesWhoMetTheTarget2798 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int cnt = 0;

        for (int hour : hours) {
            if (hour >= target) {
                cnt++;
            }
        }
        return cnt;
    }
}
