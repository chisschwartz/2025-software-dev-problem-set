// Sorting //

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }

    let sSort = s.split("").sort().join();
    let tSort = t.split("").sort().join();
    return sSort == tSort
};

// Hash Map //

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }

    const countS = {};
    const countT = {};
    for (let i = 0; i < s.length; i++) {
        countS[s[i]] = (countS[s[i]] || 0) + 1;
        countT[t[i]] = (countT[t[i]] || 0) + 1;
    }

    for (const key in countS) {
        if (countS[key] !== countT[key]) {
            return false;
        }
    }

    return true;
};

// Hash Table Array //

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
        //saves time by evaluating lengths to determine if anagram is possible
    }

    const count = new Array(26).fill(0);
    //fills an array of 26
    for (let i = 0; i < s.length; i++) {
        count[s.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        count[t.charCodeAt(i) - 'a'.charCodeAt(0)]--;
        //slowly qorks through and eliminates characters
    }
    return count.every(val => val === 0);
    //returns true if evaluation equals zero
};