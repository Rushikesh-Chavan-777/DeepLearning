import java.util.*;

public class ValidAnagram {

    /*public static boolean isAnagram(String s, String t) {
        //check for if the characters are not equal in length
        if (s.length() != t.length()) {
            return false;
        }
        //creating the character array
        Character arr[] = new Character[26];
        //iterating through s and adding the characters to their indices
        for(Character c : s.toCharArray()) {
            arr[c - 'a'] = c;
        }
        //iterating through t to see
        for (Character c: t.toCharArray()) {
            if(arr[c-'a'] != c) {
                return false;
            }
        }
        return true;
    }*/

    public static boolean isAnagram(String s, String t) {
        //check for if the characters are not equal in length
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        //iterating through string s
        for(Character c : s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
        }
        for(Character t_c : t.toCharArray()) {
            if(map.containsKey(t_c)) {
                if(map.get(t_c) > 0) {
                    map.put(t_c, map.get(t_c)-1);
                }else{
                    return false;
                }
            }else {
                return false;
            }

        }

        return true;
    }
    public static void main(String[] args) {

        System.out.println(isAnagram("aacc","cacc"));
    }
}
