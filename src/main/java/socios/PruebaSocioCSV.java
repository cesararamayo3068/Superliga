package socios;

import java.util.ArrayList;

public class PruebaSocioCSV {

    public static void main(String[] args) {
        String nonbreArchivoCSV = "C:\\Cursos\\Java\\superliga\\src\\main\\java\\socios\\socios.csv";
        ArrayList<Socio> socios = new ArrayList<Socio>();
        LeerArchivoCSV a = new LeerArchivoCSV(nonbreArchivoCSV,socios);
        a.leerArchivoSociosCSV();
       // a.mostrarSocios();
        a.contarSocios();
        a.promedioEdadRacing();
        a.listarCienPersonas();
        a.nombreMasComun();
        a.contarSociosPorEquipos();
    }

}
