import org.example.Calculate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


    class calculater {

        Calculate calc = new Calculate();

        @Test
        void testAdd() {
            assertEquals(5, calc.add(2, 3));
        }

        @Test
        void testSubtract() {
            assertEquals(1, calc.subtract(3, 2));
        }

        @Test
        void testMultiply() {
            assertEquals(6, calc.multiply(2, 3));
        }

        @Test
        void testDivide() {
            assertEquals(2, calc.divide(6, 3));
        }

        @Test
        void testDivideByZero() {
            assertThrows(IllegalArgumentException.class, () -> calc.divide(5, 0));
        }
    }

