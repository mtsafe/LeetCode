package dayChallJan2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionDay009 {
    private boolean isOneAway(String a, String b) {
        int numAway = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                if (++numAway > 1)
                    return false;
        }
        return numAway == 1;
    }

    public int ladderLengthRecurse(String beginWord, String endWord, List<String> wordList) {
        System.out.println("ladderLengthRecurse ("+beginWord+" "+endWord+" "+
            wordList.toString()+")");

        // Three Trivial Cases
        if (beginWord.equals(endWord))
            return 1;
        if (isOneAway(beginWord, endWord)) {
            System.out.println("MATCHED: "+beginWord+" "+endWord);
            System.out.println("RETURN 2");
            return 2;
        }
        if (wordList.size() == 0)
            return 0;

        // Move words OneAway to the queue
        // If a word in the queue is OneAway from beginWord then it is solved
        ArrayList<String> mutableList = new ArrayList<>(wordList);
        ArrayList<String> mutableListQueue = new ArrayList<>();
        for (String word : wordList) {
            if (isOneAway(word, endWord)) {
                if (isOneAway(beginWord, word)) {
                    System.out.println("MATCHED: "+beginWord+" "+word);
                    System.out.println("RETURN 3");
                    return 3;
                }
                mutableListQueue.add(word);
                mutableList.remove(word);
            }
        }
        System.out.println("Q: "+mutableListQueue.toString());
        System.out.println("L: "+mutableList.toString());

        //
        int result = 0;
        for (String word : mutableListQueue) {
            result += ladderLengthRecurse(beginWord, word, mutableList);
            if (result > 0) {
                result++;
                System.out.println("RETURN "+result);
                return result;
            }
        }
        System.out.println("RETURN "+result);
        return result;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ArrayList<String> mutableList = new ArrayList<>(wordList);
        if (mutableList.size() == 0 || !mutableList.remove(endWord))
            return 0;
        return ladderLengthRecurse(beginWord, endWord, mutableList);
    }
}

public class Day009_2021 {
    public static void main(String[] args) {
        SolutionDay009 solution = new SolutionDay009();
        System.out.println("5 == "+
                solution.ladderLength("hit", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println("0 == "+
                solution.ladderLength("hit", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log")));
        System.out.println("2 == "+
                solution.ladderLength("jog", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println("3 == "+
                solution.ladderLength("lop", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println("4 == "+
                solution.ladderLength("det", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println("5 == "+
                solution.ladderLength("mit", "cog",
                        Arrays.asList("hit", "jit",
                                "hot", "jot", "mot",
                                "dot", "lot",
                                "dog", "log",
                                "cog")));
    }
}
