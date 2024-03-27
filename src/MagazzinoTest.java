import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class MagazzinoTest {

    // Verifica che searchByTipoDispositivo() funzioni con un dispositivo esistente. Crea un magazzino e un dispositivo di tipo SMARTPHONE.
    // Aggiungi il dispositivo al magazzino. Cerca dispositivi di tipo SMARTPHONE nel magazzino. Assicura che il primo dispositivo nella lista trovata sia uguale a quello creato.
    @Test
    public void testSearchByTipoDispositivo_DispositivoEsistenteSmartphone() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "grigio", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> result = magazzino.searchByTipoDispositivo(Dispositivo.SMARTPHONE);

        assertEquals(Dispositivo.SMARTPHONE, result.getFirst().getTipoDispositivo());
    }

    // Verifica che searchByTipoDispositivo() funzioni con un dispositivo esistente. Crea un magazzino e un dispositivo di tipo NOTEBOOK.
    // Aggiungi il dispositivo al magazzino. Cerca dispositivi di tipo NOTEBOOK nel magazzino. Assicura che il primo dispositivo nella lista trovata sia uguale a quello creato.
    @Test
    public void testSearchByTipoDispositivo_DispositivoEsistenteNotebook() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "grigio", "4,9'", "32 GB", 750, 999, Dispositivo.NOTEBOOK);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> result = magazzino.searchByTipoDispositivo(Dispositivo.NOTEBOOK);

        assertEquals(Dispositivo.NOTEBOOK, result.getFirst().getTipoDispositivo());
    }

    // Verifica che searchByTipoDispositivo() funzioni con un dispositivo esistente. Crea un magazzino e un dispositivo di tipo TABLET.
    // Aggiungi il dispositivo al magazzino. Cerca dispositivi di tipo TABLET nel magazzino. Assicura che il primo dispositivo nella lista trovata sia uguale a quello creato.
    @Test
    public void testSearchByTipoDispositivo_DispositivoEsistenteTablet() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "grigio", "4,9'", "32 GB", 750, 999, Dispositivo.TABLET);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> result = magazzino.searchByTipoDispositivo(Dispositivo.TABLET);

        assertEquals(Dispositivo.TABLET, result.getFirst().getTipoDispositivo());
    }

    // Verifica che searchByTipoDispositivo() gestisca un tipo di dispositivo non esistente. Crea un magazzino vuoto.
    // Cerca dispositivi con un tipo non esistente. Assicura che la lista di dispositivi trovati sia vuota.
    @Test
    public void testSearchByTipoDispositivo_DispositivoNonEsistente() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivi = magazzino.searchByTipoDispositivo("tipoDispositivoNonEsistente");

        assertEquals(0, dispositivi.size());
    }

    // Verifica che searchByTipoDispositivo() gestisca un tipo di dispositivo vuoto. Crea un magazzino vuoto.
    // Cerca dispositivi con un tipo vuoto. Assicura che la lista di dispositivi trovati sia vuota.
    @Test
    public void testSearchByTipoDispositivo_TipoVuoto() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.searchByTipoDispositivo("");

        assertEquals(0, dispositivos.size());
    }

    // Verifica che searchByTipoDispositivo() gestisca un tipo di dispositivo nullo. Crea un magazzino vuoto.
    // Cerca dispositivi con un tipo nullo. Assicura che la lista di dispositivi trovati sia vuota.
    @Test
    public void testSearchByTipoDispositivo_TipoNull() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.searchByTipoDispositivo(null);

        assertEquals(0, dispositivos.size());
    }


    // Verifica che searchByProduttore() funzioni con un produttore esistente. Crea un magazzino e un dispositivo con un produttore specifico ("HP").
    // Aggiungi il dispositivo al magazzino. Cerca dispositivi con lo stesso produttore ("HP"). Assicura che il primo dispositivo nella lista trovata abbia lo stesso produttore specificato.
    @Test
    public void testSearchByProduttore_ProduttoreEsistente() {
        Magazzino magazzinoTest = new Magazzino();
        Dispositivo dispositivoTest = new Dispositivo("HP", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzinoTest.addDispositivo(dispositivoTest);
        List<Dispositivo> dispositivi = magazzinoTest.searchByProduttore("HP");

        assertEquals("HP", dispositivi.getFirst().getProduttore());
    }

    // Verifica che searchByProduttore() gestisca un produttore non esistente. Crea un magazzino vuoto.
    // Cerca dispositivi con un produttore non esistente. Assicura che la lista di dispositivi trovati sia vuota.
    @Test
    public void testSearchByProduttore_ProduttoreNonEsistente() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivi = magazzino.searchByProduttore("produttoreNonEsistente");

        assertEquals(0, dispositivi.size());
    }

    // Verifica che searchByProduttore() gestisca un nome di produttore vuoto. Crea un magazzino vuoto.
    // Cerca dispositivi con un nome di produttore vuoto. Assicura che la lista di dispositivi trovati sia vuota.
    @Test
    public void testSearchByProduttore_NomeVuoto() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.searchByProduttore("");

        assertEquals(0, dispositivos.size());
    }

    // Verifica che searchByProduttore() gestisca un nome di produttore nullo. Crea un magazzino vuoto.
    // Cerca dispositivi con un nome di produttore nullo. Assicura che la lista di dispositivi trovati sia vuota.
    @Test
    public void testSearchByProduttore_NomeNull() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.searchByProduttore(null);

        assertEquals(0, dispositivos.size());
    }

    // Verifica che searchByModello() trovi un dispositivo con modello "s22". Crea un magazzino con un dispositivo "s22".
    // Cerca "s22". Assicura che la lista abbia un solo dispositivo "s22".
    @Test
    public void testSearchByModello_ModelloEsistente() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.searchByModello("s22");

        assertEquals(1, dispositivi.size());
        assertEquals("s22", dispositivi.getFirst().getModello());
    }

    // Verifica che searchByModello() non trovi un modello inesistente. Cerca "modelloNonEsistente" in un magazzino vuoto. Assicura che la lista sia vuota.
    @Test
    public void testSearchByModello_ModelloNonEsistente() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivi = magazzino.searchByModello("modelloNonEsistente");

        assertEquals(0, dispositivi.size());
    }

    // Verifica che searchByModello() gestisca un nome di modello vuoto. Cerca "" in un magazzino vuoto. Assicura che la lista sia vuota.
    @Test
    public void testSearchByModello_NomeVuoto() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.searchByModello("");

        assertEquals(0, dispositivos.size());
    }

    // Verifica che searchByModello() gestisca un nome di modello nullo. Cerca null in un magazzino vuoto. Assicura che la lista sia vuota.
    @Test
    public void testSearchByModello_NomeNull() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.searchByModello(null);

        assertEquals(0, dispositivos.size());
    }

    // Verifica che ricercaPrezzoVendita() trovi un dispositivo con prezzo di vendita 999. Crea un magazzino con un dispositivo con prezzo di vendita 999.
    // Cerca dispositivi con prezzo di vendita 999. Assicura che la lista abbia un solo dispositivo con prezzo di vendita 999.
    @Test
    public void testRicercaPrezzoVendita_PrezzoValido() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.ricercaPrezzoVendita(999);

        assertEquals(1, dispositivi.size());
        assertEquals(999, dispositivi.getFirst().getPrezzoVendita(), 0.01);
    }

    // Verifica che ricercaPrezzoVendita() non trovi un prezzo di vendita inesistente. Cerca 43628746 in un magazzino vuoto. Assicura che la lista sia vuota.
    @Test
    public void testRicercaPrezzoVendita_PrezzoNonEsistente() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivi = magazzino.ricercaPrezzoVendita(43628746);

        assertEquals(0, dispositivi.size());
    }

    // Verifica che ricercaPrezzoVendita() gestisca un prezzo di vendita negativo. Cerca -100.0 in un magazzino vuoto. Assicura che la lista sia vuota.
    @Test
    public void testRicercaPrezzoVendita_PrezzoNegativo() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.ricercaPrezzoVendita(-100.0);

        assertEquals(0, dispositivos.size());
    }

    // Verifica che ricercaPrezzoVendita() gestisca un prezzo di vendita uguale a zero. Cerca 0.0 in un magazzino vuoto. Assicura che la lista sia vuota.
    @Test
    public void testRicercaPrezzoVendita_PrezzoZero() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos =  magazzino.ricercaPrezzoVendita(0.0);

        assertEquals(0, dispositivos.size());
    }

    // Verifica che ricercaPrezzoAcquisto() trovi un dispositivo con prezzo di acquisto 750. Crea un magazzino con un dispositivo con prezzo di acquisto 750.
    // Cerca dispositivi con prezzo di acquisto 750. Assicura che la lista abbia un solo dispositivo con prezzo di acquisto 750.
    @Test
    public void testRicercaPrezzoAcquisto_PrezzoValido() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.ricercaPrezzoAcquisto(750);

        assertEquals(1, dispositivi.size());
        assertEquals(750, dispositivi.getFirst().getPrezzoAcquisto(), 0.01);
    }

    // Verifica che ricercaPrezzoAcquisto() non trovi un prezzo di acquisto inesistente. Cerca 43628746 in un magazzino vuoto. Assicura che la lista sia vuota.
    @Test
    public void testRicercaPrezzoAcquisto_PrezzoNonEsistente() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivi = magazzino.ricercaPrezzoAcquisto(43628746);

        assertEquals(0, dispositivi.size());
    }

    // Verifica che ricercaPrezzoAcquisto() gestisca un prezzo di acquisto negativo. Cerca -100.0 in un magazzino vuoto. Assicura che la lista sia vuota.
    @Test
    public void testRicercaPrezzoAcquisto_PrezzoNegativo() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.ricercaPrezzoAcquisto(-100.0);

        assertEquals(0, dispositivos.size());
    }

    // Verifica che ricercaPrezzoAcquisto() gestisca un prezzo di acquisto uguale a zero. Cerca 0.0 in un magazzino vuoto. Assicura che la lista sia vuota.
    @Test
    public void testRicercaPrezzoAcquisto_PrezzoZero() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.ricercaPrezzoAcquisto(0.0);

        assertEquals(0, dispositivos.size());
    }

    // Verifica che ricercaInRangeDiPrezzo() trovi un dispositivo con prezzo di vendita uguale a 999. Crea un magazzino con un dispositivo con prezzo di vendita 999.
    // Cerca dispositivi con prezzo di vendita compreso tra 999 e 999 (intervallo di un solo valore). Assicura che la lista abbia un solo dispositivo con prezzo di vendita 999.
    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMinimoEMassimoUguali() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.ricercaInRangeDiPrezzo(999, 999);

        assertEquals(1, dispositivi.size());
        assertEquals(999, dispositivi.getFirst().getPrezzoVendita(), 0.01);
    }

    // Verifica che ricercaInRangeDiPrezzo() non trovi dispositivi con prezzi di vendita fuori dall'intervallo. Crea un magazzino con un dispositivo con prezzo di vendita 999.
    // Cerca dispositivi con prezzo di vendita compreso tra 1000 e 2000. Assicura che la lista sia vuota.
    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMinimoEMassimoNonPresenti() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.ricercaInRangeDiPrezzo(9999,10000);

        assertEquals(0, dispositivi.size());
    }

    // Verifica che ricercaInRangeDiPrezzo() trovi due dispositivi con prezzi di vendita tra 999 e 1199. Crea un magazzino con due dispositivi con prezzi di vendita 999 e 1199.
    // Cerca dispositivi con prezzo di vendita compreso tra 999 e 1199. Assicura che la lista abbia due dispositivi con prezzi di vendita 999 e 1199.
    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMinimoEMassimoConPiuDispositivi() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo1 = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        Dispositivo dispositivo2 = new Dispositivo("Apple", "iPhone 13", "telefono bellino", "6,1'", "128 GB", 850, 1199, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo1);
        magazzino.addDispositivo(dispositivo2);
        List<Dispositivo> dispositivi = magazzino.ricercaInRangeDiPrezzo(999, 1199);

        assertEquals(2, dispositivi.size());
        assertEquals(999, dispositivi.get(0).getPrezzoVendita(), 0.01);
        assertEquals(1199, dispositivi.get(1).getPrezzoVendita(), 0.01);
    }

    // Verifica che ricercaInRangeDiPrezzo() gestisca un prezzo minimo negativo.
    // Cerca dispositivi con prezzo di vendita compreso tra -100.0 e 100.0 in un magazzino vuoto. Assicura che la lista sia vuota.
    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMinimoNegativo() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.ricercaInRangeDiPrezzo(-100.0, 100.0);

        assertEquals(0, dispositivos.size());
    }

    // Verifica che ricercaInRangeDiPrezzo() gestisca un prezzo massimo negativo.
    // Cerca dispositivi con prezzo di vendita compreso tra 100.0 e -100.0 in un magazzino vuoto. Assicura che la lista sia vuota.
    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMassimoNegativo() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos =magazzino.ricercaInRangeDiPrezzo(100.0, -100.0);

        assertEquals(0, dispositivos.size());
    }

    // Verifica che ricercaInRangeDiPrezzo() gestisca un prezzo minimo maggiore del prezzo massimo.
    // Cerca dispositivi con prezzo di vendita compreso tra 100.0 e 50.0 in un magazzino vuoto. Assicura che la lista sia vuota.
    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMinimoMaggioreDiPrezzoMassimo() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.ricercaInRangeDiPrezzo(100.0, 50.0);

        assertEquals(0, dispositivos.size());
    }

    // Verifica che calcolaSpesaMediaAcquisto() calcoli correttamente la spesa media con due dispositivi. Crea un magazzino con due dispositivi con prezzi di acquisto 750 e 850.
    // Calcola la spesa media di acquisto. Assicura che la spesa media sia 800.
    @Test
    public void testCalcolaSpesaMediaAcquisto_TestPiuDispositivi() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo1 = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        Dispositivo dispositivo2 = new Dispositivo("Apple", "iPhone 13", "telefono bellino", "6,1'", "128 GB", 850, 1199, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo1);
        magazzino.addDispositivo(dispositivo2);
        double spesaMedia = magazzino.calcolaSpesaMediaAcquisto();
        double result = 0;
        for (Dispositivo dispositivo : magazzino.getDispositivi()) {
            result += dispositivo.getPrezzoAcquisto();
        }
        result /= magazzino.getDispositivi().size();

        assertEquals(result, spesaMedia, 0.01);
    }
}