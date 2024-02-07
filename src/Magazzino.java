import java.util.*;
public class Magazzino {
    private static final List<Notebook> notebooks = new ArrayList<>();
    private static final List<Tablet> tablets  = new ArrayList<>();
    private static final List<Smartphone> smartphones = new ArrayList<>();

    public void addNotebook(Notebook notebook) {
        notebooks.add(notebook);
    }

    public void addTablet(Tablet tablet) {
        tablets.add(tablet);
    }
    public void addSmartphone(Smartphone smartphone) {
        smartphones.add(smartphone);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Notebook notebook : notebooks) {
            sb.append(notebook).append("\n");
            sb.append("----------\n");
        }
        for (Tablet tablet: tablets) {
            sb.append(tablet).append("\n");
            sb.append("----------\n");
        }
        for (Smartphone smartphone : smartphones) {
            sb.append(smartphone).append("\n");
            sb.append("----------");
        }

        return sb.toString().trim();
    }

    public void ricercaPrezzoVendita(double prezzo) {
        boolean trovato = false;
        for (Notebook notebook : notebooks) {
            if (notebook.getPrezzoVendita() == prezzo) {
                System.out.println(notebook);
                trovato = true;
            }
        }
        for (Tablet tablet : tablets) {
            if (tablet.getPrezzoVendita() == prezzo) {
                System.out.println(tablet);
                trovato = true;
            }
        }
        for (Smartphone smartphone : smartphones) {
            if (smartphone.getPrezzoVendita() == prezzo) {
                System.out.println(smartphone);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto con questo prezzo di Vendita: " + prezzo);
        }
    }

    public void ricercaPrezzoAcquisto(double prezzo) {
        boolean trovato = false;
        for (Notebook notebook : notebooks) {
            if (notebook.getPrezzoAcquisto() == prezzo) {
                System.out.println(notebook);
                trovato = true;
            }
        }
        for (Tablet tablet : tablets) {
            if (tablet.getPrezzoAcquisto() == prezzo) {
                System.out.println(tablet);
                trovato = true;
            }
        }
        for (Smartphone smartphone : smartphones) {
            if (smartphone.getPrezzoAcquisto() == prezzo) {
                System.out.println(smartphone);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto con questo prezzo di Acquisto: " + prezzo);
        }
    }

    public void ricercaInRangeDiPrezzo(double min, double max) {
        boolean trovato = false;
        for (Notebook notebook : notebooks) {
            if (notebook.getPrezzoVendita() >= min && notebook.getPrezzoVendita() <= max) {
                System.out.println(notebook);
                trovato = true;
            }
        }
        for (Tablet tablet : tablets) {
            if (tablet.getPrezzoVendita() >= min && tablet.getPrezzoVendita() <= max) {
                System.out.println(tablet);
                trovato = true;
            }
        }
        for (Smartphone smartphone : smartphones) {
            if (smartphone.getPrezzoVendita() >= min && smartphone.getPrezzoVendita() <= max) {
                System.out.println(smartphone);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto in questo Range di Prezzo: " + min + "-" + max);
        }
    }
}