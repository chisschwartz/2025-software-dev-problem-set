// Sorting //

/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const res = {};
    for (let s of strs) {
        const sortedS = s.split("").sort().join("");
        if (!res[sortedS]) {
            res[sortedS] = []
        }

        res[sortedS].push(s);
    }
    
    return Object.values(res);
};

// Hash Table //

/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const res = {};
    for (let s of strs) {
        const count = new Array(26).fill(0);
        //fills array with zeros equal to the amount of the alphabet
        for (let c of s) {
            //for every character in each string
            count[c.charCodeAt(0) - "a".charCodeAt(0)] += 1;
            //subtract teh ascii value of a from the char at 0, then increment
            //to go up the alphabet to count each character
        } 

        const key = count.join(",");
        //joins our anagrams together
        if(!res[key]) {
            res[key] = [];
            //initates an empty array when a res does not exist
        }

        res[key].push(s);
        //pushes our result into the res
    }
    
    return Object.values(res);
};