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
    }

    /**
     * @param {string} s
     * @return {boolean}
     */
    isPalindrome(s) {
        let newStr = '';
        for (let c of s) {
            if (this.isAlphanumeric(c)) { 
                newStr += c.toLowerCase();
            }
        }
        return newStr === newStr.split('').reverse().join('');
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

        while (l < r) {
            while (l < r && !this.alphaNum(s[l])) {
                l++;
            }
            while (r > l && !this.alphaNum(s[r])) {
                r--;
            }
            if (s[l].toLowerCase() !== s[r].toLowerCase()) {
                return false;
            }
            l++; r--;
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
}