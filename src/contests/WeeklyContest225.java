package contests;

import java.util.HashMap;

class SolutionWC225 {
    private String setHour(String time) {
        char[] arr = time.toCharArray();
        switch (arr[0]) {
            case '0':
            case '1':
                if (arr[1] == '?')
                    arr[1] = '9';
                break;
            case '2':
                if (arr[1] == '?')
                    arr[1] = '3';
                break;
            case '?':
                switch (arr[1]) {
                    case '?':
                        arr[1] = '3';
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                        arr[0] = '2';
                        break;
                    default:
                        arr[0] = '1';
                        break;
                }
        }
        return new String(arr);
    }

    private String setMinute(String time) {
        char[] arr = time.toCharArray();
        if (arr[3] == '?')
            arr[3] = '5';
        if (arr[4] == '?')
            arr[4] = '9';
        return new String(arr);
    }

    public String maximumTime(String time) {
        return setMinute(setHour(time));
    }

    private HashMap<Character, Integer> hashMapTheString(String a) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (Character ch : a.toCharArray()) {
            if (hash.containsKey(ch))
                hash.replace(ch, hash.get(ch) + 1);
            else
                hash.put(ch, 1);
        }
        return hash;
    }

    public char maxValKey(HashMap<Character, Integer> hash) {
        char maxKey = 'a';
        int maxVal = 0;
        for (Character key : hash.keySet()) {
            if (hash.get(key) > maxVal) {
                maxVal = hash.get(key);
                maxKey = key;
            }
        }
        return maxKey;
    }

    public char minValKey(HashMap<Character, Integer> hash) {
        char minKey = 'z';
        int minVal = 100000;
        for (Character key : hash.keySet()) {
            if (hash.get(key) > minVal) {
                minVal = hash.get(key);
                minKey = key;
            }
        }
        return minKey;
    }

    private void removeLessThanKey(HashMap<Character, Integer> hash, char ch) {
        for (Character key: hash.keySet()) {
            if (key < ch) {
                hash.remove(key);
            }
        }
    }

    private void removeGreaterThanKey(HashMap<Character, Integer> hash, char ch) {
        for (Character key: hash.keySet()) {
            if (key > ch) {
                hash.remove(key);
            }
        }
    }

    public int conditionA(String a, String b) {
        HashMap<Character, Integer> hashA = hashMapTheString(a);
        HashMap<Character, Integer> hashB = hashMapTheString(b);
        char maxA = maxValKey(hashA);
        char minB = minValKey(hashB);
        removeLessThanKey(hashA, minB);
        removeGreaterThanKey(hashB, maxA);
        return 1000000;
    }

    public int conditionB(String a, String b) {
        return conditionA(b, a);
    }

    public int conditionC(String a, String b) {
        HashMap<Character, Integer> hashA = hashMapTheString(a);
        HashMap<Character, Integer> hashB = hashMapTheString(b);
        int changesNeeded;
        int maxVal = 0;
        for (Integer i: hashA.values())
            maxVal = Math.max(maxVal, i);
        changesNeeded = a.length() - maxVal;
        maxVal = 0;
        for (Integer i: hashB.values())
            maxVal = Math.max(maxVal, i);
        changesNeeded += b.length() - maxVal;
        return changesNeeded;
    }

    public int minCharacters(String a, String b) {
        int result = conditionA(a, b);
        System.out.println("resultA "+result);
        result = Math.min(result, conditionB(a, b));
        System.out.println("resultB "+result);
        return Math.min(result, conditionC(a, b));
    }
}

public class WeeklyContest225 {
    public static void main(String[] args) {
        SolutionWC225 solution = new SolutionWC225();
        String result, input;

        input = "2?:?0";
        result = solution.maximumTime(input);
        System.out.println(input+" => "+result+"==23:50");

        input = "0?:3?";
        result = solution.maximumTime(input);
        System.out.println(input+" => "+result+"==09:39");

        input = "1?:22";
        result = solution.maximumTime(input);
        System.out.println(input+" => "+result+"==19:22");

        int resultInt;

        resultInt = solution.minCharacters("aba", "caa");
        System.out.println("2 == "+resultInt);

        resultInt = solution.minCharacters("dabadd", "cda");
        System.out.println("2 == "+resultInt);
    }
}
