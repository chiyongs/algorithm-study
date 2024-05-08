package programmers;

public class 멀쩡한사각형 {

    public static void main(String[] args) {
        멀쩡한사각형 m = new 멀쩡한사각형();
        System.out.println(m.solution(8, 12));
        System.out.println(m.solution(10, 5));
        System.out.println(m.solution(1, 1));
        System.out.println(m.solution(2, 4));
        System.out.println(m.solution(2, 5));
    }
    static double X,Y;

    public long solution(int w, int h) {
        long answer = 0;
        X = w;
        Y = h;
        // int 범위를 넘어갈 수 있기 때문에 캐스팅을 먼저 해줘야 함
        long total = (long) w * (long) h;
        for(int i=0;i<w;i++) {
            double left = getY(i);
            double right = getY(i+1);

            double cnt = Math.ceil(right) - Math.floor(left);
            answer += cnt;
        }

        return total - answer;
    }

    // (Y / X) * x 의 경우 소숫점에 대한 곱셈이므로 정확하지 않을 수 있음
    // 따라서, 먼저 곱셈을 진행한 후 나눗셈을 하는 것이 정확한 연산의 결과를 만들어낼 수 있음
    double getY(int x) {
        return (Y * x) / X;
    }
}
