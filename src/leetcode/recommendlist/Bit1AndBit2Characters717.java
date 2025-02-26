package leetcode.recommendlist;

public class Bit1AndBit2Characters717 {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if (bits[len-1] == 1) {
            return false;
        }

        for (int i=0;i<len;i++) {
            if (bits[i] == 1) {
                i++;
            } else {
                if (i == len-1 && bits[i] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
