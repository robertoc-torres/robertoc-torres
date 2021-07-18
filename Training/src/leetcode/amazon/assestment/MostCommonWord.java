package leetcode.amazon.assestment;

import java.util.HashMap;

public class MostCommonWord {

    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        MostCommonWord.Solution solution = mostCommonWord.new Solution();
        String result = solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        System.out.println("Expected ball, Result:" + result);
        result = solution.mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"});
        System.out.println("Expected ball, Result:" + result);
        result = solution.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"});
        System.out.println("Expected b, Result:" + result);
        result = solution.mostCommonWord("abc abc? abcd the jeff!", new String[]{"abc","abcd","jeff"});
        System.out.println("Expected the, Result:" + result);
    }

    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {

            int max = 0;
            String r = "";
            HashMap<String, Integer> wordsCount = new HashMap<>();

            paragraph = paragraph.replaceAll("!", " ");
            paragraph = paragraph.replaceAll("\\?", " ");
            paragraph = paragraph.replaceAll("'", " ");
            paragraph = paragraph.replaceAll(",", " ");
            paragraph = paragraph.replaceAll(";", " ");
            paragraph = paragraph.replaceAll("\\.", " ");


            paragraph = paragraph.toLowerCase();

            String[] words = paragraph.split(" ");

            for(String b : banned) {
                for(int i = 0; i < words.length; i++) {
                    if(words[i].equals(b)) {
                        words[i] = "";
                    }
                }
            }

            for(String w : words) {
                int c = 1;
                if(w.length() == 0)
                    continue;

                if(wordsCount.containsKey(w)) {
                    c = wordsCount.get(w) + 1;
                }
                wordsCount.put(w, c);

                if(c > max) {
                    max = c;
                    r = w;
                }

            }

            return r;

        }
    }

}
