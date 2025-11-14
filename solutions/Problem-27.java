// Brute Force //

class Solution {
    public int characterReplacement(String s, int k) {

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            int maxF = 0;

            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxF = Math.max(maxF, count.get(s.charAt(j)));

                if ((j - i + 1) - maxF <= k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        
        return res;
    }
}

// Sliding Window //

class Solution {
    public int characterReplacement(String s, int k) {

        int res = 0;
        //intializes our results array
        HashSet<Character> charSet = new HashSet<>();
        //intializes a new set to store our characters in

        for(char c : s.toCharArray()) {
            charSet.add(c);
            //adds each character to our array;
        }
        
        for (char c : charSet) {
            int count = 0, l = 0;
            //intializes count and left to their start

            for (int r = 0; r < s.length(); r++) {
                //right pointer increases with for loop
                if (s.charAt(r) == c) {
                    count++;
                    //if the character at r is equal to c then increase the count
                }

                while ((r - l + 1) - count > k) {
                    //while our algorithm is higher than the amount of replacements
                    if (s.charAt(l) == c) {
                        count--;
                        //if character at the leftmost is equal to c, then decrease the count
                    }

                    l++;
                }

                res = Math.max(res, r - l + 1);
                //stores the maximum substring length
            }
        }

        return res;
    }
}

// Siding Window (Optimal) //

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;
         int l = 0, maxf = 0;

        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, count.get(s.charAt(r)));

            while ((r - l + 1) - maxf > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}