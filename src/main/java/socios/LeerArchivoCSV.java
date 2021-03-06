package socios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import java.util.function.Function;
import java.util.stream.Collectors;

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
        System.out.println("==============================================");
        System.out.println("Cantidad de Personas Registradas:" + socios.stream().count());
        System.out.println("==============================================");
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
        System.out.println("====================================================");
        System.out.println("Promedio de Edades de hinchas de Racing:" + promedio);
        System.out.println("====================================================");
    }

    public void listarCienPersonas() {

        for (Socio s : socios) {

            if (s.getEstadoCivil().equals("Casado") && (s.getEstudios().equals("Universitario"))) {

            }
        }

        socios.stream().limit(100).forEach(x -> System.out.println(x));
        Collections.sort(socios, new CompararEdad());
    }

    public void nombreMasComun() {

        ArrayList<String> listName = new ArrayList<>();

        for (Socio s : socios) {

            if (s.getEquipo().equals("River")) {

                listName.add(s.getNombre());

            }

        }
        
        System.out.println("====================================================");
        System.out.println("cantidad veces que se repite un nombre:\t");
        System.out.println("====================================================");
       
        
        socios.stream()
              
                .collect(Collectors.groupingBy(s -> s.getNombre(), Collectors.counting()))
                .forEach((id, count) -> System.out.println(id + "\t" + count));

       
    }

    public void contarSociosPorEquipos() {
        //con este stream agrupo los equipos con la cantidad de socios
        System.out.println("====================================================");
        System.out.println("Cantidad de Socios por equipo:\t");
        System.out.println("====================================================");
        socios.stream()
                .collect(Collectors.groupingBy(s -> s.getEquipo(), Collectors.counting()))
                .forEach((id, count) -> System.out.println(id + "\t" + count));

        socios.stream()
                .collect(Collectors.groupingBy(s -> s.getEquipo(),
                        Collectors.summingInt(s -> s.getEdad())))
                .forEach((equipo, sumEdades) -> System.out.println("\t" + sumEdades));
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
