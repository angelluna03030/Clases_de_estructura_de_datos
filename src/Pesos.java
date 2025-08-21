public class Pesos {
    static int[] Pesos = {1, 2, 3, 4, 5};
    static int n = Pesos.length;
    static boolean[] solucion = new boolean[n];

    public static void main(String[] args) {
        buscar(0, 0);
    }

    static void buscar(int acumulado, int posicion) {
        for (int i = posicion; i < n; i++) {
            int peso = acumulado + Pesos[i];
            if (peso <= 10) {
                solucion[i] = true;
                if (peso == 10) {
                    imprimir();
                } else {
                    buscar(peso, i + 1);
                }
                solucion[i] = false; // backtracking
            }
        }
    }

    static void imprimir() {
        for (int i = 0; i < n; i++) {
            if (solucion[i]) {
                System.out.print(Pesos[i] + " ");
            }
        }
        System.out.println();
    }
}