// Brute Force //

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] === target) {
            return [i,j];
            }
        }
    }
    return [];
    
};

// Sorting //

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let A = [];
    for (let i = 0; i < nums.length; i++) {
        A.push([nums[i], i]);
    }

    A.sort((a, b) => a[0] - b[0])

    let i = 0, j = nums.length - 1;
    
    while(i < j) {
        let cur = A[i][0] + A[j][0];
        if (cur === target) {
            return [Math.min(A[i][1], A[j][1]),
                    Math.max(A[i][1], A[j][1])];
        } else if (cur < target) {
            i++;
        } else {
            j--;
        }
    }
    return [];
};

// Hash Map Two Pass //

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const indices = {};
 
    for (let i = 0; i < nums.length; i++) {
     indices[nums[i]] = i;
    }
 
    for (let i = 0; i < nums.length; i++) {
     let diff = target - nums[i];
     if (indices[diff] !== undefined && indices[diff] !== i) {
         return [i, indices[diff]];
     }
    }
     return [];
 };

 // Hash Map One Pass //

 /**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const prevMap = new Map();

    for (let i = 0; i < nums.length; i++) {
        const diff = target - nums[i];
        if (prevMap.has(diff)) {
            return [prevMap.get(diff), i];
        }

        prevMap.set(nums[i], i);
    }
    return [];
    
};