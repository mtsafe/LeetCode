package dayChallMar2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SolutionDay307 {
    public class MyHashMap {
        List<LinkedList<Integer[]>> table;
        final int tableCapacity = 10007;

        private Integer[] find(int key) {
            int index = key % tableCapacity;
            LinkedList<Integer[]> list = table.get(index);
            if (list == null) return null;
            for (Integer[] entry : list) {
                if (entry[0] == key)
                    return entry;
            }
            return null;
        }

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            table = new ArrayList<LinkedList<Integer[]>>(tableCapacity);
            for (int i = 0; i < tableCapacity; i++) {
                table.add(i, null);
            }
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            Integer[] entry = find(key);
            if (entry != null) {
                entry[1] = value;
                return;
            }
            int index = key % tableCapacity;
            LinkedList<Integer[]> list = table.get(index);
            if (list == null) {
                list = new LinkedList<>();
                table.set(index, list);
            }
            entry = new Integer[2];
            entry[0] = key;
            entry[1] = value;
            list.add(entry);
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            Integer[] pair = find(key);
            if (pair == null)
                return -1;
            return pair[1];
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int index = key % tableCapacity;
            LinkedList<Integer[]> list = table.get(index);
            if (list == null) return;
            for (Integer[] entry : list) {
                if (entry[0] == key) {
                    list.remove(entry);
                    return;
                }
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class Day307_2021 {
    public static void main(String[] args) {
        SolutionDay307 solution = new SolutionDay307();

        // Trivial
        SolutionDay307.MyHashMap hash = solution.new MyHashMap();
        hash.put(17, 17);
        System.out.println("17 == " + hash.get(17));
        hash.remove(17);
        System.out.println("-1 == " + hash.get(17));

        // Example
        hash = solution.new MyHashMap();
        hash.put(1, 1);
        hash.put(2, 2);
        System.out.println("1 == " + hash.get(1));
        System.out.println("-1 == " + hash.get(3));
        hash.put(2, 1);
        System.out.println("1 == " + hash.get(2));
        hash.remove(2);
        System.out.println("-1 == " + hash.get(2));

        // Test 1
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        hash = solution.new MyHashMap();
        hash.put(65, 65);
        System.out.println("65 == " + hash.get(65));
        System.out.println("--------");
        hash.put(42, 0);
        System.out.println("65 == " + hash.get(65));
        System.out.println("0 == " + hash.get(42));
        System.out.println("--------");
        hash.put(17, 90);
        System.out.println("65 == " + hash.get(65));
        System.out.println("0 == " + hash.get(42));
        System.out.println("90 == " + hash.get(17));
        System.out.println("--------");
        hash.put(31, 76);
        System.out.println("65 == " + hash.get(65));
        System.out.println("0 == " + hash.get(42));
        System.out.println("90 == " + hash.get(17));
        System.out.println("76 == " + hash.get(31));
        System.out.println("--------");
        hash.put(48, 71);
        System.out.println("65 == " + hash.get(65));
        System.out.println("0 == " + hash.get(42));
        System.out.println("90 == " + hash.get(17));
        System.out.println("76 == " + hash.get(31));
        System.out.println("71 == " + hash.get(48));
        System.out.println("--------");
        hash.put(5, 50);
        System.out.println("65 == " + hash.get(65));
        System.out.println("0 == " + hash.get(42));
        System.out.println("90 == " + hash.get(17));
        System.out.println("76 == " + hash.get(31));
        System.out.println("71 == " + hash.get(48));
        System.out.println("50 == " + hash.get(5));


        // Test Case 1
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        // [[],[27],[65,65],[19],[0],[18],[3],[42,0],[19],[42],
        hash = solution.new MyHashMap();
        hash.remove(27);
        hash.put(65, 65);
        hash.remove(19);
        hash.remove(0);
        hash.get(18);
        System.out.println("-1 == " + hash.get(18));
        hash.remove(3);
        hash.put(42, 0);
        hash.get(19);
        System.out.println("-1 == " + hash.get(19));
        hash.remove(42);
        // [17,90],[31,76],[48,71],[5,50],[7,68],[73,74],[85,18],[74,95],[84,82],[59,29],
        hash.put(17, 90);
        System.out.println("90 == " + hash.get(17));
        hash.put(31, 76);
        System.out.println("76 == " + hash.get(31));
        System.out.println("90 == " + hash.get(17));
        hash.put(48, 71);
        System.out.println("71 == " + hash.get(48));
        System.out.println("90 == " + hash.get(17));
        hash.put(5, 50);
        System.out.println("50 == " + hash.get(5));
        System.out.println("90 == " + hash.get(17)); // FAIL -1
        hash.put(7, 68);
        System.out.println("68 == " + hash.get(7));
        System.out.println("90 == " + hash.get(17));
        hash.put(73, 74);
        System.out.println("74 == " + hash.get(73));
        System.out.println("90 == " + hash.get(17));
        hash.put(85, 18);
        System.out.println("18 == " + hash.get(85));
        System.out.println("90 == " + hash.get(17));
        hash.put(74, 95);
        System.out.println("95 == " + hash.get(74));
        System.out.println("90 == " + hash.get(17));
        hash.put(84, 82);
        System.out.println("90 == " + hash.get(17));
        hash.put(59, 29);
        System.out.println("90 == " + hash.get(17));
        // [71,71],[42],[51,40],[33,76],[17]
        hash.put(71, 71);
        System.out.println("90 == " + hash.get(17));
        hash.remove(42);
        System.out.println("90 == " + hash.get(17));
        hash.put(51, 40);
        System.out.println("90 == " + hash.get(17));
        hash.put(33, 76);
        hash.get(17);
        System.out.println("90 == " + hash.get(17));
        /*
        Input:
        ["MyHashMap","remove","put","remove","remove","get","remove","put","get","remove",
        "put","put","put","put","put","put","put","put","put","put",
        "put","remove","put","put","get","put","get","put","put","get","put","remove","remove","put","put","get","remove","put","put","put","get","put","put","remove","put","remove","remove","remove","put","remove","get","put","put","put","put","remove","put","get","put","put","get","put","remove","get","get","remove","put","put","put","put","put","put","get","get","remove","put","put","put","put","get","remove","put","put","put","put","put","put","put","put","put","put","remove","remove","get","remove","put","put","remove","get","put","put"]
        [[],[27],[65,65],[19],[0],[18],[3],[42,0],[19],[42],
        [17,90],[31,76],[48,71],[5,50],[7,68],[73,74],[85,18],[74,95],[84,82],[59,29],
        [71,71],[42],[51,40],[33,76],[17],[89,95],[95],[30,31],[37,99],[51],[95,35],[65],[81],[61,46],[50,33],[59],[5],[75,89],[80,17],[35,94],[80],[19,68],[13,17],[70],[28,35],[99],[37],[13],[90,83],[41],[50],[29,98],[54,72],[6,8],[51,88],[13],[8,22],[85],[31,22],[60,9],[96],[6,35],[54],[15],[28],[51],[80,69],[58,92],[13,12],[91,56],[83,52],[8,48],[62],[54],[25],[36,4],[67,68],[83,36],[47,58],[82],[36],[30,85],[33,87],[42,18],[68,83],[50,53],[32,78],[48,90],[97,95],[13,8],[15,7],[5],[42],[20],[65],[57,9],[2,41],[6],[33],[16,44],[95,30]]

        Output:
        [null,null,null,null,null,-1,null,null,-1,null,
        null,null,null,null,null,null,null,null,null,null,
        null,null,null,null,-1,null,-1,null,null,-1,
        null,null,null,null,null,-1,null,null,null,null,
        -1,null,null,null,null,null,null,null,null,null,
        -1,null,null,null,null,null,null,-1,null,null,
        -1,null,null,-1,-1,null,null,null,null,null,
        null,null,-1,-1,null,null,null,null,null,-1,
        null,null,null,null,null,null,null,null,null,null,
        null,null,null,-1,null,null,null,null,-1,null,
        null]

        Expected:
        [null,null,null,null,null,-1,null,null,-1,null,
        null,null,null,null,null,null,null,null,null,null,
        null,null,null,null,90,null,-1,null,null,40,
        null,null,null,null,null,29,null,null,null,null,
        17,null,null,null,null,null,null,null,null,null,
        33,null,null,null,null,null,null,18,null,null,
        -1,null,null,-1,35,null,null,null,null,null,
        null,null,-1,-1,null,null,null,null,null,-1,
        null,null,null,null,null,null,null,null,null,null,
        null,null,null,-1,null,null,null,null,87,null,
        null]
         */
    }
}
