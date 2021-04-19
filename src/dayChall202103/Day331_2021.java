package dayChall202103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class SolutionDay331 {
    private final Exception CantStamp = new Exception();

    char[] newWorkingArray(String str) {
        return str.toCharArray();
    }

    void unstamp(char[] work, int position, int stampLen) {
        if (work.length < position + stampLen ||
                position < 0 || stampLen < 0)
            try {
                throw CantStamp;
            } catch (Exception e) {
                e.printStackTrace();
            }
        for (int i = position; i < position + stampLen; i++)
            work[i] = '?';
    }

    boolean isStampedAt(char[] work, char[] stamp, int position) {
        if (position < 0 || position >= work.length) return false;
        for (int i = 0; i < stamp.length; i++) {
            if (stamp[i] != work[position + i])
                return false;
        }
        return true;
    }

    List<Integer> lastStampings(char[] stamp, char[] work) {
        List<Integer> stampings = new ArrayList<>();
        for (int i = 0; i <= work.length - stamp.length; i++) {
            if (!isStampedAt(work, stamp, i)) continue;
            unstamp(work, i, stamp.length);
            stampings.add(i);
        }
        return stampings;
    }

    private void pushListToStack(List<Integer> list, Stack<Integer> stampingStk) {
        for (int i = 0; i < stampingStk.size(); i++)
            stampingStk.push(list.get(i));
    }

    private List<Integer> moreStampings(List<Integer> list, char[] stampCh, char[] workCh) {
        List<Integer> stampList = new ArrayList<>();
        int stampLen = stampCh.length;
        // Left side of stamp
        for (int position : list) {
            int offsetStart = -Math.min(stampLen - 1, position);
            boolean isMatch = true, isWildCards = true;
            for (int offset = offsetStart, i = 0; offset < 0; offset++, i++) {
                if (workCh[position + offset] == '?')
                    continue;
                isWildCards = false;
                if (workCh[position + offset] != stampCh[i]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch && !isWildCards) {
                stampList.add(position + offsetStart);
                unstamp(workCh, position + offsetStart, stampLen);
            }
        }
        // Right side of stamp
        for (int position : list) {
            int offsetStart = Math.min(2 * stampLen - 1, workCh.length - 1 - position);
            boolean isMatch = true, isWildCards = true;
            for (int offset = offsetStart, i = stampLen - 1; offset >= 0; offset--, i--) {
                if (workCh[position + offset] == '?')
                    continue;
                isWildCards = false;
                if (workCh[position + offset] != stampCh[i]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch && !isWildCards) {
                stampList.add(position + offsetStart);
                unstamp(workCh, position + offsetStart, stampLen);
            }
        }
        return stampList;
    }

    public int[] movesToStamp(String stamp, String target) {
        if (stamp == null || target == null) return null;
        int tarLen = target.length();
        char[] stampCh = newWorkingArray(stamp);
        char[] workCh = newWorkingArray(target);
        List<Integer> list = lastStampings(stampCh, workCh);
        Stack<Integer> stampingStk = new Stack<>();

        while (list.size() > 0) {
            System.out.println("listsize " + list.size());
            pushListToStack(list, stampingStk);
            list = moreStampings(list, stampCh, workCh);
        }

        int[] moves = new int[stampingStk.size()];
        for (int i = 0; i < stampingStk.size(); i++)
            moves[i] = stampingStk.pop();
        return moves;
    }
}

public class Day331_2021 {
    public static void main(String[] args) {
        SolutionDay331 solution = new SolutionDay331();
        String paramStamp, paramTarget;
        int[] result;

        // Trivial 1
        paramStamp = "a";
        paramTarget = "a";
        result = solution.movesToStamp(paramStamp, paramTarget);
        System.out.println("[0] == " + Arrays.toString(result));

        // Example 1
        paramStamp = "abc";
        paramTarget = "ababc";
        result = solution.movesToStamp(paramStamp, paramTarget);
        System.out.println("[0,2] == " + Arrays.toString(result));

        // Example 2
        paramStamp = "abca";
        paramTarget = "aabcaca";
        result = solution.movesToStamp(paramStamp, paramTarget);
        System.out.println("[3,0,1] == " + Arrays.toString(result));
    }
}
