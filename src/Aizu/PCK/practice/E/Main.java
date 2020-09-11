package Aizu.PCK.practice.E;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        ArrayDeque<Integer> catInfo = new ArrayDeque<>(n);
        int ans = 0;
        for(int i=0; i<n; i++) {
            int info = sc.nextInt();
            if (info > 0) {
                if (catInfo.contains(info)) {
                    ans = i + 1;
                    break;
                }
                catInfo.addLast(info);
            } else {
                if (Math.abs(info) != catInfo.getLast()) {
                    ans = i + 1;
                    break;
                }
                catInfo.pollLast();
            }
        }
        if(ans == 0) out.println("OK");
        else out.println(ans);

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