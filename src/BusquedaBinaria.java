public class BusquedaBinaria {
    static  int [] a = {10, 25, 30 ,70, 100, 110, 145, 200};

    public static void main(String[] args) {
        //cualuqiere valor pero que esten ordandos de forma acendente.
System.out.println(busqBin(20, 0, a.length - 1));
    }
    static int busqBin(int clave, int inferior, int superior){

        try {
            if(inferior > superior){
                return  -1;
            }
            int central = (inferior + superior) / 2;
            if (clave == a[central] ){
                return central;
            }
            if (clave < a[central]){
                return busqBin(clave, inferior, central-1);
            }
            return busqBin(clave, central +1 , superior);

        }catch (Exception e){
            System.out.println("Error" + e);
        }

        return clave;
    }
}
