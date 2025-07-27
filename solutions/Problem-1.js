// Brute Force //

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    for (let i = 0; i < nums.length; i++) {
      for (let j = i + 1; j < nums.length; j++) {
          if (nums[i] === nums[j]) {
              return true;
          }
      }
  }
  return false;
};

// Sorting //

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    nums.sort((a, b) => a - b);
      for (let i = 0; i < nums.length; i++) {
        if (nums[i] === nums[i - 1]) {
            return true;
        }
      }
    return false;
};

// Hash Set //

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    const seen = new Set();
    for (const num of nums) {
        if (seen.has(num)) {
            return true;
        }
        seen.add(num)
      }
    return false;
};

// Hash Set Length //

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    return new Set(nums).size < nums.length;
};