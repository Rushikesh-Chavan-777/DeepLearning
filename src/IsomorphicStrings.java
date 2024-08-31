import java.util.*;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            Character k = s.charAt(i);
            Character j = t.charAt(i);
            if(!map.containsKey(k) && !map.containsValue(j)) {
                map.put(k, j);
            }else{
                if(map.containsValue(j) && map.get(k) != j) {
                    return false;
                }
                if(map.get(k) != j) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }
}



//runtime was found to be 37 ms.
