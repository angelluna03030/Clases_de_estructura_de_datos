public class ElViajero {
    static int[] pesos = {800, 600, 300,400,200};
    static int[] valores = {60,48,14,31,10};
    static int optimo = 0;
    static int n= pesos.length;
    static boolean[] solucionActual = new boolean[n];
    static boolean [] solucionOptima= new boolean[n];
    static final int pesoTotal = 1100;
    public static void main(String[] args) {
        viajero(0, 0,0);

        System.out.println("valor optimo " + optimo);
        for (int i = 0; i < n; i++) {
            if (solucionOptima[i]){
                System.out.println("su peso es: "+ pesos[i] + " " + valores[i]);
            }


        }
    }

    static void viajero(int peso, int valor, int posicion){
        for (int i = posicion; i < n; i++) {
            int nuevoPeso = peso + pesos[i];
            int nuevoValor = valor  + valores[i];
            if(nuevoPeso <= pesoTotal){
                solucionActual[i] = true;
               if(nuevoPeso <= pesoTotal){
                    viajero(nuevoPeso, nuevoValor,i +1 );
                }
            }
            if (nuevoPeso <= pesoTotal) {
                solucionActual[i] = true;
                if (nuevoValor > optimo) {
                    optimo = nuevoValor;
                    System.arraycopy(solucionActual, 0, solucionOptima, 0 , n);
                }
                viajero(nuevoPeso, nuevoValor, i + 1);
                solucionActual[i] = false; // backtracking
            }
        }
    }
}
