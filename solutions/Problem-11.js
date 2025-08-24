// 3 Sum - Medium Two Pointers //

// Brute Force //

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {

    const res = new Set();
    nums.sort((a, b) => a - b);

    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            for (let k = j + 1; k < nums.length; j++) {
                if (nums[i] + nums[j] + nums[k] === 0) {
                    res.add(JSON.stringify([nums[i], nums[j], nums[k]]));
                }
            }
        }
    }
    
    return Array.from(res).map(item => JSON.parse(item));
};

// Hash Map //

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    
    nums.sort((a, b) => a - b);
    const count = new Map();
        
        for (let num of nums) {
            count.set(num, (count.get(num) || 0) + 1);
        }

        const res = [];
        
        for (let i = 0; i < nums.length; i++) {
            count.set(nums[i], count.get(nums[i]) - 1);
            if (i > 0 && nums[i] === nums[i - 1]) continue;

            for (let j = i + 1; j < nums.length; j++) {
                count.set(nums[j], count.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] === nums[j - 1]) continue;

                const target = -(nums[i] + nums[j]);
                
                if (count.get(target) > 0) {
                    res.push([nums[i], nums[j], target]);
                }
            }

            for (let j = i + 1; j < nums.length; j++) {
                count.set(nums[j], count.get(nums[j]) + 1);
            }
        }
        
        return res;
};

// Two Pointers //

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    
    nums.sort((a, b) => a - b);
    //sort in an ascending order
    const res = [];
    //empty array to plug results into

    //-4, -1, -1, 0, 1, 2

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > 0) break;
        if (i > 0 && nums[i] === nums[i - 1]) continue;
        //passes over previous identical values

        let l = i + 1;
        //always sets l higher than i
        let r = nums.length - 1;
        //always sets r higher than l
        //two pointer section of logic

        while (l < r) {
            const sum = nums[i] + nums[l] + nums[r];
            //sum we are looking for

            if (sum > 0) {
                r--;
                //goes down the list of nums
            } else if (sum < 0) {
                l++;
                //goes up list of nums

            } else { 
                res.push([nums[i], nums[l], nums[r]]);
                //when equal to 0, push into res
                l++;
                r--;
                //updates our pointers

                while (l < r && nums[l] === nums[l - 1]) {
                    l++;
                    //speeds up the function by bypassing evaluation of l when number exists further in the array
                }
            }
        }
    }

    return res;
};