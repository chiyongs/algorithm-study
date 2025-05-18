package leetcode.recommendlist;

public class DistanceBetweenBusStops1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int totalDist=0;
        int clockwise=0;

        for(int i=0;i<distance.length;i++){
            totalDist+=distance[i];
        }

        if(start> destination){
            int tmp=start;
            start=destination;
            destination= tmp;
        }
        for(int i=start; i< destination;i++){
            clockwise+=distance[i];
        }

        return Math.min(clockwise, totalDist-clockwise);
    }
}
