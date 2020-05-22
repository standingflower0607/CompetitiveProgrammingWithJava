package Aizu.ALDS.ALDS1_3.B;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int totalTime = 0;
        ArrayDeque<Process> queue = new ArrayDeque<Process>();
        for (int i=0; i<n; i++){
            String name = sc.next();
            int time = sc.nextInt();
            Process process = new Process(name, time);
            queue.offerLast(process);
        }
        while(queue.size() > 0){
            Process process = queue.pollFirst();
            int time = process.getTime();
            if(time <= q){
                totalTime += time;
                System.out.println(process.getName() + " " + totalTime);
            }else{
                totalTime += q;
                process.reduceTime(q);
                queue.offerLast(process);
            }
        }

    }
    static class Process{
        private String name;
        private int time;
        public Process(String name, int time){
            this.name = name;
            this.time = time;
        }
        public int getTime(){
            return this.time;
        }
        public String getName(){
            return this.name;
        }
        public void reduceTime(int q){
            this.time -= q;
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
