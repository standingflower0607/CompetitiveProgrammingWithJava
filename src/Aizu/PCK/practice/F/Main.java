package Aizu.PCK.practice.F;

import java.io.*;
import java.util.*;

public class Main {

    private static Map<Integer, Integer> values = new HashMap<>();

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(x>=0){
            if(y >= 0){
                // 1
            }else{
                // 4
            }
        }else{
            if(y >= 0){
                // 2
            }else{
                //3
            }
        }
        List<Integer> north = new ArrayList<>();
        // {2*2 + (n-1)*4} / 2
        List<Integer> east = new ArrayList<>();
        // {2*1 + (n-1)*4} / 2
        List<Integer> south = new ArrayList<>();
        // {2*5 + (n-1)*4} /2
        List<Integer> west = new ArrayList<>();
        // {2*3 + (n-1)*4} / 2
        for(int i=1; i<32; i++){
            if(i == 1 ) continue;
            if(i == 1+(i-1)*2){

            }else if(i == 2+(i-1)*2){

            }else if(i == 3+(i-1)*2){

            }else if(i == 5+(i-1)*2){

            }else{

            }

            out.println(fib(i));
        }

        out.flush();

    }

    public static int fib(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if(values.get(num) != null) return values.get(num);
        int m =  fib(num - 1) + fib(num - 2);
        values.put(num, m);
        return m;
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