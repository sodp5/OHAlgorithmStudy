package week_15;

import java.util.Stack;

public class Programmers_CorrectlyParenthesis {
    public static void main(String[] args) {
        String pa = "()))((()";
        String result = new Programmers_CorrectlyParenthesis().solution(pa);

        System.out.println(result);
    }

    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }

        int open = 0;
        int close = 0;

        String u;
        String v;

        int splitIdx = -1;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                splitIdx = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < splitIdx + 1; i++) {
            sb.append(p.charAt(i));
        }
        u = sb.toString();

        sb = new StringBuilder();

        for (int i = splitIdx + 1; i < p.length(); i++) {
            sb.append(p.charAt(i));
        }
        v = sb.toString();

        if (isCorrectParenthesis(u)) {
            u += solution(v);
        } else {
            StringBuilder s = new StringBuilder("(");
            s.append(solution(v));
            s.append(")");

            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    s.append(')');
                } else {
                    s.append('(');
                }
            }

            return s.toString();
        }

        return u;
    }

    private boolean isCorrectParenthesis(String p) {
        Stack<Character> stack = new Stack<>();

        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return true;
    }
}
