// Sorting //

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }
}

// Hash Table //

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        //creates a new HashMap to evaluate through
        for (String s : strs) {
            int[] count = new int[26];
            //creates alphabet
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
                //subtracts each ascii letter in the alphabet to count amount of letters
            }
            String key = Arrays.toString(count);
            //creates an easy way to grab our solutions
            res.putIfAbsent(key, new ArrayList<>());
            //inserts key into our map
            res.get(key).add(s);
            //inserts solutions into res
        }
        return new ArrayList<>(res.values());
        //returns our anagram solutions
    }
}

