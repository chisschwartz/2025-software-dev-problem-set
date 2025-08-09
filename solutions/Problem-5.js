// Sorting //

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {

    const count = {};
    
    for(const num of nums) {
        count[num] = (count[num] || 0) + 1;
    }

    const arr = Object.entries(count).map(([num, freq]) => [freq, parseInt(num)]);
    arr.sort((a, b) => b[0] - a[0]);

    return arr.slice(0, k).map(pair => pair[1]);
    
};

// Min-Heap //

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {

    const count = {};
    
    for(const num of nums) {
        count[num] = (count[num] || 0) + 1;
    }

    const heap = new MinPriorityQueue(x => x[1]);
    for (const [num, cnt] of Object.entries(count)) {
        heap.enqueue([num, cnt]);
        if (heap.size() > k) heap.dequeue();
    }

    const res = [];
    for (let i = 0; i < k; i++) {
        const [num, cnt] = heap.dequeue();
        res.push(num);
    }

    return res;
};

// Bucket Sort //

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
        
    const count = {};
    //creates a constant to pull from
    const freq = Array.from({ length: nums.length + 1 }, () => []);
    //creates am array from nums

    for (const n of nums) {
        count[n] = (count[n] || 0) + 1;
    }
    for (const n in count) {
        freq[count[n]].push(parseInt(n));
    }

    const res = [];
    
    for (let i = freq.length - 1; i > 0; i--) {
        for (const n of freq[i]) {
            res.push(n);
            if (res.length === k) {
                return res;
       }
    }
}
};