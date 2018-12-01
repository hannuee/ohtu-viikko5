
package ohtu.intjoukkosovellus;

import java.util.HashSet;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // Aloitus-HashSetin koko.
                            OLETUSKASVATUS = 5;  // Vakio jota ei käytetä mihinkään koska luokan sisäinen toteutus on muuttunut.
    private HashSet<Integer> joukko;
    
    public IntJoukko() {
        alustaja(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        tarkistaEttaLukuNollaTaiSuurempi(kapasiteetti, "Joukon kapasitteetti ei voi olla negatiivinen.");
        alustaja(kapasiteetti);
    }
     
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        tarkistaEttaLukuNollaTaiSuurempi(kapasiteetti, "Joukon kapasitteetti ei voi olla negatiivinen.");
        tarkistaEttaLukuNollaTaiSuurempi(kasvatuskoko, "Joukon kasvatuskoko ei voi olla negatiivinen.");
        alustaja(kapasiteetti);
    }
    
    private void alustaja(int kapasiteetti) {
        joukko = new HashSet<>(kapasiteetti);
    }
    
    private void tarkistaEttaLukuNollaTaiSuurempi(int luku, String virheviesti) {
        if (luku < 0) {
            throw new IndexOutOfBoundsException(virheviesti);
        }
    }
    
    public boolean lisaa(int luku) {
        return joukko.add(luku);
    }

    public boolean kuuluu(int luku) {
        return joukko.contains(luku);
    }

    public boolean poista(int luku) {
        return joukko.remove(luku);
    }

    public int mahtavuus() {
        return joukko.size();
    }

    @Override
    public String toString() {
        return joukko.toString().replace('[', '{').replace(']', '}');
    }

    public int[] toIntArray() {
        int[] intArray = new int[joukko.size()];
        Integer[] IntegerArray = joukko.toArray(new Integer[joukko.size()]);
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = IntegerArray[i];
        }
        return intArray;
    }
   
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        for (int luku : a.toIntArray()) {
            yhdisteJoukko.lisaa(luku);
        }
        for (int luku : b.toIntArray()) {
            yhdisteJoukko.lisaa(luku);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        for (int luku : a.toIntArray()) {
            if (b.kuuluu(luku)) {
                leikkausJoukko.lisaa(luku);
            }
        }
        return leikkausJoukko;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        for (int luku : a.toIntArray()) {
            if (!b.kuuluu(luku)) {
                erotusJoukko.lisaa(luku);
            }
        }
        return erotusJoukko;
    }
        
}