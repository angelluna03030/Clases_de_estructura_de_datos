public class AjedrezReinas {
    static final int N = 8;
    static final int n = (N +1);
    static   int [] reinas = new int[n];
    public static void main(String[] args) {
posicionar(1);
    }
    static void posicionar(int columna){
        for (int fila =1; fila <= N; fila++){
            if (valido(fila, columna)){
                reinas[columna] = fila;
                if (columna == N){
                    imprimir();
                    System.exit(1);
                }else {
                    posicionar(columna + 1);
                    //Backtracking
                    reinas[columna] = 0;
                }

            }

        }

    }

    static boolean valido(int f, int c){
        for (int rc =1; rc < c ; rc++){
            int rf = reinas[rc];
            if (f == rf ||(f+c == rf+rc) || (f -c == rf -rc)){
                return false;
            }
        }
     return true;

    }
static void imprimir (){
    for (int c = 1; c < n; c++) {
        System.out.println(reinas[c ] + " "+ c);
    }
}
}
