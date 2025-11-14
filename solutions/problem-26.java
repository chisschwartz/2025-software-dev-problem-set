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
        //creates a set to store all characters in our window
        int l = 0;
        //intializes our left pointer
        int res = 0;
        //intializes our results

        for (int r = 0; r < s.length(); r++) {
            //increases right pointer continuously
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                //while a character is already contained within the set, removes the left most character
                l++;
            }

            charSet.add(s.charAt(r));
            //add right most character to our set
            res = Math.max(res, r - l + 1);
            //stores our final result with the largest substring possible
        }
        
        return res;
    }
}