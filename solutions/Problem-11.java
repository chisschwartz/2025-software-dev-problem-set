// Brute Force //

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
                        res.add(tmp);
                    }
                }
            }
        }
        
        return new ArrayList<>(res);
    }
}

// Hash Map //

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.get(nums[i]) - 1);
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int target = -(nums[i] + nums[j]);
                if (count.getOrDefault(target, 0) > 0) {
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) + 1);
            }
        }

        return res;
    }
}

// Two Pointers //

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //sorts our list of nums
         List<List<Integer>> res = new ArrayList<>();
         //creates new list for our results

         for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //skips over repeating a values

            int l = i + 1, r = nums.length - 1;
            //establishes our two pointers

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                //creates our sum

                if (sum > 0) {
                    r--;
                    //r moves down the list when sum greater than 0
                } else if (sum < 0) {
                    l++;
                    //l moves up the list when sum less than o
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //pushes results into res
                    l++;
                    r--;
                    //resets our pointers

                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                        //skips over repeating numbers
                    }
                }
            }
         }

         return res;
    }
}
