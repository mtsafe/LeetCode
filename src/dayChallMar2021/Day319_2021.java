package dayChallMar2021;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class SolutionDay319 {
    List<List<Integer>> roomsTest;
    HashSet<Integer> unvisited;
    HashSet<Integer> keyRing;

    private void visitRoom(int keysInside) {
        unvisited.remove(keysInside);
        keyRing.addAll(roomsTest.get(keysInside));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null) return false;
        unvisited = new HashSet<>();
        keyRing = new HashSet<>();
        roomsTest = rooms;
        int maxRoom = roomsTest.size();
        keyRing.add(0);
        for (int i = 0; i < maxRoom; i++) {
            unvisited.add(i);
        }
        int prevUnvisitedSize = -1;
        while (prevUnvisitedSize != unvisited.size()) {
            prevUnvisitedSize = unvisited.size();
            HashSet<Integer> tmp = new HashSet<>(unvisited);
            for (int i : tmp) {
                if (keyRing.contains(i))
                    visitRoom(i);
            }
        }
        return unvisited.size() == 0;
    }
}

public class Day319_2021 {
    public static void main(String[] args) {
        SolutionDay319 solution = new SolutionDay319();
        List<List<Integer>> input;
        List<Integer> list;
        boolean result;

        // Trivial 1
        input = new ArrayList<>();
        list = new ArrayList<>();
        list.add(0);
        input.add(list);
        result = solution.canVisitAllRooms(input);
        System.out.println("Trivial 1 ------------------ true == " + result);

        // Trivial 2
        input = new ArrayList<>();
        list = new ArrayList<>();
        list.add(1);
        input.add(list);
        list = new ArrayList<>();
        list.add(0);
        input.add(list);
        result = solution.canVisitAllRooms(input);
        System.out.println("Trivial 2 ------------------ true == " + result);

        // Trivial 3
        input = new ArrayList<>();
        list = new ArrayList<>();
        list.add(1);
        list.add(0);
        input.add(list);
        list = new ArrayList<>();
        input.add(list);
        result = solution.canVisitAllRooms(input);
        System.out.println("Trivial 3 ------------------ true == " + result);

        // Trivial 4
        input = new ArrayList<>();
        list = new ArrayList<>();
        list.add(0);
        input.add(list);
        list = new ArrayList<>();
        list.add(0);
        input.add(list);
        result = solution.canVisitAllRooms(input);
        System.out.println("Trivial 4 ------------------ false == " + result);

        // Trivial 5
        input = new ArrayList<>();
        list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        input.add(list);
        list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        input.add(list);
        list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        input.add(list);
        list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        input.add(list);
        result = solution.canVisitAllRooms(input);
        System.out.println("Trivial 5 ------------------ true == " + result);

        // Example 1
        input = new ArrayList<>();
        list = new ArrayList<>();
        list.add(1);
        input.add(list);
        list = new ArrayList<>();
        list.add(2);
        input.add(list);
        list = new ArrayList<>();
        list.add(3);
        input.add(list);
        list = new ArrayList<>();
        input.add(list);
        result = solution.canVisitAllRooms(input);
        System.out.println("Example 1 ------------------ true == " + result);

        // Example 2
        input = new ArrayList<>();
        list = new ArrayList<>();
        list.add(1);
        list.add(3);
        input.add(list);
        list = new ArrayList<>();
        list.add(3);
        list.add(0);
        list.add(1);
        input.add(list);
        list = new ArrayList<>();
        list.add(2);
        input.add(list);
        list = new ArrayList<>();
        list.add(0);
        input.add(list);
        result = solution.canVisitAllRooms(input);
        System.out.println("Example 2 ------------------ false == " + result);
    }
}
