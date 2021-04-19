package dayChall202103;

import java.util.HashMap;

class SolutionDay315 {
    public class Codec {
        HashMap<String, String> eHash;
        HashMap<String, String> dHash;
        char[] nextCodec;
        HashMap<Character, Integer> hashC2I = new HashMap<>();
        HashMap<Integer, Character> hashI2C = new HashMap<>();

        Codec() {
            eHash = new HashMap<>();
            dHash = new HashMap<>();
            nextCodec = new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a'};
            hashC2I = new HashMap<>();
            hashI2C = new HashMap<>();
            int cnt = 0;
            for (char C : new char[]{
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                    'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                    'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
                    'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                    'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                    'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
                    '8', '9'}) {
                hashC2I.put(C, cnt);
                hashI2C.put(cnt++, C);
            }
        }

        String newCodec() {
            for (int i = 0; i < 7; i++) {
                if (nextCodec[i] != '9') {
                    nextCodec[i] = hashI2C.get(1 + hashC2I.get(nextCodec[i]));
                    break;
                }
                nextCodec[i] = 'a';
            }
            return String.valueOf(nextCodec);
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (eHash.containsKey(longUrl))
                return eHash.get(longUrl);
            String result = "http://tinyurl.com/";
            result += newCodec();
            eHash.put(longUrl, result);
            dHash.put(result, longUrl);
            return result;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            if (dHash.containsKey(shortUrl))
                return dHash.get(shortUrl);
            return "";
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
public class Day315_2021 {
    private static void testCodec(SolutionDay315.Codec codec, String url) {
        String unencoded, encoded, result;
        unencoded = url;
        encoded = codec.encode(unencoded);
        result = codec.decode(encoded);
        System.out.println(unencoded);
        System.out.println("    => " + encoded);
        System.out.println("    => " + result);
    }

    public static void main(String[] args) {
        SolutionDay315 solution = new SolutionDay315();
        SolutionDay315.Codec codec;

        // Test 1
        codec = solution.new Codec();
        testCodec(codec,"https://leetcode.com/problems/design-tinyurl");
        testCodec(codec,"https://leetcode.com/problems/design-tinyurl");
        testCodec(codec,"https://leetcode.com/problems/design-tinyurl");

        // Test 2
        codec = solution.new Codec();
        testCodec(codec,"https://alpha.com");
        testCodec(codec,"https://beta.com");
        testCodec(codec,"https://gamma.com");
        testCodec(codec,"https://alpha.com");
        testCodec(codec,"https://beta.com");
        testCodec(codec,"https://gamma.com");

        // Test 3
        codec = solution.new Codec();
        testCodec(codec,"https://leetcode.com/1");
        testCodec(codec,"https://leetcode.com/2");
        testCodec(codec,"https://leetcode.com/3");
        testCodec(codec,"https://leetcode.com/4");
        testCodec(codec,"https://leetcode.com/5");
        testCodec(codec,"https://leetcode.com/6");
        testCodec(codec,"https://leetcode.com/7");
        testCodec(codec,"https://leetcode.com/8");
        testCodec(codec,"https://leetcode.com/9");
        testCodec(codec,"https://leetcode.com/10");

        testCodec(codec,"https://leetcode.com/11");
        testCodec(codec,"https://leetcode.com/12");
        testCodec(codec,"https://leetcode.com/13");
        testCodec(codec,"https://leetcode.com/14");
        testCodec(codec,"https://leetcode.com/15");
        testCodec(codec,"https://leetcode.com/16");
        testCodec(codec,"https://leetcode.com/17");
        testCodec(codec,"https://leetcode.com/18");
        testCodec(codec,"https://leetcode.com/19");
        testCodec(codec,"https://leetcode.com/20");

        testCodec(codec,"https://leetcode.com/21");
        testCodec(codec,"https://leetcode.com/22");
        testCodec(codec,"https://leetcode.com/23");
        testCodec(codec,"https://leetcode.com/24");
        testCodec(codec,"https://leetcode.com/25");
        testCodec(codec,"https://leetcode.com/26");
        testCodec(codec,"https://leetcode.com/27");
        testCodec(codec,"https://leetcode.com/28");
        testCodec(codec,"https://leetcode.com/29");
        testCodec(codec,"https://leetcode.com/30");

        testCodec(codec,"https://leetcode.com/31");
        testCodec(codec,"https://leetcode.com/32");
        testCodec(codec,"https://leetcode.com/33");
        testCodec(codec,"https://leetcode.com/34");
        testCodec(codec,"https://leetcode.com/35");
        testCodec(codec,"https://leetcode.com/36");
        testCodec(codec,"https://leetcode.com/37");
        testCodec(codec,"https://leetcode.com/38");
        testCodec(codec,"https://leetcode.com/39");
        testCodec(codec,"https://leetcode.com/40");

        testCodec(codec,"https://leetcode.com/41");
        testCodec(codec,"https://leetcode.com/42");
        testCodec(codec,"https://leetcode.com/43");
        testCodec(codec,"https://leetcode.com/44");
        testCodec(codec,"https://leetcode.com/45");
        testCodec(codec,"https://leetcode.com/46");
        testCodec(codec,"https://leetcode.com/47");
        testCodec(codec,"https://leetcode.com/48");
        testCodec(codec,"https://leetcode.com/49");
        testCodec(codec,"https://leetcode.com/50");

        testCodec(codec,"https://leetcode.com/51");
        testCodec(codec,"https://leetcode.com/52");
        testCodec(codec,"https://leetcode.com/53");
        testCodec(codec,"https://leetcode.com/54");
        testCodec(codec,"https://leetcode.com/55");
        testCodec(codec,"https://leetcode.com/56");
        testCodec(codec,"https://leetcode.com/57");
        testCodec(codec,"https://leetcode.com/58");
        testCodec(codec,"https://leetcode.com/59");
        testCodec(codec,"https://leetcode.com/60");

        testCodec(codec,"https://leetcode.com/61");
        testCodec(codec,"https://leetcode.com/62");
        testCodec(codec,"https://leetcode.com/63");
        testCodec(codec,"https://leetcode.com/64");
        testCodec(codec,"https://leetcode.com/65");
        testCodec(codec,"https://leetcode.com/66");
        testCodec(codec,"https://leetcode.com/67");
        testCodec(codec,"https://leetcode.com/68");
        testCodec(codec,"https://leetcode.com/69");
        testCodec(codec,"https://leetcode.com/70");
    }
}
