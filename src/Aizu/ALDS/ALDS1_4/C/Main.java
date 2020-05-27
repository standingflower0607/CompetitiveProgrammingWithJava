package Aizu.ALDS.ALDS1_4.C;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        HashSet<String> set = new HashSet<>();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String com = sc.next();
            String str = sc.next();
            if(com.charAt(0) == 'i'){
                // insert
                set.add(str);
            }else{
                // find
                if(set.contains(str)) System.out.println("yes");
                else System.out.println("no");
            }

        }

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