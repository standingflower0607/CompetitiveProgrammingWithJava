package tmpTest.Div;

import java.io.*;
import java.util.*;
//　素因数分解
public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        List<Integer> array = printPrimeNumbers2(n);

        for(int num : array){
            out.println(num);
            int i = 1;
            while(n % num == 0 && n != 0){
                out.println(i);
                i++;
            }
        }

        out.flush();

    }
    // nまでの素数
    static List<Integer> printPrimeNumbers2(int maxNumber) {

        // ステップ1：「2から上限値までの整数」を探索リストに入れる。
        boolean[] targetNumbers = new boolean[maxNumber + 1];
        Arrays.fill(targetNumbers, true);
        targetNumbers[0] = false;
        targetNumbers[1] = false;

        // 素数リスト
        List<Integer> primeNumbers = new ArrayList<Integer>();

        int sqrt = (int) Math.sqrt(maxNumber);

        // ステップ3：探索リストの先頭の値が、引数の平方根に達するまでふるい落とし操作を続ける。
        for(int i=2; i<=sqrt; i++) {
            // ステップ2：探索リストの先頭の数を素数とし、その倍数を探索リストから篩い落とす。
            // ※この時、既に篩い落とされた数（false）は除外する。
            int firstNum = i;
            if (targetNumbers[i]) {
                for (int j=i*firstNum; j<targetNumbers.length; j+=firstNum) {
                    targetNumbers[j] = false;
                }
            }
        }

        // ステップ4：探索リストに残った値を素数リストに移して処理終了。
        for (int i=2; i<targetNumbers.length; i++) {
            if (targetNumbers[i]) {
                primeNumbers.add(i);
            }
        }

        // 素数の表示
        return primeNumbers;
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