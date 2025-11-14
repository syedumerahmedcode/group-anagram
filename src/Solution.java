import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final int LOWER_CASE_ALPHABETS = 26;

    public List<List<String>> groupAnagrams(String[] strs) {
        /**
         * First check if there any strings in the array. If not, return an empty list
         */
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        /**
         * Create a hashmap of answers where:
         * key: The string representation of all alphabet bits turned on as '1' and the
         * rest as zero. For example:
         * bat-->11000000000000000001000000
         * rod-->00010000000000100100000000
         * 
         * value: A list of all string combinations that are anagrams of each other
         * represented by the 'bit hash' key
         * 11000000000000000001000000-->bat,tab
         */
        Map<String, List> ansMap = new HashMap<>();

        /**
         * Assuming that we only get lower case english alphabets as input.
         */
        int[] count = new int[LOWER_CASE_ALPHABETS];

        /**
         * Loop through the string in the string array.
         */
        for (String s : strs) {
            /**
             * Setting all bits in count to 0
             */
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                /**
                 * Turning on bits from '0' to '1' where we find the character in the string
                 */
                count[c - 'a']++;
            }
            /**
             * Using strikng builder to create the key for the hashmap
             */
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < LOWER_CASE_ALPHABETS; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            /**
             * Extract key
             */
            String key = sb.toString();
            if (!ansMap.containsKey(key)) {
                /**
                 * If the generated key does not exist in the hash map, add it in the map
                 */
                ansMap.put(key, new ArrayList<>());
            }
            /**
             * Append the string to the value part based on the key
             */
            ansMap.get(key).add(s);
        }
        /**
         * Finally, return all values.
         */
        return new ArrayList(ansMap.values());
    }
}
