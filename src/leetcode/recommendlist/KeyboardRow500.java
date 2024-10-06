package leetcode.recommendlist;

import java.util.*;

public class KeyboardRow500 {
    Set<Character> first = Set.of('q','w','e','r','t','y','u','i','o','p');
    Set<Character> second = Set.of('a','s','d','f','g','h','j','k','l');
    Set<Character> third = Set.of('z','x','c','v','b','n','m');

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for(String word : words) {
            boolean firstFlag = false;
            boolean secondFlag = false;
            boolean thirdFlag = false;
            char firstCh = Character.toLowerCase(word.charAt(0));
            if (first.contains(firstCh)) {
                firstFlag = true;
            } else if (second.contains(firstCh)) {
                secondFlag = true;
            } else {
                thirdFlag = true;
            }
            boolean addStr = true;
            for(char ch : word.toCharArray()) {
                ch = Character.toLowerCase(ch);
                if (firstFlag) {
                    if (!first.contains(ch)) {
                        addStr = false;
                        break;
                    }
                } else if (secondFlag) {
                    if (!second.contains(ch)) {
                        addStr = false;
                        break;
                    }
                } else {
                    if (!third.contains(ch)) {
                        addStr = false;
                        break;
                    }
                }
            }
            if (addStr) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
