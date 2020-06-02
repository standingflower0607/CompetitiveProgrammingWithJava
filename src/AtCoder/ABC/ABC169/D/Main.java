package AtCoder.ABC.ABC169.D;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long N = sc.nextLong();
        int ans = 0;
        List<Pair> array = Factor(N);
        for(Pair pair: array){
            int exponent = pair.exponent;
            int b = 1;
            while(b <= exponent){
                exponent -= b;
                b++;
                ++ans;
            }
        }
        out.println(ans);

        out.flush();

    }

    static List<Pair> Factor(long x){
        List<Pair> res = new ArrayList<>();
        for(long i=2; i*i <= x; i++){
            int exponent = 0;
            while(x%i == 0){
                x /= i;
                exponent++;
            }
            if(exponent != 0) res.add(new Pair(i, exponent));
        }
        if(x != 1) res.add(new Pair(x, 1));
        return res;
    }


    static class Pair{
        private long base;
        private int exponent;

        public Pair(long base, int exponent){
            this.base = base;
            this.exponent = exponent;
        }

        @Override
        public String toString() {
            return this.base + " : " + this.exponent;
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