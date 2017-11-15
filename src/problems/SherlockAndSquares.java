package problems;

import java.util.Scanner;

/**
 * Created by laerteguedes on 15/11/17.
 * Challenge link https://www.hackerrank.com/challenges/sherlock-and-squares/problem
 */
public class SherlockAndSquares {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] a = new int[2];

        for (int i = 0; i < n; i++) {
            for (int a_i = 0; a_i < 2; a_i++) {
                a[a_i] = in.nextInt();
            }

            System.out.println(countSquaresInRange(a[0], a[1]));
        }
    }

    private static int countSquaresInRange(int a, int b){
        int count = 0;
        boolean calcDiff = false;
        int firstSquare = 0;

        for (int i = a; i <= b; i++){
            Double square = Math.sqrt(i);
            int squareInt = square.intValue();

            if (square % squareInt == 0){
                count++;

                if (calcDiff){
                    int aux = i;
                    i += i-firstSquare;
                    firstSquare = aux;
                }else{
                    firstSquare = i;
                    calcDiff = true;
                }
            }
        }

        return count;
    }

}
