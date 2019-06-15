import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class InterestTest {

    Main main = new Main();
    Account accOne,accTwo,accThree,accFour, accFive, accSix;
    boolean up = true;

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
        //I tried another approaches here, still the same result
    }


    @BeforeEach
    void setUp() {

        accOne = new Account(0001,0,75.00,"Bjørn","Kristensen");
        accTwo = new Account(0002,0,678,"Steve","Puller");
        accThree = new Account(0003,0,1525,"Michael","Dell");
        accFour = new Account(0004,0,0,"Donald","Trump");
        accFive = new Account(0005,0,-9000,"Michael","Bloomberg");
        accSix = new Account(0006, 0, 80,"Hannibal", "Skiver");

    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testForThreePercentInterestRate(){

        assertEquals(2.25,main.calculateYearlyInterest(accOne));
    }

    @Test
    void testForFivePercentInterestRate(){

        assertEquals(33.9,main.calculateYearlyInterest(accTwo));
    }

    @Test
    void testForSevenPercentInterestRate(){

        //Change the boolean "up" to "false", to see that the test is skipped
        assertTrue(up);

        assertEquals(106.75,main.calculateYearlyInterest(accThree));
    }

    @Test
    void testForZeroBalance(){

        assertEquals(0,main.calculateYearlyInterest(accFour));
    }

    @Test
    void testForNegativeBalance(){

        assertEquals(0,main.calculateYearlyInterest(accFive));
    }

    @Test
    void testSameInterestRate(){

        main.calculateYearlyInterest(accOne);
        main.calculateYearlyInterest(accSix);
        assertEquals(accOne.getAccInterestRate(), accSix.getAccInterestRate());

    }

    @Test
    void testNotSameInterestRate(){
        main.calculateYearlyInterest(accOne);
        main.calculateYearlyInterest(accTwo);
        assertNotEquals(accOne.getAccInterestRate(), accTwo.getAccInterestRate());
    }

    @DisplayName("Random Boolean Test")
    @Test
    void testRandomBoolean(){

        assertEquals(true, getRandomBoolean());
    }

    //Timeout Test
    @DisplayName("Sleep Test")
    @Disabled
    @Test
    void testAccountCreated() {

        assertNotNull(accOne);

        assertTimeout((Duration.ofSeconds(5)), () -> {
            TimeUnit.SECONDS.sleep(8);
        } );

    }

    //Lambda Test
    @Test
    void testLambdaPrintOut(){

        String message = "The Test Message!";

        assertAll("Running Lambda...", () -> {
            System.out.println(message);
            assertEquals(message, "The Test Message!");
        });


    }

    //Assert all Test with Lambda
    @DisplayName("AssertAllTest")
    @Test
    void testAssertAll(){
        main.calculateYearlyInterest(accSix);

        assertAll("Should test the bank rates",
                () -> assertEquals(2.25,main.calculateYearlyInterest(accOne)),
                () -> assertEquals(33.9,main.calculateYearlyInterest(accTwo)),
                () -> assertEquals(106.75,main.calculateYearlyInterest(accThree)),
                () -> assertEquals(0,main.calculateYearlyInterest(accFour)),
                () -> assertEquals(0,main.calculateYearlyInterest(accFive)),
                () -> assertEquals(accOne.getAccInterestRate(), accSix.getAccInterestRate()),
                () -> assertNotEquals(accOne.getAccInterestRate(), accTwo.getAccInterestRate()));
    }

















}