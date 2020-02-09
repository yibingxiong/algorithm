package leetcode;

import java.util.LinkedList;

public class Code00071 {
    public String simplifyPath(String path) {
        LinkedList<String> linkedList = new LinkedList<String>();
        String[] strings = path.split("/");
        for (int i = 0; i < strings.length; i++) {
            String token = strings[i];
            if (token.equals("..")) {
                if (!linkedList.isEmpty()) {
                    linkedList.removeLast();
                }
            } else if (token.equals(".")) {

            } else if (token.equals("")) {

            } else {
                linkedList.addLast(token);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(linkedList.isEmpty()) {
            return "/";
        }
        while (!linkedList.isEmpty()) {
            stringBuilder.append("/" + linkedList.removeFirst());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Code00071 code00071 = new Code00071();
        System.out.println(code00071.simplifyPath("/home/"));
        System.out.println(code00071.simplifyPath("/../"));
        System.out.println(code00071.simplifyPath("/home//foo/"));
        System.out.println(code00071.simplifyPath("/a/./b/../../c/"));
        System.out.println(code00071.simplifyPath("/a//b////c/d//././/.."));
    }
}
