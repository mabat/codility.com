package Lesson3_Time_Complexity;

public class PermMissingElem {

    public int solution(int[] A) {
        //C100%/P100%
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int Asum = 0; //sum of elements in array A
        int fullsum = 0; //full sum between min and max element in array, while loop increasing by one

        //if array is empty return first bigger A()
        if (A.length == 0) {
            return 1;
        }
        // checking one element, lower or greater than 1
        if (A.length == 1) {

            if (A[0] > 1) { //A(2)

                return A[0] - 1;

            } else {//A(1)

                return A[0] + 1;
            }
        }

        for (int i = 0; i < A.length; ++i) {

            Asum += A[i];

            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }
        //if there are two elements in array A(2,3)
        if (min + 1 == max && min > 1) {

            return min - 1;

        } else if (min + 1 == max && min == 1) {
            //A(1,2)
            return max + 1;

        } else {

            int temp = min;//becauSe we need original value of min later

            while (temp <= max) {

                fullsum += temp;
                temp++;
            }

            //for example (2,3,4,5)			
            if (fullsum == Asum && min > 1) {
                return min - 1;
            }

            //for example (1,2,3,4,5)
            if (fullsum == Asum && min == 1) {
                return max + 1;
            } else {
                //everything else
                return fullsum - Asum;
            }
        }
    }

    public static void main(String[] args) {

        PermMissingElem PME = new PermMissingElem();
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(PME.solution(A));

    }

}

/*A zero-indexed array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }
that, given a zero-indexed array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Assume that:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.*/
