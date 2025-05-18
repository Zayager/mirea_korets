//package ru.netology.services;
import org.example.VacationService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacationServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testCalculate(int income, int expenses, int threshold, int expected) {
        VacationService service = new VacationService();

        int actual = service.calculate(income, expenses, threshold);

        assertEquals(expected, actual);
    }
}
