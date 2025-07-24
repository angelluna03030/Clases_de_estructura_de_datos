//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int parametro = 2;
        System.out.println(suma(parametro));
    }

    static int suma (int n ){
        if(n == 1){
            return  1;
        }else {
            return  n +  suma(n-1);
        }

    }
}