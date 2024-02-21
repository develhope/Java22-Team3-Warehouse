import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Magazzino magazzino = new Magazzino();

        while (true) {
            int scelta = schermoMenu();

            if (scelta == 0) {
                break;
            }
            if (scelta == 1) {
                Dispositivo dispositivo = aggiungiMerce();
                magazzino.addDispositivo(dispositivo);
            }
            if (scelta == 2) {
                System.out.println(magazzino);
            }

            if (scelta == 3) {
                cercaTipologia(magazzino);
            }

            if (scelta == 4) {
                cercaProduttorte(magazzino);
            }

            if (scelta == 5) {
                cercaModello(magazzino);
            }

            if (scelta == 6) {
                double prezzo = leggiRangeIntero(0, 10000, "Inserisci il prezzo di Vendita: ");
                magazzino.ricercaPrezzoVendita(prezzo);
            }

            if (scelta == 7) {
                double prezzo = leggiRangeIntero(0, 10000, "Inserisci il prezzo di Acquisto: ");
                magazzino.ricercaPrezzoAcquisto(prezzo);
            }

            if (scelta == 8) {
                double min = leggiRangeIntero(0, 10000, "Inserisci il prezzo minimo: ");
                double max = leggiRangeIntero((int) min, 10000, "Inserisci il prezzo massimo: ");
                magazzino.ricercaInRangeDiPrezzo(min, max);
            }

            if (scelta == 9) {
                try {
                    System.out.println(magazzino.calcolaSpesaMediaAcquisto());
                    System.out.println("Premere invio per tornare al menù");
                    System.in.read(); //serve per dare tempo all'utente di leggere la media

                } catch (Exception e) {
                    throw new RuntimeException(e); //eccezione se il deposito è vuoto
                }
            }

            if (scelta == 10) {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("Inserisci l'ID del prodotto da aggiungere al carrello:");
                    String id;
                    while (!scanner.hasNextLine()) {
                        System.out.println("Inserimento non valido. Per favore, inserisci un ID valido.");
                        scanner.next();
                    }
                    id = scanner.nextLine();
                    Optional<Dispositivo> dispositivo = magazzino.aggiungiAlCarrello(String.valueOf(id));
                    if (dispositivo.isPresent()) {
                        System.out.println("Il prodotto con ID: " + id + " è stato aggiunto al carrello.");
                    } else {
                        System.out.println("Nessun prodotto trovato con l'ID " + id + ". Riprova.");
                    }

                    System.out.println("Vuoi aggiungere un altro prodotto? (si/no)");
                    String risposta = scanner.next();
                    if (risposta.equalsIgnoreCase("no")) {
                        break;
                    }
                }
            }

            if (scelta == 11) {
                String id = leggiStringaNonVuota("Inserire l'ID del dispositivo che si vuole rimuovere");
                magazzino.rimuoviDalCarrello(id);
                System.out.println("Premere invio per tornare al menù");
                System.in.read(); //serve per dare tempo all'utente di leggere la media
            }

            if (scelta == 12) {
                System.out.println("Prodotti nel carrello:");
                for (Dispositivo dispositivo : magazzino.getCarrello()) {
                    System.out.println("Prodotto: " + dispositivo.getModello() + ", Prezzo: " + dispositivo.getPrezzoVendita() + "€");
                }
                double totale = magazzino.calcolaTotaleCarrello();
                System.out.println("Totale del carrello: " + totale + "€");

            }

            if (scelta == 13) {
                if (magazzino.calcolaTotaleCarrello() == 0) {
                    System.out.println("il carrello è vuoto");
                    break;
                } else {
                    Scanner scanner = new Scanner(System.in);
                    double totale = magazzino.calcolaTotaleCarrello();
                    double somma = 0;
                    while (true) {
                        System.out.println("Il totale è: " + totale + "€, inserire l'importo corretto");
                        somma = scanner.nextDouble();
                        double totaleTransazione = magazzino.chiudiTransazione(somma);
                        if (totaleTransazione != -1) {
                            if (somma > totale) {
                                System.out.println("Grazie, l'importo inserito è: " + somma + "€ il resto è: " + (somma - totale) + "€");
                            }
                            System.out.println("Transazione completata con successo!");
                            break;
                        } else {
                            System.out.println("La somma inserita è non è corretta. Riprovare.");
                        }
                    }
                }
            }
        }
    }


    private static int schermoMenu() {
        System.out.println("\n-----Benvenuto nel magazzino.-----\n");
        System.out.println(" 0. Esci.");
        System.out.println("");
        System.out.println(" 1. Aggiungi prodotto al magazzino.");
        System.out.println(" 2. Stampa contenuti magazzino.");
        System.out.println(" 3. Ricerca per tipo.");
        System.out.println(" 4. Ricerca per produttore.");
        System.out.println(" 5. Ricerca per modello.");
        System.out.println(" 6. Ricerca per prezzo di vendita.");
        System.out.println(" 7. Ricerca per prezzo di acquisto.");
        System.out.println(" 8. Ricerca per range di prezzo.");
        System.out.println(" 9. Calcolo spesa media.");
        System.out.println("10. Aggiungi al carrello.");
        System.out.println("11. Rimuovi dal carrello.");
        System.out.println("12. Calcola spesa totale carrello.");
        System.out.println("13. Finalizza spesa.");
        return leggiRangeIntero(0, 13, "Scelta--> ");
    }

    public static int leggiRangeIntero(int min, int max, String messaggio) {
        Scanner scanner = new Scanner(System.in);
        int valore = 0;
        while (true) {
            System.out.println(messaggio);
            if (scanner.hasNextInt()) {
                valore = scanner.nextInt();
                if (valore >= min && valore <= max) {
                    break;
                } else {
                    System.out.println("Errore, inserire un valore compreso tra " + min + " e " + max);
                }
            } else {
                System.out.println("Inserire un numero intero valido");
                scanner.next();
            }
        }
        return valore;
    }

    public static String leggiStringaNonVuota(String messaggio) {
        System.out.println(messaggio);
        Scanner scanner = new Scanner(System.in);
        String stringa = scanner.nextLine();
        while (stringa.isEmpty()) {
            System.out.println("Inserire una stringa piena");
            System.out.println(messaggio);
            stringa = scanner.nextLine();
        }
        return stringa;
    }

    private static double leggiDouble(double min, double max, String messaggio) {
        Scanner scanner = new Scanner(System.in);
        double valore = 0;
        while (true) {
            System.out.println(messaggio);
            if (scanner.hasNextDouble()) {
                valore = scanner.nextDouble();
                if (valore >= min && valore <= max) {
                    break;
                } else {
                    System.out.println("Errore, inserire un valore compreso tra " + min + " e " + max);
                }
            } else {
                System.out.println("Inserire un numero con virgola.");
                scanner.next();
            }
        }
        return valore;
    }

    private static void cercaTipologia(Magazzino magazzino) {
        String tipologia = leggiStringaNonVuota("Inserisci tipologia");
        List<Dispositivo> dispositivi = magazzino.searchByTipoDispositivo(tipologia);
        if (dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo di questo tipo");
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }

    private static void cercaModello(Magazzino magazzino) {
        String modello = leggiStringaNonVuota("Inserisci modello: ");
        List<Dispositivo> dispositivi = magazzino.searchByModello(modello);
        if (dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo con questo nome");
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }

    private static void cercaProduttorte(Magazzino magazzino) {
        String produttore = leggiStringaNonVuota("Inserisci produttore: ");
        List<Dispositivo> dispositivi = magazzino.searchByProduttore(produttore);
        if (dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo appartentente a questo produttore");
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }
    private static Dispositivo aggiungiMerce() {
        System.out.println("L'ID verrà aggiunto automaticamente");
        String produttore = leggiStringaNonVuota("Produttore: ");
        String modello = leggiStringaNonVuota("Modello: ");
        String descrizione = leggiStringaNonVuota("Descrizione:");
        String pollici = leggiStringaNonVuota("Pollici:");
        String spazioDiArchiviazione = leggiStringaNonVuota("Spazio di archiviazione:");
        double prezzoAcquisto = leggiDouble(0.99, 999999.99, "Prezzo d'acquisto: ");
        double prezzoVendita = leggiDouble(0.99, 999999.99, "Prezzo di vendita: ");
        int scelta = leggiRangeIntero(1, 3, "Tipologia:\n1. Tablet\n2. Smartphone\n3. Notebook\nScelta --> ");
        String tipoDispositivo = Dispositivo.NOTEBOOK;
        if (scelta == 1) {
            tipoDispositivo = Dispositivo.TABLET;
        }
        if (scelta == 2) {
            tipoDispositivo = Dispositivo.SMARTPHONE;
        }
        System.out.println("Dispositivo aggiunto correttamente.");

        return new Dispositivo(produttore, modello, descrizione, pollici, spazioDiArchiviazione, prezzoAcquisto, prezzoVendita, tipoDispositivo);
    }
}

