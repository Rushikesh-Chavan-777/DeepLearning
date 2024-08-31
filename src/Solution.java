import java.util.HashMap;

public class Solution {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<String, Integer> mag_map = new HashMap<>();
        for(int i = 0; i+1 <= magazine.length(); i++) {
            if(!mag_map.containsKey(magazine.substring(i,i+1))) {
                mag_map.put(magazine.substring(i,i + 1), 1);
            }
            else if(mag_map.containsKey(magazine.substring(i,i+1))) {
                int value = mag_map.get(magazine.substring(i, i+1));
                mag_map.put(magazine.substring(i,i+1), value + 1);
            }
        }
        /*for(String key : mag_map.keySet()) {
            System.out.println(key+ " " +  mag_map.get(key));
        }*/
        for(int i = 0; i+1 <= ransomNote.length(); i++) {
            if(mag_map.containsKey(ransomNote.substring(i,i+1))) {
                int value = mag_map.get(ransomNote.substring(i, i+1));
                if (value > 0) {
                mag_map.put(ransomNote.substring(i,i + 1), value - 1);
                }else{
                    return false;
                }
            }
            else if(!mag_map.containsKey(ransomNote.substring(i,i+1))) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        System.out.println(canConstruct("a", "b"));
    }
}
