// Brute Force //

/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function(nums) {

    let res = 0;
    const store = new Set(nums);

    for (let num of nums) {
        let streak = 0, curr = num;

        while (store.has(curr)) {
            streak++;
            curr++
        }

        res = Math.max(res, streak);
    }

    return res;
};

// Sorting //

/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function(nums) {

    if (nums.length === 0) {
        return 0;
    }

    nums.sort((a, b) => a - b) ;

    let res = 0, curr = nums[0], streak = 0, i = 0;

    while (i < nums.length) {
        if (curr != nums[i]) {
            curr = nums[i];
            streak = 0;
        }

        while (i < nums.length && nums[i] === curr) {
            i++;
        }

        streak++;
        curr++;
        res = Math.max(res, streak);
    }

    return res;
};

// Hash Set //

/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function(nums) {

    const numSet = new Set(nums);
    let longest = 0;

    for (let num of numSet) {
        if (!numSet.has(num - 1)) {
            let length = 1;

            while (numSet.has(num + length)) {
                length++;
            }

            longest = Math.max(longest, length);
        }
    }

    return longest;
};

// Hash Map //

/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function(nums) {

    const mp = new Map();
    let res = 0;

    for (let num of nums) {
        if (!mp.has(num)) {
            mp.set(num, (mp.get(num - 1) || 0) + (mp.get(num + 1) || 0) + 1);
            mp.set(num - (mp.get(num - 1) || 0), mp.get(num));
            mp.set(num + (mp.get(num + 1) || 0), mp.get(num));
            res = Math.max(res, mp.get(num));
        }
    }

    return res;
};