package leetcode;

import java.util.Arrays;

/**
 * Created by adamzfc on 5/6/17.
 */
public class ArrayPartitionI {

    public static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i ++) {
                if (i % 2 == 0) {
                    sum += nums[i];
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}
