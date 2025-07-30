public class SumaDigitos {
    public static void main(String[]args){
    int n = 9876;
        System.out.println(suma(n));
    }
    static int suma(int n){
        if (n < 10){
            return n ;
        }else {
            return n % 10 + suma(n/10);
        }
    }
}
