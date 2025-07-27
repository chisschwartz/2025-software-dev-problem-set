// Container With Most Water - Medium Two Pointers //

// Brute Force //

/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {

    let res = 0;

    for (let i = 0; i < height.length; i++) {
        for (let j = i + 1; j < height.length; j++) {
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
        }
    }
    
    return res;
};

// Two Pointers //

/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {

    let l = 0;
    let r = height.length - 1;
    //starts them evaluation at opposite sides of the array
    let res = 0;

    while (l < r) {
        //keep evaluation until l is > r as the break point
        const area = Math.min(height[l], height[r]) * (r - l);
        //picks the lowest of the two areas
        //picks the final area when l is greater than r
        res = Math.max(res, area);
        //picks the highest between area and res

        if (height[l] <= height[r]) {
            l++;
        } else {
            r--;
            //squeezes in on the correct area
            //using only one if statement simplifies the execution
        }
    }

    return res;
};