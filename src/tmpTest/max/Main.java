package tmpTest.max;

public class Main {
    public static void main(String[] args){
        int[] A = new int[]{1,3,4,7,2,4,3};
        int max = findMax(A, 0, A.length);
        System.out.println(max);

    }
    public static int findMax(int[] A, int l, int r){
        int mid = (l + r) / 2;
        int x;
        if(l == r -1) return A[l];
        else{
            int u= findMax(A, l, mid);
            int v = findMax(A, mid, r);
            x = Math.max(u, v);
        }
        return x;
    }
}
