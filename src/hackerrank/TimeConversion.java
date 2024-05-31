package hackerrank;

public class TimeConversion {
    static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2)), min = Integer.parseInt(s.substring(3, 5)), sec = Integer.parseInt(s.substring(6, 8));
        String meridium = s.substring(8);
        if ("AM".equals(meridium) && 12 == hour) {
            hour -= 12;
        } else if ("PM".equals(meridium) && 12 != hour) {
            hour += 12;
        }
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}
