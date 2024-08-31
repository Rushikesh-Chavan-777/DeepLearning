import java.util.*;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //iterating through the nums array
        for (int j = 0; j < nums.length; j++) {
            if(!map.containsKey(nums[j])){
                map.put(nums[j], j);
            }else if (j <= k + map.put(nums[j], j)){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,1};
        System.out.println(containsNearbyDuplicate(arr,  1));
    }
}
