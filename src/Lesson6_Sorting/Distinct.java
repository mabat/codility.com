package Lesson6_Sorting;

import java.util.Arrays;

public class Distinct {

    public int solution(int[] A) {
            
            //C100%/P100%
        
        if (A.length == 0){ //if empty
            
            return 0;
        }
        
        Arrays.sort(A); //sorting array
        
        int distinct = 1; //begining from A[i]
        int last = A[0];  //remebering last element in loop
        
        if (A.length == 1){
            
            return distinct;
        }

        for (int i = 1; i < A.length; ++i) {

            if (A[i] != last) {
                distinct++;
                last = A[i];
            }
        }
        return distinct;
    }

    public static void main(String[] args) {

        Distinct D = new Distinct();
        int[] A = new int[]{};

        System.out.println(D.solution(A));

    }

}
/*Write a function

int solution(int A[], int N);
that, given a zero-indexed array A consisting of N integers, returns the number of distinct values in array A.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
For example, given array A consisting of six elements such that:

A[0] = 2    A[1] = 1    A[2] = 1
A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.*/
