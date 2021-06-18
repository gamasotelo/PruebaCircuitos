
public class Matrices {
    int numero_nodos;
    Matrices(int numero_nodos){
        this.numero_nodos = numero_nodos;
    }
    
    public void obtenerTodasLasConexiones(String[][] arreglo){
        //Cambiar los sout por almacenamiento en algun arreglo
        
        int a = arreglo.length;
        int incrementor_aux =0;
        for (int i = 0; i < a; i+=2) {
            System.out.println("");
            for (int j = 0; j < a; j++) {
                if(arreglo[i-incrementor_aux][j] != null)
                    System.out.print(arreglo[i-incrementor_aux][j]);
            }
            incrementor_aux++;
            if(i + 2 < numero_nodos ){
                System.out.println(i + 2);
            }
            
        }
    }
}
