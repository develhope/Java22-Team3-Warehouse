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

    public void ricercaPrezzoVendita(double prezzo) {
        boolean trovato = false;
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getPrezzoVendita() == prezzo) {
                System.out.println(dispositivo);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto con questo prezzo di Vendita: " + prezzo);
        }
    }

    public void ricercaPrezzoAcquisto(double prezzo) {
        boolean trovato = false;
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getPrezzoAcquisto() == prezzo) {
                System.out.println(dispositivo);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto con questo prezzo di Acquisto: " + prezzo);
        }
    }

    public void ricercaInRangeDiPrezzo(double min, double max) {
        boolean trovato = false;
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getPrezzoVendita() >= min && dispositivo.getPrezzoVendita() <= max) {
                System.out.println(dispositivo);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto in questo Range di Prezzo: " + min + "-" + max);
        }
    }
}