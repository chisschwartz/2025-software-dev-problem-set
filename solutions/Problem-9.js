// Reverse String //

class Solution {
    /**
     * Check if a character is alphanumeric
     * @param {char} char
     * @return {boolean}
     */
    isAlphanumeric(char) {
        return (char >= 'a' && char <= 'z') || 
               (char >= 'A' && char <= 'Z') || 
               (char >= '0' && char <= '9');
               //creates an alphanumeric database
    }

    /**
     * @param {string} s
     * @return {boolean}
     */
    isPalindrome(s) {
        let newStr = '';
        //creates new string
        for (let c of s) {
            if (this.isAlphanumeric(c)) { 
                newStr += c.toLowerCase();
                //checks if legal and adds the character to the string
            }
        }
        return newStr === newStr.split('').reverse().join('');
        //if new str equals itself reversed then it is a palindrome
    }
}

// Two Pointers //

class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isPalindrome(s) {
        let l = 0, r = s.length - 1;
        //creates our two points in space

        while (l < r) {
            while (l < r && !this.alphaNum(s[l])) {
                l++;
                //l starts lower so we increase that way
                //while l < r and is not the same character as l increase l
                //accounts for spaces and other non alpha characters
            }
            while (r > l && !this.alphaNum(s[r])) {
                r--;
                //r starts higher so we subtract
                //while r is greater than l and l is not the same character as r decrease r
                //accounts for spaces and other non alpha characters
            }
            if (s[l].toLowerCase() !== s[r].toLowerCase()) {
                return false;
                // if l and r do not equal palindrome returns false
            }
            l++; r--;
            //iterates through string
            
        }
        return true;
    }

    /**
     * @param {char} c
     * @return {boolean}
     */
    alphaNum(c) {
        return (c >= 'A' && c <= 'Z' || 
                c >= 'a' && c <= 'z' || 
                c >= '0' && c <= '9');
    }
    //creates alphanumeric database
}