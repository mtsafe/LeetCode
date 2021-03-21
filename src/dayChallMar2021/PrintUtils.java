package dayChallMar2021;

import java.util.Arrays;
import java.util.List;

public class PrintUtils {
    public static void printListListInt(List<List<Integer>> list) {
        if (list == null) return;
        System.out.print("[");
        int len = list.size();
        for (int i = 0; i < len; i++) {
            if (i == len - 1)
                System.out.print(Arrays.toString(list.get(i).toArray()));
            else
                System.out.print(Arrays.toString(list.get(i).toArray())+",");
        }
        System.out.print("]");
    }
}
