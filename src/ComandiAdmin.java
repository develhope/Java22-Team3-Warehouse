public enum ComandiAdmin {
    ESCI("Esci"),
    AGGIUNGI("Aggiungi prodotto al magazzino."),
    RICERCA_PER_ACQUISTO("Ricerca per prezzo di acquisto"),
    CALCOLO_SPESA_MEDIA("Calcolo spesa media di acquisto.");

    private String stringa;

    ComandiAdmin(String stringa) {
        this.stringa = stringa;
    }

    public String getStringa() {
        return stringa;
    }
}
