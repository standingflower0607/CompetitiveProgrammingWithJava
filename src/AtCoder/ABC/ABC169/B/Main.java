package AtCoder.ABC.ABC169.B;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        ArrayList<BigInteger> array = new ArrayList<BigInteger>();
        BigInteger result = BigInteger.valueOf(1);
        BigInteger x = BigInteger.valueOf(1);
        for(int i=0; i<18; i++) x = x.multiply(BigInteger.valueOf(10));
        for(int i=0; i<n; i++){
            BigInteger input = BigInteger.valueOf(sc.nextLong());
            if(input == BigInteger.ZERO){
                out.println(0);
                out.flush();
                return;
            }else{
                array.add(input);
            }
        }

        for(BigInteger num : array){
            result = result.multiply(num);

            if(result.compareTo(x) == 1) {
                out.println("-1");
                out.flush();
                return;
            }
        }

        out.println(result);



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