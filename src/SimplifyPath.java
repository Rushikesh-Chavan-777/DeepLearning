import java.util.*;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] dir = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dirs : dir) {
            if(dirs.isEmpty() || dirs.equals(".")) {
                continue;
            }
            if (dirs.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else {
                stack.push(dirs);
            }
        }
        return "/" + String.join("/", stack);
    }


    public static void main(String[] args) {
        simplifyPath("/home/user/Documents/../Pictures");
    }


}




