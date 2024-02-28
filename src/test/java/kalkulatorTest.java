import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class kalkulatorTest {

    @Test
    void penjumlahanNilaiPositive() {
        Kalkulator kalk = new Kalkulator(2,3);
        int hasil = kalk.penjumlahan();
        assertEquals(5, hasil);
    }

    @Test
    void penjumlahanNilaiNegative() {
        Kalkulator kalk = new Kalkulator(-2,-5);
        int hasil = kalk.penjumlahan();
        assertEquals(-7, hasil);
        assertNotNull(hasil,"Passed");
    }
}