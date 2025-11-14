import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        /**
         * Given an array of strings strs, group the anagrams together. You can return
         * the answer in any order.
         * 
         * Input: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
         * Output: [["bat"], ["nat","tan"], ["ate", "eat", "tea"]]
         */
        System.out.println("Hello, World!");
        Solution solution = new Solution();
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        // String[] strs = { "eat", "tea", "ate" };
        List<List<String>> groupAnagrams = solution.groupAnagrams(strs);
        System.out.println("the given input is:" + Arrays.toString(strs));
        System.out.println("The group anagrams for the given input are: ");
        // Print in human-readable format
        groupAnagrams.forEach(innerList -> System.out.println("[" + String.join(", ", innerList) + "]"));
    }
}
