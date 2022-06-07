package programmers.lv2.그리디;

import java.util.*;

public class 구명보트 {

	class Solution {
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        
	        Arrays.sort(people);
	        
	        int start = 0;
	        int end = people.length - 1;
	        
	        while(start <= end) {
	            int front = people[start];
	            int back = people[end];
	            if(front + back <= limit) {
	                answer++;
	                start++;
	                end--;
	            } else {
	                answer++;
	                end--;
	            }
	        }
	      
	        return answer;
	    }
	}

}
