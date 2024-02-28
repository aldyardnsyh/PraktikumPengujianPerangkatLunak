import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {

    @Test
    void testSetOwnerAndGetOwner() {
        // Set data owner
        Owner owner = new Owner("Aldya", 18);
        Wallet wallet = new Wallet();
        wallet.setOwner(owner);
        // Verifikasi data owner berhasil diset dan didapatkan kembali
        assertEquals(owner, wallet.getOwner(), "Test pass: Owner successfully set and retrieved");
    }

    @Test
    void testAddCard() {
        // Menambahkan kartu
        Wallet wallet = new Wallet();
        Card card = new Card("1234", "Aldya", "Bank Jago", 1000);

        wallet.addCard(card);
        assertTrue(wallet.getCards().contains(card), "Test pass: Card successfully added");
        assertEquals(card, wallet.getCards().get(0), "Test pass: Correct card added to the wallet");
    }

    @Test
    void testAddCash() {
        // Menambahkan uang rupiah
        Wallet wallet = new Wallet();
        Cash cash = new Cash(10000, 2, "IDR");

        // Adding cash to wallet
        wallet.addCash(cash);

        // Verifying cash added successfully
        assertTrue(wallet.getCashList().contains(cash), "Test pass: Cash successfully added");

        // Verifying total cash after addition
        assertEquals(20000, wallet.getTotalCash(), "Test pass: Correct total cash after addition");
    }

    @Test
    void testWithdrawCash() {
        // Menarik uang rupiah
        Wallet wallet = new Wallet();
        Cash cash = new Cash(10000, 2, "IDR");

        wallet.addCash(cash);
        assertTrue(wallet.getCashList().contains(cash), "Precondition: Cash successfully added");

        wallet.withdrawCash(cash);
        assertFalse(wallet.getCashList().contains(cash), "Test pass: Cash successfully withdrawn");
    }

    @Test
    void testGetTotalCash() {
        // Persiapkan dompet dengan sejumlah uang
        Wallet wallet = new Wallet();
        wallet.addCash(new Cash(10000, 2, "IDR"));
        wallet.addCash(new Cash(50000, 3, "IDR"));
        wallet.addCash(new Cash(200000, 1, "IDR"));

        // Verifikasi jumlah uang yang ada di dompet sesuai dengan yang diharapkan
        assertEquals(370000, wallet.getTotalCash(), "Test pass: Correct total cash calculated");
    }

    @Test
    void testRemoveCard() {
        // Menghapus kartu
        Wallet wallet = new Wallet();
        Card card = new Card("1234", "Aldya", "Bank Jago", 1000);

        wallet.addCard(card); // Menambahkan kartu ke dompet
        assertNotNull(wallet.getCards().get(0), "Precondition: Card successfully added");

        wallet.removeCard(card); // Menghapus kartu dari dompet
        assertTrue(wallet.getCards().isEmpty(), "Test pass: Card successfully removed");
    }

    @Test
    void testExceptionThrown() {
        Wallet wallet = new Wallet();

        // Memastikan tidak ada IllegalArgumentException dilemparkan saat mata uang yang valid ("IDR") diberikan
        assertDoesNotThrow(() -> wallet.withdrawCash(new Cash(10000, 2, "IDR")),
                "Test pass: No IllegalArgumentException is thrown");
    }

//    @Test 
//    void testExceptionThrown() {
//        Wallet wallet = new Wallet();
//
//        // Memastikan IllegalArgumentException dilemparkan saat mata uang yang tidak valid ("USD") diberikan
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> wallet.withdrawCash(new Cash(10000, 2, "USD")),
//                "Test pass: IllegalArgumentException is thrown");
//
//        // Memeriksa pesan kesalahan yang diharapkan
//        assertEquals("Invalid currency provided: USD", exception.getMessage(), "Test pass: Correct error message is printed");
//    }
}
