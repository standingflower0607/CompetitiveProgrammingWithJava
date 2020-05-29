package Aizu.ALDS.ALDS1_6.B;

import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX = 100000;
    private static int[] A = new int[MAX];

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) A[i] = sc.nextInt();
        int q = partition(0, n-1);
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<n; i++){
            if(i == 0) builder.append(A[i]);
            else if( i == q ) builder.append(" [").append(A[i]).append("]");
            else builder.append(" ").append(A[i]);
        }
        System.out.println(builder.toString());

    }

    static int partition(int p, int r){
        int x = A[r];
        int i = p - 1;
        int t;
        for(int j=p; j<r; j++){
            if (A[j] <= x) {
                i++;
                // swap
                t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
            // 大きかったらjを1進めるだけで良い
        }
        // swap
        t = A[i+1];
        A[i+1] = A[r];
        A[r] = t;
        return i+1;
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
