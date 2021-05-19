package dayChall202105;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SolutionDay519 {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            String file, content;
            String[] fcSplit;
            for (int i = 1; i < files.length; i++) {
                fcSplit = files[i].split("\\(");
                file = files[0] +'/'+ fcSplit[0];
                content = fcSplit[1].substring(0, fcSplit[1].length() - 1);
                if (!hash.containsKey(content))
                    hash.put(content, new ArrayList<>());
                hash.get(content).add(file);
            }
        }
        List<List<String>> result = new ArrayList<>();
        List<String> list;
        for (String key : hash.keySet()) {
            list = hash.get(key);
            if (list.size() > 1)
                result.add(list);
        }
        return result;
    }
}

public class Day519_2021 {
    public static void main(String[] args) {
        SolutionDay519 solution = new SolutionDay519();
        String[] inputP;
        List<List<String>> result;

        // Example 1
        inputP = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)"
        };
        result = solution.findDuplicate(inputP);
        System.out.println("[[\"root/a/2.txt\",\"root/c/d/4.txt\",\"root/4.txt\"],[\"root/a/1.txt\",\"root/c/3.txt\"]]");
        System.out.println("[");
        for (List<String> listS : result) {
            System.out.print("[");
            for (String s : listS) {
                System.out.print(s + ", ");
            }
            System.out.println("], ");
        }
        System.out.println("]");

        // Example 2
        inputP = new String[]{
                "root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)"
        };
        result = solution.findDuplicate(inputP);
        System.out.println("[[\"root/a/2.txt\",\"root/c/d/4.txt\"],[\"root/a/1.txt\",\"root/c/3.txt\"]]");
        System.out.println("[");
        for (List<String> listS : result) {
            System.out.print("[");
            for (String s : listS) {
                System.out.print(s + ", ");
            }
            System.out.println("], ");
        }
        System.out.println("]");
    }
}
