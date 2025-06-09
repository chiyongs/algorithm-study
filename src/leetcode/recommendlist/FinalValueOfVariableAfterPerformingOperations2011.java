package leetcode.recommendlist;

public class FinalValueOfVariableAfterPerformingOperations2011 {
    public int finalValueAfterOperations(String[] operations) {
        int value = 0;
        for (String operation : operations) {
            if (operation.charAt(0) == '+' || operation.charAt(operation.length() - 1) == '+') {
                value++;
            } else {
                value--;
            }
        }
        return value;
    }
}
