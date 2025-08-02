public class Ajedrez {
    static final int N = 8;
    static final int n = N +1;
    static int [][] tablero= new int[n][n];
    static int [][] d = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};

    public static void main(String[] args) {
        tablero[1][1] = 1;
           saltar(1, 1,1 );
    }
    static void saltar(int NumeroDeSaltos, int x, int y ){
        for (int k = 0 ; k < d.length ;  k ++){
            int nx = x + d[k][0];
            int ny = y + d[k][1];
            if (nx >= 1 && ny >= 1 && nx <= N && ny <= N && tablero[nx][ny] == 0) {
                tablero[nx][ny] = NumeroDeSaltos + 1;
                if (NumeroDeSaltos == N*N ){
                    imprimir();
                }else {
                    saltar(NumeroDeSaltos +1 , nx , ny);
                    //backtraking
                    tablero[nx][ny] =0;
                }
            }

        }
    }
    static void imprimir (){
        for (int i = 1; 1<= N; i++ ) {
            for (int j = 1; j <= N; j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }

    }

}
