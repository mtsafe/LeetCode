package dailyChallenges;

class SolutionDay019 {
    public boolean isPalindrome(String s, int start, int stop) {
//        System.out.println("isPalindrome('"+s+"', "+start+", "+stop+")");
        String str = s.substring(start, stop + 1);
        boolean itIs = true;
        for (start = 0, stop = str.length() - 1; start <= stop; start++, stop--) {
//            System.out.println("start="+start+", stop="+stop);
//            System.out.println("startChar="+str.charAt(start));
//            System.out.println("stopChar="+str.charAt(stop));
            if (str.charAt(start) != str.charAt(stop))
                itIs = false;
        }
        if (itIs)
            System.out.println("'"+str+"' is a palindrome.");
        return itIs;
    }

    public String longestPalindrome(String s) {
        System.out.println("longestPalindrome('"+s+"')");
        int len = s.length();
        String result = "";
        int maxOffSet = 0;
        int offSet = maxOffSet;
        for (int i = offSet; i + offSet < len; i++) {
            if (isPalindrome(s, i - offSet, i + offSet)) {
                maxOffSet = offSet;
                result = s.substring(i - offSet, i + offSet + 1);
                while (i - (++offSet) >= 0 && i + offSet < len) {
                    if (s.charAt(i - offSet) != s.charAt(i + offSet))
                        break;
                    result = s.substring(i - offSet, i + offSet + 1);
                    maxOffSet = offSet;
                }
            }
            offSet = maxOffSet;
            if (i - offSet < 0 || i + offSet + 1 >= len)
                break;
            if (isPalindrome(s, i - offSet, i + offSet + 1)) {
                result = s.substring(i - offSet, i + offSet + 2);
                while (i - (++offSet) >= 0 && i + offSet + 1 < len) {
                    if (s.charAt(i - offSet) != s.charAt(i + offSet + 1))
                        break;
                    result = s.substring(i - offSet, i + offSet + 2);
                    maxOffSet = offSet;
                }
            }
            offSet = maxOffSet + 1;
        }
        return result;
    }

    public String longestPalindrome0(String s) {
        System.out.println("longestPalindrome('"+s+"')");
        int len = s.length();
        String result = "";
        int leftOffset = 0;
        int rightOffset = 0;
        for (int i = 0; i < len; i++) {
            for (int start = i - leftOffset; start >= 0; start--) {
                for (int stop = i + rightOffset; stop < len; stop++) {
                    if (isPalindrome(s, start, stop)) {
                        result = s.substring(start, stop + 1);
                        leftOffset = i - start;
                        rightOffset = stop - i;
                        if (leftOffset == rightOffset)
                            rightOffset++;
                        else
                            leftOffset++;
                    }
                }
            }
        }
        return result;
    }
}

public class Day019_2021 {
    public static void main(String[] args) {
        SolutionDay019 solution = new SolutionDay019();
        String result;
        result = solution.longestPalindrome("babad");
        System.out.println("bab = " + result+"\n");
        result = solution.longestPalindrome("cbbd");
        System.out.println("bb = " + result+"\n");
        result = solution.longestPalindrome("a");
        System.out.println("a = " + result+"\n");
        result = solution.longestPalindrome("ac");
        System.out.println("a = " + result+"\n");
        result = solution.longestPalindrome("abc");
        System.out.println("a = " + result+"\n");
        result = solution.longestPalindrome("acc");
        System.out.println("cc = " + result+"\n");
        result = solution.longestPalindrome("abcc");
        System.out.println("cc = " + result+"\n");
        result = solution.longestPalindrome("abcba");
        System.out.println("abcba = " + result+"\n");
        result = solution.longestPalindrome("abccba");
        System.out.println("abccba = " + result+"\n");
        result = solution.longestPalindrome(
                "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
        System.out.println("ranynar = " + result+"\n");
        result = solution.longestPalindrome("bananas");
        System.out.println("anana = " + result+"\n");
    }
}
