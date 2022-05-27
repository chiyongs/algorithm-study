package programmers.lv1.그리디;

public class 체육복 {

	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	        int answer = 0;
	        
	        int[] students = new int[n+1];
	        for(int i=1;i<=n;i++) {
	            students[i] = 1;
	            for(int j=0;j<reserve.length;j++) {
	                if(i==reserve[j]) students[i]++;
	            }
	            for(int j=0;j<lost.length;j++) {
	                if(i==lost[j]) students[i]--;
	            }
	        }
	        
	        for(int i=1;i<=n;i++) {
	            if(students[i] == 0) {
	                if(students[i-1] > 1) {
	                    students[i]++;
	                    students[i-1]--;
	                }
	                else if(i<n && students[i+1] > 1) {
	                    students[i]++;
	                    students[i+1]--;
	                }
	            }
	        }
	        
	        for(int i=1;i<=n;i++) {
	            if(students[i]>=1) answer++;
	        }
	        return answer;
	    }
	}

}
