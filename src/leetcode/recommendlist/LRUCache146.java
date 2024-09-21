package leetcode.recommendlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache146 {

    static class LRUCache {

        class Cache {
            int key, value;

            Cache(int k, int v) {
                this.key = k;
                this.value = v;
            }
        }

        int capacity;
        LinkedList<Cache> linkedList;
        Map<Integer, Cache> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            linkedList = new LinkedList<>();
            map = new HashMap<>();
        }

        public int get(int key) {
            Cache cache = map.getOrDefault(key, null);
            if (cache == null) {
                return -1;
            }
            Cache first = linkedList.getFirst();
            if (first.key != key) {
                linkedList.remove(cache);
                linkedList.addFirst(cache);
            }
            return cache.value;
        }

        public void put(int key, int value) {
            Cache cache = map.getOrDefault(key, null);
            if (cache == null) {
                cache = new Cache(key, value);
                if (map.size() >= capacity) {
                    Cache last = linkedList.getLast();
                    map.remove(last.key);
                    linkedList.remove(last);
                }
                map.put(key, cache);
                linkedList.addFirst(cache);
            } else {
                cache.value = value;
                linkedList.remove(cache);
                map.put(key, cache);
                linkedList.addFirst(cache);
            }
        }

    }
}
