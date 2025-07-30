public class Mcd {
    public static void main(String[] args) {
int m = 24;
int n= 24;
System.out.println(mcd(m,n));

    }
    static int mcd(int m , int n) {
        if (n <= m && m % n == 0) {
            return n;
        }else if(m<n){
            return mcd(n,m);

        }else {
            return mcd(n,m);
        }
    }

}

