package socios;

public class Socio{

    private String nombre;
    private int edad;
    private String equipo;
    private String estadoCivil;
    private String estudios;

    public Socio(String nombre, int edad, String equipo, String estadoCivil, String estudios) {
        this.nombre = nombre;
        this.edad = edad;
        this.equipo = equipo;
        this.estadoCivil = estadoCivil;
        this.estudios = estudios;
    }

    Socio(String equipo, int edad, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    @Override
    public String toString() {
        return "Socios {" + "Nombre:" + nombre + ", Edad:" + edad + ", Equipo:" + equipo + '}'; //+ ", EstadoCivil=" + estadoCivil + ", Estudios:" + estudios + '}';
    }

  
}
