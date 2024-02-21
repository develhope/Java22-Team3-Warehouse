import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Carrello{
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
    public Optional<Dispositivo> aggiungiAlCarrello(String id, List<Dispositivo>dispositivos) {
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
    //TODO spostare i messaggi nel main
    public boolean rimuoviDalCarrello(String id) {
        // Iterazione attraverso il carrello per trovare il dispositivo con l'ID specificato
        Iterator<Dispositivo> carrelloIterator = carrello.iterator();
        while(carrelloIterator.hasNext()){
            Dispositivo dispositivo = carrelloIterator.next();
            if(dispositivo.getId().equals(id)) {
                carrelloIterator.remove();// Rimozione del dispositivo dal carrello
                System.out.println("Il dispositivo con ID: " + id + " è stato rimosso dal carrello.");
                return true; // Restituisce true se il dispositivo è stato trovato e rimosso
            }
        }
        System.out.println("Nessun dispositivo trovato con l'ID " + id + " nel carrello.");
        return false; // Restituisce false se nessun dispositivo con l'ID specificato è stato trovato nel carrello
    }
}
