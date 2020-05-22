package Aizu.ALDS.ALDS1_3.D;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        ArrayDeque<Integer> s1 = new ArrayDeque<>();
        ArrayDeque<Pair> s2 = new ArrayDeque<>();
        String landScape = sc.nextLine();
        int totalArea = 0;
        for(int i=0; i<landScape.length(); i++){
            char shape = landScape.charAt(i);
            if(shape == '\\') s1.offerLast(i);
            else if(shape == '/' && s1.size() > 0){
                int j = s1.pollLast();
                int area = i - j;
                totalArea += area;
                int a = i - j;
                while(s2.size() > 0 && s2.peek().first > j){
                    a += s2.pollFirst().area;
                }
                s2.push(new Pair(j ,a));
            }

        }
        System.out.println(totalArea);
        System.out.print(s2.size());
        while(s2.size() > 0){
            System.out.print(" ");
            System.out.print(s2.pollLast().area);
        }

    }
    public static class Pair{
        private int first;
        private int area;
        public Pair(int first, int area){
            this.first = first;
            this.area = area;
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