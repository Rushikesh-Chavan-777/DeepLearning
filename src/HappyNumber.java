import java.util.*;

public class HappyNumber {
    public static boolean isHappy(int n) {
        //String k = String.valueOf(n);
        String k = Integer.toString(n);
        int bol = 0;
        int bol_square = 0;
        for(Character t : k.toCharArray()) {
           bol += (int)t;
           bol_square = bol_square + ((int)t * (int)t);
        }
        if (bol != 1) {
            return isHappy(bol_square);
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
