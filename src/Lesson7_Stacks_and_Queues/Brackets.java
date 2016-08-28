package Lesson7_Stacks_and_Queues;

import java.util.*;

public class Brackets {
    //C100/P100

    public int solution(String S) {

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

        Brackets B = new Brackets();
        String S = new String("{{{{{{{");

        System.out.println(B.solution(S));

    }
}
/*A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }
that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).*/
