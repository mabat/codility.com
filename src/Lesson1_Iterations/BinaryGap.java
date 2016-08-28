package Lesson1_Iterations;

public class BinaryGap {

    public int solution(int N) {

        int n1 = 0;
        int n2 = 0;
        int N2 = N;

        while (N > 0) {

            if (N2 % 2 != 0) {

                if (N % 2 == 0) {
                    n1++;
                } else if (n1 >= n2) {
                    n2 = n1;
                    n1 = 0;
                } else {
                    n1 = 0;
                }
                N /= 2;

            } else {
                N2 /= 2;
                N /= 2;
            }
        }
        return n2;
    }

    public static void main(String[] args) {

        BinaryGap b = new BinaryGap();

        System.out.println(b.solution(1376796946));
    }
}

/* 100%
 A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.

Assume that:

N is an integer within the range [1..2,147,483,647].
Complexity:

expected worst-case time complexity is O(log(N));
expected worst-case space complexity is O(1).*/