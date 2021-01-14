package dailyChallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class SolutionDay013 {
    public int numRescueBoats(int[] people, int limit) {
        HashMap<Integer, Integer> peopleHash = new HashMap<>();
        int boatCnt = 0;
        System.out.println("boatCnt: " + boatCnt);
        for (int person : people) {
            if (person >= limit) {
                boatCnt++;
                System.out.println("boatCnt: " + boatCnt);
                continue;
            }
            if (peopleHash.containsKey(person))
                peopleHash.replace(person, peopleHash.get(person) + 1);
            else
                peopleHash.put(person, 1);
        }
        List<Integer> weights = new ArrayList<>(peopleHash.keySet());
        weights.sort(Collections.reverseOrder());

        int weightCnt0, weightCnt1, diff;
        for (int weight : weights) {
            if (!peopleHash.containsKey(weight))
                continue;
            weightCnt0 = peopleHash.get(weight);
            diff = limit - weightCnt0;
            for (int i = diff; i > 0; ) {
                while (!weights.contains(i)) {
                    i--;
                }
                if (!peopleHash.containsKey(i))
                    continue;
                weightCnt1 = peopleHash.get(i);
                int boatAdd = Math.min(weightCnt0, weightCnt1);
                boatCnt += boatAdd;
                System.out.println("boatCnt: " + boatCnt);
                weightCnt0 -= boatAdd;
                weightCnt1 -= boatAdd;
                if (weightCnt1 == 0) {
                    peopleHash.remove(i);
                    if (weights.size() >= i + 1) {
                        if (weightCnt0 == 0)
                            peopleHash.remove(weight);
                        else
                            peopleHash.replace(weight, weightCnt0);
                        break;
                    }
                    i = weights.get(weights.indexOf(i) + 1);
                } else {
                    peopleHash.replace(i, weightCnt1);
                }
                if (weightCnt0 == 0) {
                    peopleHash.remove(weight);
                    break;
                }
            }
        }
        return boatCnt;
    }
}

public class Day013_2021 {
    public static void main(String[] args) {
        SolutionDay013 solution = new SolutionDay013();
        int sendBoats;
        sendBoats = solution.numRescueBoats(new int[]{3}, 3);
        System.out.println(sendBoats);
        sendBoats = solution.numRescueBoats(new int[]{1, 3, 3, 3}, 3);
        System.out.println(sendBoats);
    }
}
