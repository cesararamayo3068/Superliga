package socios;

import java.util.Comparator;

public class CompararEdad implements Comparator<Socio> {

    @Override

    public int compare(Socio s1, Socio s2) {
        int rta = 0;
        if (s1.getEdad() > s2.getEdad()) {
            rta = 1;
        } else if (s1.getEdad() < s2.getEdad()) {
            rta = 1;
        } else {
          return rta ;
        }
        return rta;
    }
}
