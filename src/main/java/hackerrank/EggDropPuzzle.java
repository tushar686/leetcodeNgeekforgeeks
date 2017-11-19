package hackerrank;

import java.util.*;

class EggDropPuzzle {

    public static void main (String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        sc.nextLine();
//        int[][] input = new int[T][];
//        for (int i=0; i<T; i++) {
//            int n = sc.nextInt();
//            input[i] = new int[n];
//            for (int j=0; j<n; j++) {
//                input[i][j] = sc.nextInt();
//            }
//        }
//
//         for (int i=0; i<T; i++) {
//             System.out.println(eggDrop(input[i]));
//         }

        System.out.println(eggDrop(2, 10));

    }

    static int eggDrop(int n, int k) {
        if (k == 1 || k == 0)
            return k;

        if (n == 1)
            return k;

        int min = Integer.MAX_VALUE, x, res;

        for (x = 1; x <= k; x++) {
            res = max(eggDrop(n-1, x-1), eggDrop(n, k-x));
            if (res < min)
                min = res;
        }

        return min + 1;
    }

    static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    int eggDrop_DP(int n, int k)
    {
        /* A 2D table where entery eggFloor[i][j] will represent minimum
           number of trials needed for i eggs and j floors. */
        int[][] eggFloor = new int[n+1][k+1];
        int res;
        int i, j, x;
     
        // We need one trial for one floor and0 trials for 0 floors
        for (i = 1; i <= n; i++)
        {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }
     
        // We always need j trials for one egg and j floors.
        for (j = 1; j <= k; j++)
            eggFloor[1][j] = j;
     
        // Fill rest of the entries in table using optimal substructure
        // property
        for (i = 2; i <= n; i++)
        {
            for (j = 2; j <= k; j++)
            {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++)
                {
                    res = 1 + max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }
     
        // eggFloor[n][k] holds the result
        return eggFloor[n][k];
    }

}