package Lesson7_Stacks_and_Queues;

import java.util.*;

public class Nesting {

    public int solution(String S) {
        //C100/P100
        if (S.isEmpty()) {
            return 1;
        }

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < S.length(); ++i) {

            if (S.charAt(i) == '{' || S.charAt(i) == '[' || S.charAt(i) == '(') {

                left.push(S.charAt(i));

            } else if (S.charAt(i) == '}') {

                right.push('{');
                //if match that means that brackets are nested and we are removing matches from stack
                if (!left.isEmpty() && !right.isEmpty() && left.lastElement() == right.lastElement()) {

                    left.pop();
                    right.pop();
                }

            } else if (S.charAt(i) == ']') {

                right.push('[');

                if (!left.isEmpty() && !right.isEmpty() && left.lastElement() == right.lastElement()) {

                    left.pop();
                    right.pop();
                }
            } else if (S.charAt(i) == ')') {

                right.push('(');

                if (!left.isEmpty() && !right.isEmpty() && left.lastElement() == right.lastElement()) {

                    left.pop();
                    right.pop();
                }
            }
        }

        if (left.isEmpty() && right.isEmpty()) {

            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        Nesting N = new Nesting();
        String S = new String("())");

        System.out.println(N.solution(S));
    }
}
/*        
A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

class Solution { public int solution(String S); }
that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).*/
