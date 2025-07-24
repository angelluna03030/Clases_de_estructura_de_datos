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
<br>


![Árbol de recursividad](https://complex-systems-ai.com/wp-content/uploads/2016/02/fibo.png)


---