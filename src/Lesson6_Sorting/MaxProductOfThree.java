package Lesson6_Sorting;

import java.util.Arrays;

public class MaxProductOfThree {

    //C100%/P100%
    public int solution(int[] A) {

        if (A.length == 0) { //if empty
            return 0;
        }

        if (A.length == 1) { //if one or two element
            return A[0];
        } else if (A.length == 2) {
            return A[0] * A[1];
        }

        int maxvalue = Integer.MIN_VALUE;
        int P, Q, R;

        Arrays.sort(A); //sorting array

        //when array is sorted, first two numbers multiplied with 
        //one positive value (last number of array - the greatest number) gives 
        //positive value - first posible combination
        P = A[0];
        Q = A[0 + 1];
        R = A[A.length - 1];

        if (P * Q * R > maxvalue) {
            maxvalue = P * Q * R;
        }

        //last three numbers of sorted array are also the greatest numbers - second posible combinaton
        P = A[A.length - 2];
        Q = A[A.length - 3];

        if (P * Q * R > maxvalue) {
            maxvalue = P * Q * R;
        }

        return maxvalue;
    }

    public static void main(String[] args) {

        MaxProductOfThree MPT = new MaxProductOfThree();
        int[] A = new int[]{-4, -6, 3, 4, 5};

        System.out.println(MPT.solution(A));
    }
}
/*A non-empty zero-indexed array A consisting of N integers is given. The 
product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:

(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:

class Solution { public int solution(int[] A); }
that, given a non-empty zero-indexed array A, returns the value of the maximal 
product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Assume that:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(1), beyond input storage (not counting 
the storage required for input arguments).
Elements of input arrays can be modified.*/
