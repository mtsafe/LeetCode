package dayChall202103;

import java.util.ArrayList;
import java.util.List;

public class ASTUtils {
    private List<String> allCodes(int k) {
        List<String> list = new ArrayList<>();
        list.add("");
        for (int i = 0; i < k; i++) {
            List<String> newList = new ArrayList<>();
            for (String s : list) {
                newList.add(s + "0");
                newList.add(s + "1");
            }
            list = newList;
        }
        return list;
    }
}
