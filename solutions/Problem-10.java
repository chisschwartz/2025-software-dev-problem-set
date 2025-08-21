// Brute Force //

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i + 1, j + 1};
                }
            }
        }

        return new int[0]; 
    }
}

// Binary Search //

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int l = i + 1, r = numbers.length - 1;
            int tmp = target - numbers[i];

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (numbers[mid] == tmp) {
                    return new int [] {i + 1, mid + 1};
                } else if (numbers[mid] < tmp) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return new int[0];
    }
}

// Hash Map //

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int tmp = target - numbers[i];

            if (mp.containsKey(tmp)) {
                return new int[] {mp.get(tmp), i + 1};
            }

            mp.put(numbers[i], i + 1);
        }

        return new int[0];
    }
}

// Two Pointers //

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        //declares our left and rightmost values to iterate through

        while (l < r) {
            int curSum = numbers[l] + numbers[r];
            //totals our current sum

            if (curSum > target) {
                r--;
                //if sum is too great reduce the greatest number
            } else if (curSum < target) {
                l++;
                //if sum too low increase lowest number
            } else {
                return new int[] {l + 1, r +1};
                //when target is reached return the points in the array
                //adding one to stay within restraints of the question
            }
        }

        return new int[0];
    }
}