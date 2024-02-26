public class MenuComandi {
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
    public enum ComandiUser {
        ESCI("Esci"),
        STAMPA("Stampa contenuti magazzino"),
        RICERCA_PER_TIPO("Ricerca per tipologia."),
        RICERCA_PER_PRODUTTORE("Ricerca per produttore."),
        RICERCA_PER_MODELLO("Ricerca per modello."),
        RICERCA_PER_RANGE("Ricerca per range di prezzo."),
        RICERCA_PER_VENDITA("Ricerca per prezzo di vendita"),
        AGGIUNGI_AL_CARRELLO("Aggiungi al carrello."),
        RIMUOVI_DAL_CARRELLO("Rimuovi dal carrello"),
        CALCOLO_SPESA_TOTALE("Calcolo spesa totale carrello."),
        FINALIZZA_SPESA("Finalizza spesa.");

        private String stringa;

        ComandiUser(String stringa) {
            this.stringa = stringa;
        }

        public String getStringa() {
            return stringa;
        }
    }

    public static void stampaMenuAdmin() {
        System.out.println("Benvenuto nel menu amministratore:");
        for (ComandiAdmin comando : ComandiAdmin.values()) {
            System.out.println(comando.ordinal() + ". " + comando.getStringa());
        }
    }

    public static void stampaMenuUser() {
        System.out.println("Benvenuto nel magazzino:");
        for (ComandiUser comando : ComandiUser.values()) {
            System.out.println(comando.ordinal() + ". " + comando.getStringa());
        }
    }
}
