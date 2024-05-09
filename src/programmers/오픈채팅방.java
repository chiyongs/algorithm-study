package programmers;

import java.util.*;

public class 오픈채팅방 {

    public static void main(String[] args) {
        오픈채팅방 o = new 오픈채팅방();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(o.solution(record)));
    }

    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> userMap = new HashMap<>();
        for(String rec : record) {
            String[] words = rec.split(" ");
            String command = words[0];
            if (command.equals("Enter")) {
                userMap.put(words[1], words[2]);
                answer.add(getEnterMessage(words[1]));
            } else if (command.equals("Leave")) {
                answer.add(getLeaveMessage(words[1]));
            } else if (command.equals("Change")) {
                userMap.put(words[1], words[2]);
            }
        }

        int idx = 0;
        String[] result = new String[answer.size()];
        for(String ans : answer) {
            for(String uid : userMap.keySet()) {
                if (ans.contains(uid)) {
                    String replace = ans.replace(uid, userMap.get(uid));
                    result[idx++] = replace;
                }
            }
        }

        return result;
    }

    String getEnterMessage(String str) {
        return str + "님이 들어왔습니다.";
    }

    String getLeaveMessage(String str) {
        return str + "님이 나갔습니다.";
    }
}
