// Reverse String //

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder newStr = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newStr.append(Character.toLowerCase(c));
            }
        }

        return newStr.toString().equals(newStr.reverse().toString());
    }
}

// Two Pointers //

class Solution {
    public boolean isPalindrome(String s) {
        int l  = 0, r = s.length() - 1;
        //creates our two points in space

        while (l < r) {
            while (l < r && !alphaNum(s.charAt(l))) {
                l++;
                //l starts lower so we increase that way
                //while l < r and is not the same character as l increase l
                //accounts for spaces and other non alpha characters
            }

            while (r > l && !alphaNum(s.charAt(r))) {
                r--;
                //r starts higher so we subtract
                //while r is greater than l and l is not the same character as r decrease r
                //accounts for spaces and other non alpha characters
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
                //returns false if two characters do not equal
            }
            l++; r--;
            //moves through string
        }

            return true;
        }

        public boolean alphaNum(char c) {
            return (c >= 'A' && c <= 'Z' || 
                    c >= 'a' && c <= 'z' ||
                    c >= '0' && c <= '9');
                    //creates an alphanumeric database
        }
    }