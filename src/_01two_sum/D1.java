package _01two_sum;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class D1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};

        int[] ints = Solution.twoSum3(nums, 6);

        System.out.println(Arrays.toString(ints));

    }


}

class Solution {
    // 暴力 时间：O(n^2) 空间：O(1) 
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 使用hashMap提高搜索速度 O(n) O(n)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numMaps = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numMaps.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            Integer index = numMaps.get(t);
            // 注意排除当前元素
            if (index != null && index != i) {
                return new int[]{i, index};
            }

        }

        return null;
    }

    // 插入元素的同时检索元素 O(n)  O(n)
    public static int[] twoSum3(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> numMaps = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int t = target - nums[i];

            Integer index = numMaps.get(t);

            if (index != null && index != i) {
                return new int[]{i, index};
            }
            numMaps.put(nums[i], i);
        }
        return null;
    }
}
