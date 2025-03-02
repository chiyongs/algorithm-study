package leetcode.recommendlist;

import java.util.*;

public class FloodFill733 {
    int[] dirX = {-1,1,0,0};
    int[] dirY = {0,0,-1,1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sourceColor = image[sr][sc];
        image[sr][sc] = color;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d=0;d<4;d++) {
                int dx = cur[0] + dirX[d];
                int dy = cur[1] + dirY[d];

                if (0<=dx&&dx<image.length&&0<=dy&&dy<image[0].length&&image[dx][dy]==sourceColor) {
                    if (sourceColor == color) {
                        continue;
                    }
                    image[dx][dy] = color;
                    q.offer(new int[]{dx,dy});
                }
            }
        }
        return image;
    }
}
