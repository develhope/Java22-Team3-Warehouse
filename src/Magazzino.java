import java.util.*;
public class Magazzino {

    private List<Dispositivo> dispositivi = new ArrayList<>();


    public void addDispositivo(Dispositivo dispositivo) {
        this.dispositivi.add(dispositivo);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Dispositivo dispositivo : dispositivi) {
            sb.append(dispositivo).append("\n");
            sb.append("----------\n");
        }
        return sb.toString().trim();
    }
   
    public List<Dispositivo> searchByTipoDispositivo(TipoDispositivo tipoDispositivo){
        List<Dispositivo> listaFiltrata = new ArrayList<>();
        for (Dispositivo dispositivo : dispositivi) {
           if(dispositivo.getTipoDispositivo() == tipoDispositivo){
               listaFiltrata.add(dispositivo);
           }
        }
        return listaFiltrata;
    }
}