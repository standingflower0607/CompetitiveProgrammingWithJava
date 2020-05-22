package tmpTest.time;

public class Main {
    public static void main(String[] args){
        long start = System.nanoTime();
        long end = 0;
        long time = 0;
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        // A
        if(str.charAt(100) == 'b'){
            System.out.println("found it");
        }
        // B
        if(str == "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"){
            System.out.println("found it");
        }
        end = System.nanoTime();
        time = end - start;
        System.out.println(time);
        // A 172189nano
        // B 237432nano
    }
}
