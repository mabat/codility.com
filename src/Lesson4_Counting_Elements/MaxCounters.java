package Lesson4_Counting_Elements;

public class MaxCounters {

    public int[] solution(int N, int[] A) {

        // C100%/P100%
        int[] rj = new int[N];
        int maxvalue = 0;
        int temp = 0;

        // checking if all elements of an array are greater than N
        for (int k = 0; k < A.length; k++) {

            if (A[k] > N) {
                temp++;

            } else {

                break;
            }
        }
        // if all elements of array are greater than N, than result will be
        // array with all zero elements
        if (temp == A.length) {

            for (int j = 0; j < N; ++j) {
                rj[j] = maxvalue;
            }
            return rj;
        }

        // regular checking
        for (int i = 0; i < A.length; ++i) {

            if (A[i] <= N) {
                rj[A[i] - 1]++; // increasing result element

                if (rj[A[i] - 1] > maxvalue) {

                    maxvalue = rj[A[i] - 1]; // remembering max element of
                                            // result array
                }

            } else {
                // if element of original array is greater than N, than all
                // element of result array are becoming maxvalue
                for (int j = 0; j < N; ++j) {
                    rj[j] = maxvalue;
                }
            }
        }
        return rj;
    }

    public static void main(String[] args) {

        MaxCounters MC = new MaxCounters();
        int[] A = {4, 5, 6, 8, 6, 7};
        int N = 3;

        int[] rj = MC.solution(N, A);

        for (int i = 0; i < rj.length; ++i) {

            System.out.println(rj[i] + " ");
        }
    }
}

/*You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }
that, given an integer N and a non-empty zero-indexed array A consisting of M integers, returns a sequence of integers representing the values of the counters.

The sequence should be returned as:

a structure Results (in C), or
a vector of integers (in C++), or
a record Results (in Pascal), or
an array of integers (in any other programming language).
For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Assume that:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
Complexity:

expected worst-case time complexity is O(N+M);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.*/
