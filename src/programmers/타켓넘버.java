package programmers;

public class 타켓넘버 {

    static int answer;
    static int TARGET;
    static int[] nums;

    public int solution(int[] numbers, int target) {
        TARGET = target;
        nums = numbers;
        answer = 0;
        dfs(0, 0);
        return answer;
    }

    void dfs(int sum, int cur) {
        if (cur == nums.length) {
            if (sum == TARGET) answer++;
        } else {
            dfs(sum + nums[cur], cur+1);
            dfs(sum - nums[cur], cur+1);
        }
    }
}
