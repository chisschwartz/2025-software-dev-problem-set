 //Brute Force//

 class Solution {
     public int[] twoSum(int[] nums, int target) {
         for (int i = 0; i < nums.length; i ++) {
             for (int j = i + 1; j < nums.length; j++) {
                 if (nums[i] + nums[j] == target) {
                     return new int[]{i, j};
                 }
             }
         }
         return new int[0];
     }
 }

 //Sorting//

 class Solution {
     public int[] twoSum(int[] nums, int target) {
         int[][] A = new int [nums.length][2];
         for (int i = 0; i < nums.length; i++) {
             A[i][0] = nums[i];
             A[i][1] = i;
         }

         Arrays.sort(A, Comparator.comparingInt(a -> a[0]));

         int i = 0, j = nums.length - 1;
         while (i<j) {
             int cur = A[i][0] + A[j][0];
             if(cur == target) {
                 return new int[]{Math.min(A[i][1], A[j][1]),
                         Math.max(A[i][1], A[j][1])};
             } else if (cur < target) {
                 i++;
             } else {
                 j--;
             }
         }
         return new int[0];
     }
 }

 //Two Pass Hash Map//

 class Solution {
     public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> indices = new HashMap<>();

         for (int i = 0; i < nums.length; i++) {
             indices.put(nums[i], i);
         }

         for (int i = 0; i < nums.length; i++) {
             int diff = target - nums[i];
             if (indices.containsKey(diff) && indices.get(diff) != i) {
                 return new int[]{i, indices.get(diff)};
             }
         }

         return new int[0];
     }
 }

 //One Pass Hash Map//

 class Solution {
     public int[] twoSum(int[] nums, int target) {
         HashMap<Integer, Integer> prevMap = new HashMap<>();
         //create a new hasmap to run trhough for our target

         for (int i = 0; i < nums.length; i++) {
             int num = nums[i];
             int diff = target - num;
             //creates a way to pass through our array effectively

             if (prevMap.containsKey(diff)) {
                 //searching through our map for the difference between the target and num[i]
                 return new int[] { prevMap.get(diff), i };
             }

             prevMap.put(num, i);
             //inserts variables into the hashmap
         }

         return new int[0];
     }
 }