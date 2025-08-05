public class NumeroEnteroBase10 {
    //#CREADO POR ANGEL STEVEN GARCIA LUNA 
    public static void main(String[] args) {
        /*
        *Escribir un programa recursivo no interactivo que transforme un
        * número entero en base 10 a otro en base b, siendo b un valor entre 2 y 16.
        *El número a transformar (n) y la base destino (b) se colocan directamente
        * en el programa principal
        */
        int n = 16;
        int b = 16;
        TransformacionDeNumero(n,b);
        saludo();
    }


    static void TransformacionDeNumero(int numero ,int base ) {
        char[] simbolos = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'}; // simbolos que vamos a usar :D
        if (base >= 2 && base <= 16) {
            // este condicional verifica que la el numero sea menor que la base
            if (numero < base) {
                System.out.print(simbolos[numero]); // caso base
            }
            else if(numero >= base) {
                int cociente = numero / base;
                int resto = numero % base;
                TransformacionDeNumero(cociente, base); // llamada recursiva
                System.out.print(simbolos[resto]);     // mostrar el dígito
            }
        }else  {
            System.out.println("la base debe estar entre 2 y 16 ");
        }

    }


static void saludo(){
    System.out.println("\n");
    System.out.println("╔════════════════════════════════════════════╗");
    System.out.println("║    💻 Creado por: ANGEL STEVEN GARCIA LUNA ║");
    System.out.println("║     🚀 TRANSFORMACIÓN DE NUMEROS           ║");
    System.out.println("╚════════════════════════════════════════════╝");
}
}



//!CREADO POR ANGEL STEVEN GARCIA LUNA
