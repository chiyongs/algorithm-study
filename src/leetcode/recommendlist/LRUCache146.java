package leetcode.recommendlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

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
            if (map.size() >= capacity) {
                Cache last = linkedList.getLast();
                map.remove(last.key);
                linkedList.removeLast();
            }
            Cache cache = new Cache(key, value);
            map.put(key, cache);
            linkedList.addFirst(cache);
        }

    }
}
