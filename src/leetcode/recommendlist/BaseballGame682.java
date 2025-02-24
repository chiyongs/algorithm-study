package leetcode.recommendlist;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame682 {

    List<Point> points = new ArrayList<>();

    static class Point {
        int num;
        boolean invalidate;

        public Point(int num) {
            this.num = num;
            this.invalidate = false;
        }
    }

    public int calPoints(String[] operations) {
        for (String operation : operations) {
            if ("+".equals(operation)) {
                Point p1 = getLastValidPoint();
                p1.invalidate = true;
                Point p2 = getLastValidPoint();
                p1.invalidate = false;
                points.add(new Point(p1.num + p2.num));
            } else if ("D".equals(operation)) {
                Point p = getLastValidPoint();
                int d = p.num * 2;
                points.add(new Point(d));
            } else if ("C".equals(operation)) {
                Point p = getLastValidPoint();
                p.invalidate = true;
            } else {
                int num = Integer.parseInt(operation);
                Point p = new Point(num);
                points.add(p);
            }
        }

        int result = 0;
        for (Point p : points) {
            if (!p.invalidate) {
                result += p.num;
            }
        }
        return result;
    }

    private Point getLastValidPoint() {
        int size = points.size();

        for (int i = size - 1; i >= 0; i--) {
            Point cur = points.get(i);
            if (!cur.invalidate) {
                return cur;
            }
        }
        return null;
    }
}
