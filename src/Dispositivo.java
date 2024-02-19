public class Dispositivo {

    public static final String NOTEBOOK = "notebook";
    public static final String TABLET = "tablet";
    public static final String SMARTPHONE = "smartphone";

    private int id;
    private String produttore;
    private String tipoDispositivo;
    private String modello;
    private String descrizione;
    private String spazioArchiviazione;
    private String pollici;
    private double prezzoAcquisto;
    private double prezzoVendita;

    public Dispositivo(int id, String produttore, String modello, String descrizione, String pollici, String spazioArchiviazione, double prezzoAcquisto, double prezzoVendita, String tipoDispositivo) {
        this.id = id;
        this.produttore = produttore;
        this.modello = modello;
        this.descrizione = descrizione;
        this.spazioArchiviazione = spazioArchiviazione;
        this.pollici = pollici;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.tipoDispositivo = tipoDispositivo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getPollici() {
        return pollici;
    }

    public void setPollici(String pollici) {
        this.pollici = pollici;
    }

    public String getSpazioArchiviazione() {
        return spazioArchiviazione;
    }

    public void setSpazioArchiviazione(String spazioArchiviazione) {
        this.spazioArchiviazione = spazioArchiviazione;
    }

    public double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto(double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

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

