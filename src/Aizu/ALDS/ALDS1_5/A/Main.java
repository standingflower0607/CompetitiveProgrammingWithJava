package Aizu.ALDS.ALDS1_5.A;

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] A = new int[20];

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        n = sc.nextInt();
        for(int i=0; i<n; i++) A[i] = sc.nextInt();
        int q = sc.nextInt();
        for(int i=0; i<q; i++) {
            int M = sc.nextInt();
            if(solve(0,M)) System.out.println("yes");
            else System.out.println("no");
        }
    }

    static boolean solve(int i, int m){
        if(m == 0) return true;
        if(i >= n) return false;
        // solve(i+1, m)はその要素を使わない
        // solve(i+1, m - A[i])はその要素を使う
        boolean res = solve(i + 1,m) || solve(i + 1, m - A[i]);
        return res;
    }

    static class FastScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;

        public FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }

        public String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return tokenizer.nextToken("\n");
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}