package Aizu.ALDS.ALDS1_3.C;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        ArrayDeque<String> array = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<n; i++){
            String command = sc.nextLine();
            if(command.charAt(0) == 'i'){
                array.addFirst(command.substring(7));
            }else{
                if(command.charAt(6) == 'F'){
                    // deleteFirst
                    array.removeFirst();
                }else if(command.charAt(6) == 'L'){
                    // deleteLast
                    array.removeLast();
                }else{
                    // delete
                    array.remove(command.substring(7));
                }
            }
        }
        int num = 0;

        while(!array.isEmpty()){
            if(num == 0) ans.append(array.pollFirst());
            else ans.append(" ").append(array.pollFirst());
            num++;
        }
        System.out.println(ans.toString());

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
