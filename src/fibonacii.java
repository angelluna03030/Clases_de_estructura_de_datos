public class fibonacii {
    public static void main(String[] args){
        int n = 8;
        System.out.println(fibonacii(n));
    }
    static int fibonacii(int n){
        if(n ==  0  || n == 1){
            return  n;
        }
        return  fibonacii(n-1) + fibonacii(n -2);
    }
}
