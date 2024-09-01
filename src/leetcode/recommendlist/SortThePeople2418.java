package leetcode.recommendlist;

import java.util.*;

public class SortThePeople2418 {
    static class People {
        String name;
        int height;

        People(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int count = names.length;

        People[] peoples = new People[count];
        for (int i=0;i<count;i++) {
            People p = new People(names[i], heights[i]);
            peoples[i] = p;
        }

        Arrays.sort(peoples, (p1, p2) -> p2.height - p1.height);
        String[] result = new String[count];
        for (int i=0;i<count;i++) {
            result[i] = peoples[i].name;
        }
        return result;
    }
}
