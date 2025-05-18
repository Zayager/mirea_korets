import org.example.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class BonusServiceTest {
    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }
}
