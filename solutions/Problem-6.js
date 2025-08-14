// Brute Force //

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {

    const n = nums.length;
    const res = new Array(n);

    for (let i = 0; i < n; i++) {
        let prod = 1;
        for (let j = 0; j < n; j++) {
            if (i !== j) {
                prod *= nums[j];
            }
        }
        
        res[i] = prod;
    }

    return res;
};

// Division //

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
   
    let prod = 1;
    let zeroCount = 0;

    for (let num of nums) {
        if (num != 0) {
            prod *= num;
        } else {
            zeroCount++
        }
    }

    if (zeroCount > 1) {
        return Array(nums.length).fill(0);
    }

    const res = new Array(nums.lenght);

    for (let i = 0; i < nums.length; i++) {
        if (zeroCount > 0) {
            res[i] = (nums[i] === 0) ? prod : 0;
        } else {
            res[i] = prod / nums[i]
        }
    }

    return res;
};

// Prefix & Sufix //

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
        
    const n = nums.length;
    const res = new Array(n);
    const pref = new Array(n);
    const suff = new Array(n);

    pref[0] = 1;
    suff[n - 1] = 1;
    for (let i = 1; i < n; i++) {
        pref[i] = nums[i - 1] * pref[i - 1];
    }
    
    for (let i = n - 2; i >= 0; i--) {
        suff[i] = nums[i + 1] * suff[i + 1];
    }
    
    for (let i = 0; i < n; i++) {
        res[i] = pref[i] * suff[i];
    }
    
    return res;
};

// Prefix & Sufix (Optimal) //

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {

    const n = nums.length;
    const res = new Array(n).fill(1);
    //creates an array with the length of nums with a 1 in each position

    for (let i = 1; i < ns; i++) {
        res[i] = res[i - 1] * nums[i - 1];
        //acquires our prefix for later usse
    }

    let postfix = 1;
    //initializes postfix to 1
    
    for (let i = n - 1; i >= 0; i--) {
        res[i] *= postfix;
        //multiplies our prefix by postfix
        postfix *= nums[i];
        //updates our array of nums
    }

    return res;
};