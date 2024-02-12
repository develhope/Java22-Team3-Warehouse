public enum TipoDispositivo {
    NOTEBOOK("Notebook"),
    SMARTPHONE("Smartphone"),
    TABLET("Tablet");

    private String descrizione;


    TipoDispositivo(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
