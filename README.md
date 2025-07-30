# Clases de estuctura de datos 

## Primera clase (24/07/2025)

 que vimos en esta clase?

- recursividad: Recordar que la recursividad es una funcionar que se llama asi misma.


````
//  lenguaje is JAVA 

public class fibonacii {
    public static void main(String[] args){
        int n = 5;
        System.out.println(fibonacii(n));
    }
    static int fibonacii(int n){
        if(n ==  0  || n == 1){
            return  n;
        }
        return  fibonacii(n-1) + fibonacii(n -2);
    }
}

`````
--- 
### El arbol de la recursidad
<!-- Esta imagen muestra el árbol de recursividad de Fibonacci -->

<p align="center">
  <img src="https://complex-systems-ai.com/wp-content/uploads/2016/02/fibo.png" alt="Árbol de Fibonacci">
</p>

---
## Segunda clase (29/07/2025)
- recursidad indirecta: son dos funciones que se llamas asi misma.
````
public class Alfabeto {
    public static void main(String[] args){
        metodoA('Z');
    }
    static void metodoA(char c) {
        if(c == 'A'){
         System.out.println(c);
        }else {
            metodoB(c);
            System.out.println(c);

        }
    }
    static void metodoB (char c){
        metodoA(--c);;
    }
}
````



