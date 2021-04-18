package contests;

import java.util.*;

class SolutionWC237 {
    public boolean checkIfPangram(String sentence) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char ch : "qwertyuiopasdfghjklzxcvbnm".toCharArray()) {
            hash.put(ch, 0);
        }
        for (char ch : sentence.toCharArray()) {
            hash.replace(ch, hash.get(ch) + 1);
        }
        for (char ch : "qwertyuiopasdfghjklzxcvbnm".toCharArray()) {
            if (hash.get(ch) == 0) return false;
        }
        return true;
    }

    public int maxIceCream(int[] costs, int coins) {
        List<Integer> list = new ArrayList<>();
        for (int cost : costs) {
            list.add(cost);
        }
        Collections.sort(list);
        int paying = coins;
        int iceCreams = 0;
        for (Integer i : list) {
            paying -= i;
            if (paying < 0)
                return iceCreams;
            iceCreams++;
        }
        return iceCreams;
    }

    long timer;

    static class Task {
        int index;
        int enqueueTime;
        int processingTime;

        Task(int[] task, int index) {
            this.index = index;
            enqueueTime = task[0];
            processingTime = task[1];
        }
    }

    List<Task> taskList, goList;

    List<Task> makeTaskList(int[][] tasks) {
        List<Task> list = new ArrayList<>();
        for (int i = 0, tasksLength = tasks.length; i < tasksLength; i++) {
            list.add(new Task(tasks[i], i));
        }
        list.sort(Comparator.
                comparingInt(task1 -> task1.enqueueTime));
        return list;
    }

    void idleTime() {
        if (taskList.size() == 0) return;
        timer = taskList.get(0).enqueueTime;
    }

    Task nextTask() {
        while (taskList.size() != 0 && timer <= taskList.get(0).enqueueTime) {
            goList.add(taskList.remove(0));
        }
        if (goList.size() == 0) {
            if (taskList.size() == 0)
                return null;
            idleTime();
        }
        goList.sort(Comparator.<Task>
                comparingInt(task1 -> task1.processingTime)
                .thenComparingInt(task2 -> task2.index));
        return goList.remove(0);
    }

    public int[] getOrder(int[][] tasks) {
        timer = 0;
        goList = new ArrayList<>();
        taskList = makeTaskList(tasks);
        Task t = nextTask();
        List<Task> resultList = new ArrayList<>();
        while (t!=null) {
            resultList.add(t);
            t = nextTask();
        }
        int resultListSize = resultList.size();
        int[] result = new int[resultListSize];
        for (int i = 0; i < resultListSize; i++) {
            result[i] = resultList.remove(0).index;
        }
        return result;
    }
}

public class WeeklyContest237 {
    public static void main(String[] args) {
        SolutionWC237 solution = new SolutionWC237();
        int[][] inputT;
        int[] resultGO;

        // Example 1
        inputT = new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        resultGO = solution.getOrder(inputT);
        System.out.println("[0,2,3,1] == " + Arrays.toString(resultGO));

        // Example 2
        inputT = new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
        resultGO = solution.getOrder(inputT);
        System.out.println("[4,3,2,0,1] == " + Arrays.toString(resultGO));

        /////////////////////////////////
        int[] inputCosts;
        int inputCoins;
        int resultMIC;

        // Example 1
        inputCosts = new int[]{1, 3, 2, 4, 1};
        inputCoins = 7;
        resultMIC = solution.maxIceCream(inputCosts, inputCoins);
        System.out.println("4 == " + resultMIC);

        // Example 2
        inputCosts = new int[]{10, 6, 8, 7, 7, 8};
        inputCoins = 5;
        resultMIC = solution.maxIceCream(inputCosts, inputCoins);
        System.out.println("0 == " + resultMIC);

        // Example 3
        inputCosts = new int[]{1, 6, 3, 1, 2, 5};
        inputCoins = 20;
        resultMIC = solution.maxIceCream(inputCosts, inputCoins);
        System.out.println("6 == " + resultMIC);

        /////////////////////////////////
        String inputS;
        boolean result;

        // Example 1
        inputS = "thequickbrownfoxjumpsoverthelazydog";
        result = solution.checkIfPangram(inputS);
        System.out.println("true == " + result);

        // Example 2
        inputS = "leetcode";
        result = solution.checkIfPangram(inputS);
        System.out.println("false == " + result);
    }
}
