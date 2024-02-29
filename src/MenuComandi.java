public class MenuComandi {

    public void stampaMenuScelte() {
        System.out.println("Benvenuto nel menu principale: ");
        for (ComandiScelta comando : ComandiScelta.values()) {
            System.out.println(comando.ordinal() + ". " + comando.getStringa());
        }
    }

    public void stampaMenuAdmin() {
        System.out.println("Benvenuto nel menu amministratore:");
        for (ComandiAdmin comando : ComandiAdmin.values()) {
            System.out.println(comando.ordinal() + ". " + comando.getStringa());
        }
    }

    public void stampaMenuUser() {
        System.out.println("Benvenuto nel magazzino:");
        for (ComandiUser comando : ComandiUser.values()) {
            System.out.println(comando.ordinal() + ". " + comando.getStringa());
        }
    }
}