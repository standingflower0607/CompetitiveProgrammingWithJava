package Aizu.ALDS.ALDS1_4.D;

import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 100000;
    private static int k;
    private static int n;
    private static int[] T = new int[MAX];

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i=0; i<n; i++) T[i] = sc.nextInt();
        long ans = solve();
        System.out.println(ans);

    }
    // P = 最大積載量
    static int check(long P){
        // i = 載せられる最大の荷物数
        int i = 0;
        for( int j=0; j < k; j++){
            long s = 0;
            while(s + T[i] <= P){
                s += T[i];
                i++;
                if(i == n) return n;
            }
        }
        return i;
    }

    static long solve(){
        long left = 0;
        long right = 100000 * 10000; // 最大の荷物数 *　重量
        long mid;
        while(right - left > 1){
            mid = (left + right) / 2;
            int v = check(mid); // mid == P を決めて何個積めるかチェック
            if( v >= n) right = mid;
            else left = mid;
        }
        return right;
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