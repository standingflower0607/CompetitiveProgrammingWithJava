package Aizu.ALDS.ALDS1_4.A;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int[] S = new int[n + 1];
        for(int i=0; i<n; i++)  S[i] = sc.nextInt();
        int q = sc.nextInt();
        int[] T = new int[q];
        for(int i=0; i<q; i++) T[i] = sc.nextInt();
        int ans = 0;
        for(int key : T){
            if(linearSearch(S, n ,key)) ans++;
        }
        System.out.println(ans);

    }
    public static boolean linearSearch(int[] A, int n, int key){
        int i = 0;
        A[n] = key;
        while(A[i] != key)i++;
        return i != n;
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