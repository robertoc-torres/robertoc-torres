package amazon.assestment;

public class FindWordsThatCanBeFormedByCharacters {

    /*

    src:https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

    Find Words That Can Be Formed by Characters

    You are given an array of strings words and a string chars.

    A string is good if it can be formed by characters from chars (each character can only be used once).

    Return the sum of lengths of all good strings in words.

     */

    public static void main(String[] args) {
        FindWordsThatCanBeFormedByCharacters findWordsThatCanBeFormedByCharacters = new FindWordsThatCanBeFormedByCharacters();
        FindWordsThatCanBeFormedByCharacters.Solution solution = findWordsThatCanBeFormedByCharacters.new Solution();
        int result = solution.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach");
        System.out.println("Expected 6, Result:" + result);


    }

    class Solution {
        public int countCharacters(String[] words, String chars) {
            int[] charsInt = new int[chars.length()];
            int len = 0;
            boolean f = false;

            for (String s : words) {

                for (int i = 0; i < chars.length(); i++) {
                    charsInt[i] = chars.charAt(i);
                }

                for (int i = 0; i < s.length(); i++) {

                    f = false;
                    char c = s.charAt(i);

                    for (int j = 0; j < charsInt.length; j++) {
                        if (c == charsInt[j]) {
                            charsInt[j] = 0;
                            f = true;
                            break;
                        }
                    }

                    if (!f)
                        break;

                }
                if (f)
                    len += s.length();

            }

            return len;

        }
    }

}
