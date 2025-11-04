// Brute Force //

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;

        for(int i = 0; i < s.length(); i++) {
            Set<Character> charSet = new HashSet<>();

            for(int j = i; j < s.length(); j++) {
                if(charSet.contains(s.charAt(j))) {
                    break;
                }

                charSet.add(s.charAt(j));
            }

            res = Math.max(res, charSet.size());
        }

        return res;
    }
}

// Sliding Window //

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }

            charSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        
        return res;
    }
}