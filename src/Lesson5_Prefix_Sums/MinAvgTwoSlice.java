package Lesson5_Prefix_Sums;

public class MinAvgTwoSlice {

    public int solution(int[] A) {

        //C100%/P100%
        //there is no need for casting elements but I'll keep that in this case
        double small = Double.MAX_VALUE;
        int smallest = 0;
        double temp = 0; //for i++ element, if i = A.length-1 temp = 0 
        for (int i = 1; i < A.length; i++) {

            if (i < A.length - 1) {

                temp = A[i + 1];
            }

            if (((double) A[i - 1] + (double) A[i]) / 2 < small) { //casting every single element 

                small = ((double) A[i - 1] + (double) A[i]) / 2; //average of A[i] and A[i-1]
                smallest = i - 1; //always begining of slice
            }
            if (i != A.length - 1) { //checking this block only if i != A.length-1, it is adding temp variable to average

                if (((double) A[i - 1] + (double) A[i] + (double) temp) / 3 < small) {

                    small = ((double) A[i - 1] + (double) A[i] + (double) temp) / 3;
                    smallest = i - 1;
                }
            }
            temp = 0;
            temp = (double) temp;
        }

        return smallest;
    }

    public static void main(String[] args) {

        MinAvgTwoSlice MATS = new MinAvgTwoSlice();

        int[] A = new int[]{10, 10, -1, 2, 4, -1, 2, -1};//-3, -5, -8, -4, -10 //4,2,2,5,1,5,8
        //For example, for the input [10, 10, -1, 2, 4, -1, 2, -1] the solution returned a wrong answer (got 2 expected 5).

        System.out.println(MATS.solution(A));

    }

}
/*A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:

class Solution { public int solution(int[] A); }
that, given a non-empty zero-indexed array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.*/
