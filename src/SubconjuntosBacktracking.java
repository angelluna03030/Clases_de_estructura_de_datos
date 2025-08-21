public class SubconjuntosBacktracking {
    public static void main(String[] args) {
        int m = 4;
        int n = 2;
        backtrack(m, n, 0, "");
        System.out.println("ANGEL STEVEN GARCIA LUNA");
    }

    static void backtrack(int m, int n, int indice, String actual) {
        char[] letras = new char[m];
        for (int i = 0; i < m; i++) {
            letras[i] = (char) ('A' + i);
        }

        if (actual.length() == n) {
            System.out.println(actual);
            return;
        }

        if (indice >= m) {
            return;
        }

        backtrack(m, n, indice + 1, actual + letras[indice]);
        backtrack(m, n, indice + 1, actual);
    }
}

