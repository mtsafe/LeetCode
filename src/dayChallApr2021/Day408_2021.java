package dayChallApr2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SolutionDay408 {
    private HashMap<Character, List<Character>> buildHash() {
        HashMap<Character, List<Character>> hash = new HashMap<>();
        List<Character> list = new ArrayList<>();
        list.add('a');list.add('b');list.add('c');
        hash.put('2', list);
        list = new ArrayList<>();
        list.add('d');list.add('e');list.add('f');
        hash.put('3', list);
        list = new ArrayList<>();
        list.add('g');list.add('h');list.add('i');
        hash.put('4', list);
        list = new ArrayList<>();
        list.add('j');list.add('k');list.add('l');
        hash.put('5', list);
        list = new ArrayList<>();
        list.add('m');list.add('n');list.add('o');
        hash.put('6', list);
        list = new ArrayList<>();
        list.add('p');list.add('q');list.add('r');list.add('s');
        hash.put('7', list);
        list = new ArrayList<>();
        list.add('t');list.add('u');list.add('v');
        hash.put('8', list);
        list = new ArrayList<>();
        list.add('w');list.add('x');list.add('y');list.add('z');
        hash.put('9', list);
        return hash;
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character, List<Character>> hash = buildHash();
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        List<String> newList;
        list.add("");
        for (char ch: digits.toCharArray()) {
            newList = new ArrayList<>();
            for (char chHash: hash.get(ch)) {
                for (String str: list) {
                    newList.add(str+chHash);
                }
            }
            list = newList;
        }
        return list;
    }
}

public class Day408_2021 {
    public static void main(String[] args) {
        SolutionDay408 solution = new SolutionDay408();
        String inputDigits;
        List<String> result;

        // Example 1
        inputDigits = "23";
        result = solution.letterCombinations(inputDigits);
        System.out.println("[\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\"," +
                "\"cd\",\"ce\",\"cf\"] == "+result);

        // Example 2
        inputDigits = "";
        result = solution.letterCombinations(inputDigits);
        System.out.println("[] == "+result);

        // Example 3
        inputDigits = "2";
        result = solution.letterCombinations(inputDigits);
        System.out.println("[\"a\",\"b\",\"c\"] == "+result);
    }
}
