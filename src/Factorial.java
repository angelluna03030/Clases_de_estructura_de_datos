public class Factorial {

    public  static void main(String [] args){
        int n = 10;
        System.out.println(facotrial(n));

    }

    static  long facotrial(int n ){
        if(n== 0|| n==1 ) {
            return  1;
        }
        return  n * facotrial(n-1);
    }
}
