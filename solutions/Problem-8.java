// Brute Force //

public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;

        Set<Integer> store = new HashSet<>();
        for (int num : nums) {
            store.add(num);
        }

        for (int num : nums) {
            int streak = 0, curr = num;

            while (store.contains(curr)) {
                streak++;
                curr++;
            }
            
            res = Math.max(res, streak);
        }
        
        return res;
    }
}

// Sorting //

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 0, curr = nums[0], streak = 0, i = 0;

        while (i < nums.length) {
            if (curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }

            while ( i < nums.length && nums[i] == curr) {
                i++;
            }

            streak++;
            curr++;
            res = Math.max(res, streak);
        }

        return res;
    }
}

// Hash Set //

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        //Creates HashSet to work through

        for (int num : nums) {
            numSet.add(num);
            //add every num from nums into num set
        }

        int longest = 0;
        //set default

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                //evaluates only num that can be subtracted to be in set
                int length = 1;
                //length will always equal to 1 at minimum
                while (numSet.contains(num + length)) {
                    //constantly adds one to num in set to find the maximum possible length
                    length++;
                }

                longest = Math.max(longest, length);
                //finds the max between 0, and length
            }
        }

        return longest;
    }
}

// Hash Map //

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        //create new hashmap to work through
        int res = 0;

        for (int num : nums) {
            //working through every number in nums
            if (!mp.containsKey(num)) {
                mp.put(num, mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1);
                mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));
                mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));
                res = Math.max(res, mp.get(num));
            }
        }

        return res;
    }
}
