package leetcode.amazon.arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*

    src:https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2970/

    Group Anagrams

    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        GroupAnagrams.Solution solution = groupAnagrams.new Solution();
        //List<List<String>> result = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        //List<List<String>> result = solution.groupAnagrams(new String[]{""});
        //List<List<String>> result = solution.groupAnagrams(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"});
        List<List<String>> result = solution.groupAnagrams(new String[]{"ant", "ant"});
        //List<List<String>> result = solution.groupAnagrams(new String[]{"a"});
        System.out.println("Result:" + result);
    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            HashMap<String, List<String>> map = new HashMap<>();

            for (String s : strs) {

                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String c = new String(chars);
                if (!map.containsKey(c)) {
                    map.put(c, new ArrayList<>());
                }
                map.get(c).add(s);
            }

            return new ArrayList<>(map.values());

        }
    }

}
