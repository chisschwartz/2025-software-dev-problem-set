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
    //starts evaluation at opposite sides of the array
    let res = 0;

    while (l < r) {
        const area = Math.min(height[l], height[r]) * (r - l);
        //picks the lowest of the two heights
        res = Math.max(res, area);
        //stores the results as we iterate through the array
        //picks the highest between area and res

        if (height[l] <= height[r]) {
            l++;
            //increases l when r is greater or equal
        } else {
            r--;
            //when l is greater r is reduced
        }
    }

    return res;
};