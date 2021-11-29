package servicio;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import interfaz.CRUD;
import modelo.Trabajador;

import java.io.*;
import java.util.ArrayList;

public class ServicioTrabajador implements CRUD {

    private final Trabajador trabajador;
    private final File archivo;
    private final ArrayList<Trabajador> trabajadores=new ArrayList<>();

    public ServicioTrabajador(String ruta) {
        this.trabajador = new Trabajador();
        this.archivo = new File(ruta);
    }

    @Override
    public boolean crear() {

        if (!archivo.exists()) {
            try {
                return archivo.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    @Override
    public String leer() {

        var informacion = new ArrayList<String>();
        String[] lineas;
        String cadena;

        try {
            if (!archivo.exists()) {
                throw new FileNotFoundException();
            }

            var lector = new BufferedReader(new FileReader(archivo));

            while ((cadena = lector.readLine()) != null) {
                lineas = cadena.split("\n");
                informacion.add(lineas[0]);
            }

            lector.close();

        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo: " + e.getMessage());
            return null;
        } catch (IOException e) {
            System.err.println("Fallo al leer el archivo: " + e.getMessage());
        }

        return informacion.toString();
    }

    @Override
    public boolean actualizar(String nuevaData) {

        if(!archivo.exists()){
            return false;
        }
        FileWriter escritor = null;
        try {
            escritor = new FileWriter(archivo);
            escritor.write(nuevaData);
            escritor.close();
        } catch (IOException e) {
            System.err.println("Fallo al leer el archivo: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean borrar() {

        if (archivo.exists()) {
            return archivo.delete();
        }
        return false;
    }

    public boolean verificarSiTrabajadorExiste(Trabajador trabajadorBuscado) {

        return !Trabajador.getTrabajadores()
                .contains(trabajadorBuscado);
    }

    public static final String RUTA_GUARDADO = "src/main/resources/Data.csv";
    public ArrayList<Trabajador> leerTrabajadores() throws FileNotFoundException {
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        var builder = new CSVReaderBuilder(new FileReader(RUTA_GUARDADO));
        try (CSVReader reader = builder.withCSVParser(parser).withSkipLines(1).build()) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String nombre = nextLine[0];
                String apellido = nextLine[1];
                String rut = nextLine[2];
                String fecha2 = nextLine[3];
                String fecha3 = nextLine[4];
                trabajadores.add(new Trabajador(nombre, apellido, rut, fecha2, fecha3));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return trabajadores;
    }
}


