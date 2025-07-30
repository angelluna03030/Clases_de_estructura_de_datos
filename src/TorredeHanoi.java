public class TorredeHanoi {
    public static void main(String[] args) {
        int n = 5;

        hanoi(n , '1', '3', '2');
    }
    static  void hanoi(int n, char origen, char destino , char aux){
        if (n == 1){
            System.out.println("Disco movido " + n  + " desde " + origen + " a " + destino );
        }else {
            hanoi(n - 1, origen, aux, destino);
            System.out.println("Disco movido " + n  + " desde " + origen + " a " + destino );
            hanoi(n - 1, aux, destino, origen);
        }
        }
}
