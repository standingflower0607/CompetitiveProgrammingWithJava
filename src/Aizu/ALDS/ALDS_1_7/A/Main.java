package Aizu.ALDS.ALDS_1_7.A;

import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX = 100005;
    private static Node[] T = new Node[MAX];
    private static int[] D = new int[MAX];

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){

        }

        for(int i=0; i<n; i++){
            int id = sc.nextInt();
            int degree = sc.nextInt();
            for(int j=0; j<degree; j++){
                int child = sc.nextInt();
                // left-child を設定
                if(j == 0) T[id].left = child;
                else T[l].reft = child;
                int l = child;
                // parent を設定
                T[child].parent = id;
            }
        }

        out.flush();

    }

    static class Node{
        private int parent;
        private int left;
        private int right;
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