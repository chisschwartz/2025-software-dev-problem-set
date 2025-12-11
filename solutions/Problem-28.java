// Brute Force //

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);

        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {
                char[] subStrArr = s2.substring(i, j + 1).toCharArray();
                Arrays.sort(subStrArr);
                String sortedSubStr = new String (subStrArr);

                if (sortedSubStr.equals(sortedS1)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

// Sliding Window //

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }
        //returns false if the first string is larger than the second

        int[] s1Count = new int [26];
        int[] s2Count = new int [26];
        //intilizes both counts to the size of the alphabet

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        //goes through the alphabet for both strings

        int matches = 0;
        //stores our matches

        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
                //if each letter matches, increase matches count
            }
        }

        int l = 0;
        //left pointer

        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            //creates an index that goes through s2
            s2Count[index]++;
            //increases the index for s2

            if (s1Count[index] == s2Count[index]) {
                matches++;
                //if s1Count and s2Count at index equal, increase count
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
                //if s1Count  + 1 and s2Count at index do not equal, decrease count
            }

            index = s2.charAt(l) - 'a';
            //override the def of index to the left pointer
            s2Count[index]--;
            //decrease the index

            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }
            l++;
        }

        return matches == 26;
        //exit code when matches = 26
    }
}