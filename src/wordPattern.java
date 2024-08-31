import java.util.*;


public class wordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()){
            return false;
        }
        HashMap<Character, Integer> Pattern_map = new HashMap<>();
        HashMap<String, Integer> String_map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            if(Pattern_map.put(pattern.charAt(i), i) != String_map.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd", "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"));
    }
}
