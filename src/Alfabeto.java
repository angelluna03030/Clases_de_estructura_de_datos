
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
