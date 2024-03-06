import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
class lyfecycleTest {
    @BeforeAll
    static void initClass() {
        System.out.println("Init class");
    }
    @BeforeEach
    void initMethod() {
        System.out.println("Init method");
    }
    @Test
    void testMethod() {
        System.out.println("Execute test");
    }
    @AfterEach
    void cleanMethod() {
        System.out.println("Clean method");
    }
    @AfterAll
    static void cleanClass() {
        System.out.println("Clean class");
    }
    @Test
    void testMethod1() {
        System.out.println("Execute test 1");
    }
}