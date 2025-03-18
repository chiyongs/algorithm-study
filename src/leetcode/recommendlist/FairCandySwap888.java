package leetcode.recommendlist;

import java.util.*;

public class FairCandySwap888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumOfAlice = 0;
        for (int alice : aliceSizes) {
            sumOfAlice += alice;
        }

        Set<Integer> set = new HashSet<>();
        int sumOfBob = 0;
        for (int bob : bobSizes) {
            sumOfBob += bob;
            set.add(bob);
        }

        int diff = sumOfAlice - sumOfBob;

        for (int alice : aliceSizes) {
            int target = (alice * 2 - diff) / 2;
            if (set.contains(target)) {
                return new int[] { alice, target };
            }
        }
        return null;
    }

    /**
     * public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
     * int sumOfAlice = 0;
     * for (int alice : aliceSizes) {
     * sumOfAlice += alice;
     * }
     *
     * int sumOfBob = 0;
     * for (int bob : bobSizes) {
     * sumOfBob += bob;
     * }
     *
     * int diff = sumOfAlice - sumOfBob;
     *
     * for (int alice : aliceSizes) {
     * int doubleAlice = alice * 2;
     * for (int bob : bobSizes) {
     * int doubleBob = bob * 2;
     * if (doubleAlice == diff + doubleBob) {
     * return new int[] {alice, bob};
     * }
     * }
     * }
     * return null;
     * }
     */
}
