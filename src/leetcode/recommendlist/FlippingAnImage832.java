package leetcode.recommendlist;

public class FlippingAnImage832 {
    public int[][] flipAndInvertImage(int[][] image) {
        int length = image.length;
        for (int[] row : image) {
            for (int i=0; i*2 < length;i++) {
                if (row[i] == row[length - i - 1]) {
                    row[i] = row[length - i - 1] ^= 1;
                }
            }
        }
        return image;
    }
}
