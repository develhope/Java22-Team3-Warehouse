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
    //Un metodo che permetta di fare la ricerca per tipo di dispositivo.
    //
    //Dovrà resitutire la lista di dispositivi frutto della ricerca o un errore nel caso in cui la ricerca non produca risultati.
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
