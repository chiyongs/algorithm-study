package leetcode.recommendlist;

public class GoalParserInterpretation1678 {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<command.length();i++) {
            char c = command.charAt(i);
            if (c == 'G') {
                sb.append("G");
            } else if (c == '(') {
                char next = command.charAt(i+1);
                if (next == ')') {
                    sb.append("o");
                    i++;
                } else {
                    sb.append("al");
                    i+=3;
                }
            }
        }
        return sb.toString();
    }
}
