package dayChallJan2021;

public class Day008_2021 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String eachS: word1)
            sb1.append(eachS);
        for (String eachS: word2)
            sb2.append(eachS);
        return sb1.toString().compareTo(sb2.toString()) == 0;
    }
}