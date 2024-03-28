import java.util.UUID;

public class Dispositivo {
    private TipoDispositivo tipoDispositivo;
    private String id;
    private String produttore;
    private String modello;
    private String descrizione;
    private String spazioArchiviazione;
    private String pollici;
    private double prezzoAcquisto;
    private double prezzoVendita;

    public Dispositivo(String produttore, String modello, String descrizione, String pollici, String spazioArchiviazione, double prezzoAcquisto, double prezzoVendita, TipoDispositivo tipoDispositivo) {
        this.id = UUID.randomUUID().toString();
        this.produttore = produttore;
        this.modello = modello;
        this.descrizione = descrizione;
        this.spazioArchiviazione = spazioArchiviazione;
        this.pollici = pollici;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduttore() {
        return produttore;
    }

    public String getModello() {
        return modello;
    }

    public double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    // Questo Override fornisce una rappresentazione di stringa dettagliata dell'oggetto Dispositivo.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo Dispositivo: ").append(this.tipoDispositivo).append("\n");
        sb.append("Modello: ").append(this.modello).append("\n");
        sb.append("Produttore: ").append(this.produttore).append("\n");
        sb.append("Descrizione: ").append(this.descrizione).append("\n");
        sb.append("Spazio di archiviazione: ").append(this.spazioArchiviazione).append("\n");
        sb.append("Pollici: ").append(this.pollici).append("\n");
        sb.append("Prezzo acquisto: ").append(this.prezzoAcquisto).append("\n");
        sb.append("Prezzo vendita: ").append(this.prezzoVendita).append("\n");
        sb.append("ID: ").append(this.id).append("\n");
        return sb.toString();
    }

}

