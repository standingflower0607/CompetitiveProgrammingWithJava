package AtCoder.ABC.ABC170.D;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int ans = 0;
        int[] array = new int[n];
        for(int i=0; i<n; i++) array[i] = ( sc.nextInt());
        Arrays.sort(array);
        out.println(Arrays.toString(array));
        for(int i=n -1; i>=0; i--){
            int target = array[i];
            out.print(" target : " + target);
            for(int j =1; j<n; j++){
                int num = j;
                out.print(" num : " + num);
                if(target == num) break;
                if(num > target / 2 ){
                    ans++;
                    out.println();
                    out.println(ans);
                    break;
                }

                if(target % num == 0){
                    out.println();
                    out.println(ans);
                    break;
                }
                out.println();
                out.println(ans);
            }
        }
        out.println();
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