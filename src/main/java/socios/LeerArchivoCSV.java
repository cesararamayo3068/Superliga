package socios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerArchivoCSV {

    private String nombreArchivoCSV;
    public ArrayList<Socio> socios;

    public LeerArchivoCSV(String nombreArchivoCSV, ArrayList<Socio> socios) {
        this.nombreArchivoCSV = nombreArchivoCSV;
        if (socios == null) {
            this.socios = (ArrayList<Socio>) new ArrayList<Socio>().stream();
        } else {
            this.socios = socios;
        }

    }

    public void leerArchivoSociosCSV() {
        FileReader fr;
        try {

            fr = new FileReader(this.nombreArchivoCSV);
            String linea = "";
            BufferedReader br = new BufferedReader(fr);
            try {
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(";");
                    String nombre = datoslinea[0].trim();
                    int edad = Integer.valueOf(datoslinea[1].trim());
                    String equipo = datoslinea[2].trim();
                    String estadoCivil = datoslinea[3].trim();
                    String estudios = datoslinea[4].trim();

                    Socio socio = new Socio(nombre, edad, equipo, estadoCivil, estudios);

                    this.socios.add(socio);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }

    public void contarSocios() {
        System.out.println("Cantidad de Socios:" + socios.stream().count() );

    }

    public void promedioEdadRacing() {
        int racing = 0;
        int edades = 0;
        int promedio = 0;
        
        for (Socio s : socios) {

            if (s.getEquipo().equals("Racing")) {
                edades = edades + s.getEdad();
                racing++;
                promedio = edades / racing;
            }

        }
        System.out.println("Promedio de Edades de hinchas de Racing:" + promedio);

    }

    public void listarCienPersonas() {

        for (Socio s : socios) {

            if (s.getEstadoCivil().equals("Casado") && (s.getEstudios().equals("Universitario"))) {
                socios.stream().sorted();
            }
        }
        socios.stream().limit(100).forEach(x -> System.out.println(x));
    }

    public void mostrarSocios() {
        for (Socio s : this.socios) {
            System.out.println(s.toString());
        }
    }

    public String getNombreArchivoCSV() {
        return nombreArchivoCSV;
    }

    public void setNombreArchivoCSV(String nombreArchivoCSV) {
        this.nombreArchivoCSV = nombreArchivoCSV;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }

}