import java.util.*;
public class Magazzino {
    private List<Notebook> notebooks = new ArrayList<>();
    private List<Tablet> tablets  = new ArrayList<>();
    private List<Smartphone> smartphones = new ArrayList<>();

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
}
