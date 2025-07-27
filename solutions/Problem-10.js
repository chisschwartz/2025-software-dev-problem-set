// Two Sum || Input Array Is Sorted Two Pointers //

// Brute Force //

/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    for (let i = 0; i < numbers.length; i++) {
        for (let j = i + 1; j < numbers.length; j++) {
            
            if (numbers[i] + numbers[j] === target) {
             return [i + 1, j + 1];
                }
            }
        }

        return [];
};

// Binary Search //

/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    for (let i = 0; i < numbers.length; i++) {

        let l = i + 1, r = numbers.length - 1;
        let tmp = target - numbers[i];

        while (l <= r) {
            let mid = l + Math.floor((r - 1) / 2);
            if (numbers[mid] === tmp) {
                return [i + 1, mid + 1];
            } else if (numbers[mid] < tmp) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
    }

    return [];
};

// Hash Map //

/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {

    const mp = new Map();

    for (let i = 0; i < numbers.length; i++) {
        
        const tmp = target - numbers[i];
        if (mp.has(tmp)) {
            return [mp.get(tmp), i + 1];
        }

        mp.set(numbers[i], i + 1);
    }

    return [];
};

// Two Pointers //

/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {

    let l = 0, r = numbers.length - 1;

    //set l to 0 because that is index 1 and has to be less than index 2
    //setting it to 0 and setting r to greater than 0 sets that rule
    //we subtract one from r so that when evaluating the array it does not
    //exit constraints

    while (l < r) {
        const curSum = numbers[l] + numbers[r];
        //^^adds two numbers from the array at the given points to provide a sum

        if (curSum > target) {
            r--;
        } else if (curSum < target) {
            l++

            //we use ++ and -- to navigate the array and slowly inch our ways to the 
            //solution. using greater than and less than to slowly pinch the target
        } else {
            return [l + 1, r + 1]
            //add one onto the end of the variables because otherwise the solution will be 1 off
            //due to the way we are navigating and manipulating the array.
        }
    }

    return [];
};