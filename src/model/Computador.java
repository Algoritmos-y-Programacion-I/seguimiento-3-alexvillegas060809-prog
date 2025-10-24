package model;
import java.util.ArrayList;

public class Computador {
    private String serial;
    private int piso;
    private int columna;
    private ArrayList<String> incidentes;

    public Computador(String serial, int piso, int columna) {
        this.serial = serial;
        this.piso = piso;
        this.columna = columna;
        this.incidentes = new ArrayList<>();
    }

    public String getSerial() { return serial; }
    public int getPiso() { return piso; }
    public int getColumna() { return columna; }

    public void agregarIncidente(String descripcion) {
        incidentes.add(descripcion);
    }

    public int getCantidadIncidentes() {
        return incidentes.size();
    }
}
