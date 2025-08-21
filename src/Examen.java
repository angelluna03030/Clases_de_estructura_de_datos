public class Examen {
    /*
    Una región está formada por n pueblos dispersos.
    Hay conexiones directas entre algunos de ellos, y entre otros no existe conexión directa, aunque puede haber un camino.
    Escribir una aplicación que dada una matriz que representa las conexiones directas entre pueblos, de tal forma que el elemento M(i,j) de la matriz sea:
                             0 si no hay conexión directa desde el pueblo i hasta el pueblo j,
                             M(i, j) =
                             d si hay conexión desde el pueblo i hasta el pueblo j con distancia d
                             Dados un par de pueblos (x,y).
                             La aplicación tiene que encontrar un camino entre ambos pueblos con la distancia más corta utilizando técnicas recursivas.
                             La salida ha de ser la ruta que se ha de seguir para ir de x a y junto a la distancia de la ruta.
                             M = { {0,4,0,2,0,0}, {4,0,3,0,3,0}, {0,3,0,0,0,2}, {2,0,0,0,3,0}, {0,3,0,3,0,1}, {0,0,2,0,1,0} }
                             Con x = 0, y = 5, una solución sería: 0, 3, 4, 5. Distancia = 6.
     */

    // Variables para almacenar la mejor ruta y distancia mínima
    static int minDist = Integer.MAX_VALUE;
    static int[] mejorRuta = null;

    // Método recursivo para buscar el camino más corto
    static void buscarCaminoMin(int actual, int destino, boolean[] visitados, int[] ruta, int idx, int dist) {
        visitados[actual] = true;
        ruta[idx] = actual;

        if (actual == destino) {
            if (dist < minDist) {
                minDist = dist;
                mejorRuta = new int[idx + 1];
                System.arraycopy(ruta, 0, mejorRuta, 0, idx + 1);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (M[actual][i] > 0 && !visitados[i]) {
                    buscarCaminoMin(i, destino, visitados, ruta, idx + 1, dist + M[actual][i]);
                }
            }
        }
        visitados[actual] = false;
    }
}