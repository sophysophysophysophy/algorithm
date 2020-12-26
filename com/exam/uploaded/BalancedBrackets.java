package exam.uploaded;
//https://www.hackerrank.com/challenges/balanced-brackets/problem


import java.util.Stack;

public class BalancedBrackets {
    static String isBalanced(String s) {
        String answer = "NO";
        Stack<Character> stack = new Stack<>();

        char[] array = s.toCharArray();
        for (char i : array) {
            if (i == '(' || i == '{' || i == '[') stack.push(i);
            else {
                if(stack.empty()) return answer;
                Character nowChar = stack.pop();
                if(!((i == '}' && nowChar == '{') || (i == ']' && nowChar == '[') || (i == ')' && nowChar == '('))) return answer;
            }
        }
        return stack.empty() ? "YES" : answer;
    }
}
