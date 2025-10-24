package model;


public class SchoolController  {

    /*Matriz d(5 pisos, 10 columnas cada uno)*/
    private Computador[][] computadores;

    /*Constructor: crea la matriz vacía*/
    public SchoolController() {
        computadores = new Computador[5][10];
    }

     /*0Agregar un computador nuevo*/

    public boolean agregarComputador(String serial, int piso) {

        /*  Verificar que no exista otro con el mismo serial*/
        if (buscarComputador(serial) != null) {
            return false;
        }

        /*  Revisar que el piso sea válido*/ 
        if (piso < 1 || piso > 5) {
            return false; // piso fuera de rango
        }

        /*  Buscar la primera columna libre en ese piso*/
        for (int col = 0; col < 10; col++) {
            if (computadores[piso - 1][col] == null) {
                computadores[piso - 1][col] = new Computador(serial, piso, col + 1);
                return true; 
            }
        }

        return false; 
    }

    
    /*  Registrar un incidente*/
    
    public boolean registrarIncidente(String serial, String descripcion) {
        Computador comp = buscarComputador(serial);

        if (comp != null) {
            comp.agregarIncidente(descripcion);
            return true; 
        }

        return false; 
    }

   /*buscar el computador por el serial  */
    public Computador buscarComputador(String serial) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (computadores[i][j] != null && computadores[i][j].getSerial().equals(serial)) {
                    return computadores[i][j];
                }
            }
        }return null;
    }

   
    /*Consultar el computador con más incidentes*/
   
    public Computador computadorConMasIncidentes() {
        Computador max = null;
        int mayor = -1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (computadores[i][j] != null) {
                    int cantidad = computadores[i][j].getCantidadIncidentes();
                    if (cantidad > mayor) {
                        mayor = cantidad;
                        max = computadores[i][j];
                    }
                }
            }
        }

        return max;
    }
}


