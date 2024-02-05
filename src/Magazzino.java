import java.util.*;
public class Magazzino {
    private static List<Notebook> notebooks = new ArrayList<>();
    private static List<Tablet> tablets  = new ArrayList<>();
    private static List<Smartphone> smartphones = new ArrayList<>();

    public void addNotebook(Notebook notebook) {
        this.notebooks.add(notebook);
    }

    public void addTablet(Tablet tablet) {
        this.tablets.add(tablet);
    }
    public void addSmartphone(Smartphone smartphone) {
        this.smartphones.add(smartphone);
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

    public String ricercaPrezzoVendita(double prezzo) {
        for (Notebook notebook : notebooks) {
            if (notebook.getPrezzoVendita() == prezzo) {
                System.out.println(notebook);
            } else {
                System.out.println("Non abbiamo un notebook a questo prezzo: " + prezzo + "\n");
            }
        }
        for (Tablet tablet : tablets) {
            if (tablet.getPrezzoVendita() == prezzo) {
                System.out.println(tablet);
            } else {
                System.out.println("Non abbiamo un tablet a questo prezzo: " + prezzo + "\n");
            }
        }
        for (Smartphone smartphone : smartphones) {
            if (smartphone.getPrezzoVendita() == prezzo) {
                System.out.println(smartphone);
            } else {
                System.out.println("Non abbiamo uno smartphone a questo prezzo: " + prezzo + "\n");
            }
        }
        return "";
    }

    public String ricercaPrezzoAcquisto(double prezzo) {
        for (Notebook notebook : notebooks) {
            if (notebook.getPrezzoAcquisto() == prezzo) {
                System.out.println(notebook);
            } else {
                System.out.println("Non abbiamo un notebook a questo prezzo: " + prezzo + "\n");
            }
        }
        for (Tablet tablet : tablets) {
            if (tablet.getPrezzoAcquisto() == prezzo) {
                System.out.println(tablet);
            } else {
                System.out.println("Non abbiamo un tablet a questo prezzo: " + prezzo + "\n");
            }
        }
        for (Smartphone smartphone : smartphones) {
            if (smartphone.getPrezzoAcquisto() == prezzo) {
                System.out.println(smartphone);
            } else {
                System.out.println("Non abbiamo uno smartphone a questo prezzo: " + prezzo + "\n");
            }
        }
        return "";
    }

    public String ricercaInRangeDiPrezzo(double min, double max) {
        for (Notebook notebook : notebooks) {
            if (notebook.getPrezzoVendita() >= min && notebook.getPrezzoVendita() <= max) {
                    System.out.println(notebook);
            } else {
                System.out.println("Non abbiamo un notebook in questo range di prezzo: " + min + "-" + max + "\n");
            }
        }
        for (Tablet tablet : tablets) {
            if (tablet.getPrezzoVendita() >= min && tablet.getPrezzoVendita() <= max) {
                    System.out.println(tablet);
            } else {
                System.out.println("Non abbiamo un tablet in questo range di prezzo: " + min + "-" + max + "\n");
            }
        }
        for (Smartphone smartphone : smartphones) {
            if (smartphone.getPrezzoVendita() >= min && smartphone.getPrezzoVendita() <= max) {
                    System.out.println(smartphone);
            } else {
                System.out.println("Non abbiamo uno smartphone in questo range di prezzo: " + min + "-" + max + "\n");
            }
        }
        return "";
    }
}