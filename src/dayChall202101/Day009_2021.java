package dayChall202101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionDay009_1stTry {
    private boolean isOneAway(String a, String b) {
        if (a == null || b == null) {
            System.err.println("isOneAway() null argument");
            return false;
        }
        int numAway = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                if (++numAway > 1)
                    return false;
        }
        return numAway == 1;
    }

    public int ladderLengthRecurse(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            System.err.println("ladderLengthRecurse() null argument");
            return 0;
        }
        System.out.println("ladderLengthRecurse (" + beginWord + " " + endWord + " " +
                wordList.toString() + ")");

        // Three Trivial Cases
        if (beginWord.equals(endWord))
            return 1;
        if (isOneAway(beginWord, endWord)) {
            System.out.println("MATCHED: " + beginWord + " " + endWord);
            System.out.println("RETURN 2");
            return 2;
        }
        if (wordList.size() == 0)
            return 0;

        // Move words OneAway to the queue
        // If a word in the queue is OneAway from beginWord then it is solved
        ArrayList<String> mutableList = new ArrayList<>(wordList);
        ArrayList<String> mutableListQueue = new ArrayList<>();
        for (String word : wordList) {
            if (isOneAway(word, endWord)) {
                if (isOneAway(beginWord, word)) {
                    System.out.println("MATCHED: " + beginWord + " " + word);
                    System.out.println("RETURN 3");
                    return 3;
                }
                mutableListQueue.add(word);
                mutableList.remove(word);
            }
        }
        System.out.println("Q: " + mutableListQueue.toString());
//        System.out.println("L: " + mutableList.toString());

        //
        int result = 0;
        for (String word : mutableListQueue) {
            result += ladderLengthRecurse(beginWord, word, mutableList);
            if (result > 0) {
                result++;
                System.out.println("RETURN " + result);
                return result;
            }
        }
        System.out.println("RETURN " + result);
        return result;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ArrayList<String> mutableList = new ArrayList<>(wordList);
        if (mutableList.size() == 0 || !mutableList.remove(endWord))
            return 0;
        return ladderLengthRecurse(beginWord, endWord, mutableList);
    }
}

class SolutionDay009 {
    private boolean isOneAway(String a, String b) {
        if (a == null || b == null) {
            System.err.println("isOneAway() null argument");
            return false;
        }
        int numAway = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                if (++numAway > 1)
                    return false;
        }
        return numAway == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            System.err.println("ladderLength() null argument");
            return 0;
        }

        //  Trivial check
        if (wordList.size() == 0 || !wordList.contains(endWord))
            return 0;
        System.out.println("endWord: "+endWord);
        System.out.println("wordList: "+wordList);
        System.out.println("contains: "+wordList.contains(endWord));
        System.out.println("indexOf: "+wordList.indexOf(endWord));
        wordList.remove(0);

        // Trivial check
        if (beginWord.equals(endWord))
            return 1;

        int depth = 2;
        ArrayList<String> children = new ArrayList<>();
        ArrayList<String> matchList = new ArrayList<>();
        matchList.add(endWord);

        //  Move words oneAway to children
        for (String word: matchList) {
            if (isOneAway(beginWord, word))
                return depth;

        }

        return 0;
    }
}

public class Day009_2021 {
    public static void main(String[] args) {
        SolutionDay009 solution = new SolutionDay009();
        System.out.println("5 == " +
                solution.ladderLength("hit", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println("0 == " +
                solution.ladderLength("hit", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log")));
        System.out.println("2 == " +
                solution.ladderLength("jog", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println("3 == " +
                solution.ladderLength("lop", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println("4 == " +
                solution.ladderLength("det", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println("5 == " +
                solution.ladderLength("mit", "cog",
                        Arrays.asList("hit", "jit",
                                "hot", "jot", "mot",
                                "dot", "lot",
                                "dog", "log",
                                "cog")));

        // Testcase 1
        System.out.println("11 == " +
                solution.ladderLength("cet",
                        "ism",
                        Arrays.asList("kid", "tag", "pup", "ail", "tun", "woo",
                                "erg", "luz", "brr", "gay", "sip", "kay", "per",
                                "val", "mes", "ohs", "now", "boa", "cet", "pal",
                                "bar", "die", "war", "hay", "eco", "pub", "lob",
                                "rue", "fry", "lit", "rex", "jan", "cot", "bid",
                                "ali", "pay", "col", "gum", "ger", "row", "won",
                                "dan", "rum", "fad", "tut", "sag", "yip", "sui",
                                "ark", "has", "zip", "fez", "own", "ump", "dis",
                                "ads", "max", "jaw", "out", "btu", "ana", "gap",
                                "cry", "led", "abe", "box", "ore", "pig", "fie",
                                "toy", "fat", "cal", "lie", "noh", "sew", "ono",
                                "tam", "flu", "mgm", "ply", "awe", "pry", "tit",
                                "tie", "yet", "too", "tax", "jim", "san", "pan",
                                "map", "ski", "ova", "wed", "non", "wac", "nut",
                                "why", "bye", "lye", "oct", "old", "fin", "feb",
                                "chi", "sap", "owl", "log", "tod", "dot", "bow",
                                "fob", "for", "joe", "ivy", "fan", "age", "fax",
                                "hip", "jib", "mel", "hus", "sob", "ifs", "tab",
                                "ara", "dab", "jag", "jar", "arm", "lot", "tom",
                                "sax", "tex", "yum", "pei", "wen", "wry", "ire",
                                "irk", "far", "mew", "wit", "doe", "gas", "rte",
                                "ian", "pot", "ask", "wag", "hag", "amy", "nag",
                                "ron", "soy", "gin", "don", "tug", "fay", "vic",
                                "boo", "nam", "ave", "buy", "sop", "but", "orb",
                                "fen", "paw", "his", "sub", "bob", "yea", "oft",
                                "inn", "rod", "yam", "pew", "web", "hod", "hun",
                                "gyp", "wei", "wis", "rob", "gad", "pie", "mon",
                                "dog", "bib", "rub", "ere", "dig", "era", "cat",
                                "fox", "bee", "mod", "day", "apr", "vie", "nev",
                                "jam", "pam", "new", "aye", "ani", "and", "ibm",
                                "yap", "can", "pyx", "tar", "kin", "fog", "hum",
                                "pip", "cup", "dye", "lyx", "jog", "nun", "par",
                                "wan", "fey", "bus", "oak", "bad", "ats", "set",
                                "qom", "vat", "eat", "pus", "rev", "axe", "ion",
                                "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale",
                                "bud", "gee", "pin", "dun", "pat", "ten", "mob")));
    }
}
