package programmers.lv2.그리디;

import java.util.Stack;

public class PGS_LV2_그리디_큰수만들기 {
	public String solution(String number, int k) {
        String answer = "";
        
        Stack<Character> stack = new Stack<>();
        
        int cnt = 0;
        for(int i=0,size=number.length();i<size;i++) {
            if(stack.isEmpty()) stack.push(number.charAt(i));
            else {
                while(!stack.isEmpty()) {
                    if(stack.peek() < number.charAt(i)) {
                        if(cnt < k) {
                            stack.pop();
                            cnt++;
                        }
                        else break;
                    } else break;
                }
                
                stack.push(number.charAt(i));
               
            }
        }
        
        int rest = k - cnt;
        while(!stack.isEmpty()) {
            if(rest > 0) stack.pop();
            else answer = stack.pop() + answer;
            rest--;
        }        
        
        return answer;
    }
}
