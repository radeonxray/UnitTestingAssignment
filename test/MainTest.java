import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main = new Main();
    Account accOne;
    Account accTwo;
    Account accThree;

    @Before
    public void setUp() throws Exception {
       accOne = new Account(0001,0,55.00,"Bjørn","Kristensen");
       accTwo = new Account(0002,0,678,"Steve","Puller");
       accThree = new Account(0003,0,1525,"Michael","Dell");

    }

    @Test
    void testForThreePercentInterestRate(){
        assertEquals(1.65,main.calculateYearlyInterest(accOne));
    }

}