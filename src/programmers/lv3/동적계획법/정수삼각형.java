package programmers.lv3.동적계획법;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] d = new int[triangle.length][];
        for(int i=0;i<d.length;i++) {
            d[i] = new int[triangle[i].length];
        }
        d[0][0] = triangle[0][0];

        for(int i=1;i<triangle.length;i++) {
            for(int j=0;j<triangle[i].length;j++) {
                if(j==0) {
                    d[i][0] = d[i-1][0] + triangle[i][0];
                } else if(j==triangle[i].length-1) {
                    d[i][j] = d[i-1][triangle[i-1].length-1] + triangle[i][j];
                } else {
                    d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + triangle[i][j];
                }

            }
            d[i][i] = d[i-1][i-1] + triangle[i][i];
        }

        int max = 0;
        for(int i=0;i<triangle[triangle.length-1].length;i++) {
            max = Math.max(d[triangle.length-1][i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        정수삼각형 T = new 정수삼각형();
        System.out.println(T.solution(triangle));
    }

    static int[][] triangle = 	{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
}
