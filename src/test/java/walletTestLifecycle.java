import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class walletTestLifecycle {

    private Wallet wallet;
    @BeforeAll
    void initClass() {
        System.out.println("@BeforeAll is called");
    }

    @BeforeEach
    void initMethod() {
        wallet = new Wallet(); // Buat dompet baru untuk setiap tes
        System.out.println("Membuat dompet baru");
    }

    @AfterEach
    void cleanMethod() {
        wallet = null; // Hapus dompet setelah setiap tes
        System.out.println("Menghapus dompet");
    }

    @AfterAll
    void cleanClass()  {
        System.out.println("@AfterAll is called");
    }

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

}
