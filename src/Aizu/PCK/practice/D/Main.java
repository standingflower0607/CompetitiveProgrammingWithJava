package Aizu.PCK.practice.D;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] adresses= new int[n];
        for(int i=0; i<n; i++) adresses[i] = sc.nextInt();
        Arrays.sort(adresses);
        int dif = (adresses[n - 1] - adresses[0]);
        int ans = 0;
        if(dif % 2 == 0) ans = dif /2;
        else ans = dif / 2 + 1;
        out.println(ans);
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
