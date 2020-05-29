package Aizu.ALDS.ALDS1_6.A;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 20000001;
    private static final int VMAX = 10000;

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        // input
        int[] A = new int[n+1];
        // output
        int[] B = new int[n+1];
        // count を記録
        int[] C = new int[VMAX + 1];

        for(int i=0; i<n; i++){
            // i+1とするのは累計に変換する時にi-1を使いたいから
            A[i+1] = sc.nextInt();
            C[A[i+1]]++;
        }
        // 累計の数に変換
        for(int i=1; i<VMAX; i++){
            C[i] = C[i] + C[i - 1];
        }
        // 出力用の配列にソート
        for(int j=0; j<=n; j++){
            B[C[A[j]]] = A[j];
            C[A[j]]--;
        }

        // 結果出力
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(i == 1) builder.append(B[i]);
            else builder.append(" ").append(B[i]);
        }
        out.println(builder.toString());

        out.flush();

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