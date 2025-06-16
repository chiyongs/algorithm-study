package leetcode.recommendlist;

public class DesignParkingSystem1603 {
    class ParkingSystem {

        static class ParkingSpace {
            int totalSize;
            int parkedCnt;

            ParkingSpace(int size) {
                this.totalSize = size;
                this.parkedCnt = 0;
            }

            boolean parkIfAvailable() {
                if (totalSize > parkedCnt) {
                    parkedCnt++;
                    return true;
                } else {
                    return false;
                }
            }
        }

        ParkingSpace big;
        ParkingSpace medium;
        ParkingSpace small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = new ParkingSpace(big);
            this.medium = new ParkingSpace(medium);
            this.small = new ParkingSpace(small);
        }

        public boolean addCar(int carType) {
            if (carType == 1) {
                return big.parkIfAvailable();
            } else if (carType == 2) {
                return medium.parkIfAvailable();
            } else {
                return small.parkIfAvailable();
            }
        }
    }

}
