import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrello {
    private List<Dispositivo> carrello;

    public Carrello() {
        this.carrello = new ArrayList<>();
    }


    public List<Dispositivo> getCarrello() {
        return carrello;
    }


    public void setCarrello(List<Dispositivo> carrello) {
        this.carrello = carrello;
    }

    public Optional<Dispositivo> aggiungiAlCarrello(String id, List<Dispositivo> dispositivos) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.getId().equals(id)) {
                this.carrello.add(dispositivo);
                return Optional.of(dispositivo);
            }
        }
        return Optional.empty();
    }

    public double calcolaTotaleCarrello() {
        double totale = 0;
        for (Dispositivo dispositivo : this.carrello) {
            totale += dispositivo.getPrezzoVendita();
        }
        return totale;
    }

    public double chiudiTransazione(double somma) {
        double totale = calcolaTotaleCarrello();
        if (somma >= totale) {
            this.carrello.clear();
            return totale;
        } else {
            return -1;
        }
    }

    public Optional<Dispositivo> rimuoviDalCarrello(String id, List<Dispositivo> dispositivi) {
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getId().equals(id)) {
                this.carrello.remove(dispositivo);
                return Optional.of(dispositivo);
            }
        }
        return Optional.empty();
    }
}
