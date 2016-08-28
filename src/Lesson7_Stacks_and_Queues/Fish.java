package Lesson7_Stacks_and_Queues;

import java.util.Stack;

public class Fish {

    public int solution(int[] A, int[] B) {

        Stack<Integer> weight = new Stack<>(); //stack for A array elements
        Stack<Integer> direction = new Stack<>(); //stack for B array elements

        weight.push(A[0]); //put first elements in stacks
        direction.push(B[0]);

        for (int i = 1; i < A.length; ++i) {

            if (direction.lastElement() == 1 && B[i] == 1) { //situation with 1 in stack and 1 in for loop

                weight.push(A[i]);
                direction.push(B[i]);

            } else if (direction.lastElement() == 0 && B[i] == 1) { //situation with 0 in stack and 1 in for loop

                weight.push(A[i]);
                direction.push(B[i]);

            } else if (direction.lastElement() == 0 && B[i] == 0) { //situation with 0 in stack and 0 in for loop

                weight.push(A[i]);
                direction.push(B[i]);

            } else if (direction.lastElement() == 1 && B[i] == 0) { //situation with 1 in stack and 0 in for loop

                if (weight.lastElement() > A[i]) { //if stack element is greater than loop element than it eats loop element(fish)
                    continue;
                } else {
                    //checking stacks emptyness and if stack element is lower than loop element we remove it from stack;
                    //while loop is for situation when we have lot of 1 on the stack and we need to check'em all
                    while (!weight.isEmpty() && !direction.isEmpty() && A[i] > weight.lastElement() && direction.lastElement() == 1) {
                        weight.pop();
                        direction.pop();
                    }
                    //when loop is finished, we are comparing last stack element and loop element, if stack is greater loop continues, else we are pushing element to the stack
                    if (!weight.isEmpty() && !direction.isEmpty() && weight.lastElement() > A[i] && direction.lastElement() == 1 && B[i] == 0) {

                        continue;

                    } else if (weight.isEmpty() && direction.isEmpty() || direction.lastElement() == 0) {
                        weight.push(A[i]);
                        direction.push(B[i]);
                    }
                }
            }
        }
        return weight.size();
    }

    public static void main(String[] args) {
        Fish F = new Fish();

//        int[] A = {20, 30, 10, 6, 5, 7, 11};
//        int[] B = {0, 0, 1, 1, 1, 0, 0};
        int[] A = {0};
        int[] B = {1};

        System.out.println(F.solution(A, B));
    }
}
