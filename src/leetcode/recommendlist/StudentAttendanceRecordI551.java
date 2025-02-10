package leetcode.recommendlist;

public class StudentAttendanceRecordI551 {
    public boolean checkRecord(String s) {
        int absentCnt = 0;
        int lateCnt = 0;
        boolean lateConsecutive = false;

        for (char ch : s.toCharArray()) {
            if (ch == 'P') {
                lateConsecutive = false;
                lateCnt = 0;
                continue;
            } else if (ch == 'A') {
                absentCnt++;
                if (absentCnt > 1) {
                    return false;
                }
                lateConsecutive = false;
                lateCnt = 0;
            } else {
                lateCnt++;
                if (lateCnt >= 3 && lateConsecutive) {
                    return false;
                }
                lateConsecutive = true;
            }
        }
        return true;
    }
}
