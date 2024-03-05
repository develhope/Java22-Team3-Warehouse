import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Carrello.
 */
public class Carrello {
    private List<Dispositivo> carrello;

    /**
     * Instantiates a new Carrello.
     */
    public Carrello() {
        this.carrello = new ArrayList<>();
    }

    public List<Dispositivo> getCarrello() {
        return carrello;
    }

    /**
     * Aggiungi al carrello tramite ID.
     *
     * @param id           the id
     * @param dispositivos the dispositivos
     * @return the optional
     */
    public Optional<Dispositivo> aggiungiAlCarrello(String id, List<Dispositivo> dispositivos) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.getId().equals(id)) {
                this.carrello.add(dispositivo);
                return Optional.of(dispositivo);
            }
        }
        return Optional.empty();
    }

    /**
     * Rimuovi dal carrello tramite ID.
     *
     * @param id          the id
     * @param dispositivi the dispositivi
     * @return the optional
     */
    public Optional<Dispositivo> rimuoviDalCarrello(String id, List<Dispositivo> dispositivi) {
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getId().equals(id)) {
                this.carrello.remove(dispositivo);
                return Optional.of(dispositivo);
            }
        }
        return Optional.empty();
    }

    /**
     * Calcola totale carrello double.
     *
     * @return the double
     */
    public double calcolaTotaleCarrello() {
        double totale = 0;
        for (Dispositivo dispositivo : this.carrello) {
            totale += dispositivo.getPrezzoVendita();
        }
        return totale;
    }

    /**
     * Chiudi transazione double.
     *
     * @param somma the somma
     * @return the double
     */
    public double chiudiTransazione(double somma) {
        double totale = calcolaTotaleCarrello();
        if (somma >= totale) {
            this.carrello.clear();
            return totale;
        } else {
            return -1;
        }
    }
}
