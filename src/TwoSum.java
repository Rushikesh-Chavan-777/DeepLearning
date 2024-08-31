import java.util.*;


public class TwoSum {
    /*  public static int[] twoSum(int[] nums, int target) {
        int q = 0;
        int[] ans = new int[2];
        while(q < nums.length) {
            for(int i = 0; i < nums.length; i++) {
                if(nums[q] + nums[i] == target && i != q) {
                    ans[0] = q;
                    ans[1] = i;
                    return ans;
                }
            }
            q++;
        }
        return ans;
    }
    public static int[] twoSum(int[] nums, int target) {

        HashMap<HashMap<Integer, Integer>, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]<= target) {
                map.put(new HashMap<>(nums[i], i), target-nums[i]);
            }
        }
        for(Map<Integer, Integer> map_keys : map.keySet()) {
            int difference = map.get(map_keys);
            HashMap<Integer, Integer> internal_map = new HashMap<>();
                map.containsKey((difference,  ));
        }

    }   */
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            int difference = target - nums[i];
            if(map.containsKey(difference)) {
                ans[0] = map.get(difference);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] ans = twoSum(nums, 9);
        for(int j = 0; j < ans.length; j++) {
            System.out.println(ans[j]);
        }

    }
}
