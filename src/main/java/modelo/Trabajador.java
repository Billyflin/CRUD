package modelo;

import java.util.ArrayList;

public class Trabajador extends Persona{

    private String isapre;
    private String afp;
    private static ArrayList<Trabajador> trabajadores;

    public Trabajador(){
        trabajadores = new ArrayList<>();
    }

    public Trabajador(String isapre, String afp) {
        this.isapre = isapre;
        this.afp = afp;
    }

    public Trabajador(String nombre, String apellido, String rut, String isapre, String afp) {
        super(nombre, apellido, rut);
        this.isapre = isapre;
        this.afp = afp;
    }

    public String getIsapre() {
        return isapre;
    }

    public void setIsapre(String isapre) {
        this.isapre = isapre;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public static ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public static void addTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    @Override
    public String toString() {
        return nombre +
                ","+apellido +
                "," + rut +
                "," + isapre +
                "," + afp;
    }
}
