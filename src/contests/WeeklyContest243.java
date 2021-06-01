package contests;

import java.math.BigInteger;

class SolutionWC243 {
    int strToNum(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += ((int) (s.charAt(i) - 'a')) * Math.pow(10.0, s.length() - i);
        }
        return num;
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int sum;
        sum = strToNum(firstWord) + strToNum(secondWord);
        return sum == strToNum(targetWord);
    }

    // 1881. Maximum Value after Insertion
    public String addChar(String str, char ch, int position) {
        if (str == null) return "";
        return str.substring(0, position) + ch + str.substring(position);
    }

    public String maxValue(String n, int x) {
        if (n == null) return "";
        String s1, s2;
        int pos = n.charAt(0) == '-' ? 1 : 0;
//        int dir = n.charAt(0) == '-' ? 1 : 1;
        s1 = addChar(n, (char) (x + '0'), pos);
        for (int i = 1; i < n.length(); i++) {
            s2 = addChar(n, (char) (x + '0'), pos + i);
            if (new BigInteger(s1).compareTo(new BigInteger(s2)) > 0)
                return s1;
            s1 = s2;
        }
        return addChar(n, (char) (x + '0'), n.length());
    }
}

public class WeeklyContest243 {
    public static void main(String[] args) {
        SolutionWC243 solution = new SolutionWC243();
        String inputS1, inputS2, inputS3;
        boolean resultB;
        int inputI;
        String resultS;

        // Example 1
        inputS1 = "99";
        inputI = 9;
        resultS = solution.maxValue(inputS1, inputI);
        System.out.println("999 == " + resultS);

        // Example 2
        inputS1 = "-13";
        inputI = 2;
        resultS = solution.maxValue(inputS1, inputI);
        System.out.println("-123 == " + resultS);

        // Test Case 1
        inputS1 = "-132";
        inputI = 3;
        resultS = solution.maxValue(inputS1, inputI);
        System.out.println("-1323 == " + resultS);

        // Test Case 2
        inputS1 = "28824579515";
        inputI = 8;
        resultS = solution.maxValue(inputS1, inputI);
        System.out.println("828824579515 == " + resultS);

        // Test Case 3
        inputS1 = "-648468153646";
        inputI = 5;
        resultS = solution.maxValue(inputS1, inputI);
        System.out.println("-5648468153646 == " + resultS);

        // Test Case 4 [Time Limit Exceeded]
        inputS1 =
                "343367251721999681862993841747491817947752894218652923616114282942544295156185768467576619716274164557336353933267454398724612899586751721772191142656286733181951135381292118979689833277319376121521718717689589311638317862985192575588882589957375528968496499427948524734452186285286967362514471799786518155293822918761613326391894493319913186144348854189317661123758581931669752764195353657818786663361582425317522515217793756839339381532298733133316572994351385587213117597327618581396193541665636394589482892234776168565489153687347956755958585888274316649";
        inputI = 1;
        resultS = solution.maxValue(inputS1, inputI);
        System.out.println(
                "3433672517219996818629938417474918179477528942186529236161142829425442951561857684675766197162741645573363539332674543987246128995867517217721911426562867331819511353812921189796898332773193761215217187176895893116383178629851925755888825899573755289684964994279485247344521862852869673625144717997865181552938229187616133263918944933199131861443488541893176611237585819316697527641953536578187866633615824253175225152177937568393393815322987331333165729943513855872131175973276185813961935416656363945894828922347761685654891536873479567559585858882743166491 == \n" + resultS);

        //////////////////////////////////
        // Example 1
        inputS1 = "acb";
        inputS2 = "cba";
        inputS3 = "cdb";
        resultB = solution.isSumEqual(inputS1, inputS2, inputS3);
        System.out.println("true == " + resultB);

        // Example 2
        inputS1 = "aaa";
        inputS2 = "a";
        inputS3 = "aab";
        resultB = solution.isSumEqual(inputS1, inputS2, inputS3);
        System.out.println("false == " + resultB);

        // Example 3
        inputS1 = "aaa";
        inputS2 = "a";
        inputS3 = "aaaa";
        resultB = solution.isSumEqual(inputS1, inputS2, inputS3);
        System.out.println("true == " + resultB);
    }
}
