package ru.skypro.unittesting;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GreetingsServiceTest {
    private final GreetingsService greetingsService = new GreetingsService();
    //тестирование метода возвращающего null
    @DisplayName("Проверка возврата значения по умолчанию при пустом вводе")
    @Test
    @SneakyThrows
    void generateGreetings_NullInput_ReturnDefaultValue() {
        final String expected = "Greeting, stranger!";
        final String input = null;

        String actual = greetingsService.generateGreetings(input);

        assertEquals(expected, actual);
    }

    //теститрование метода бросающего исключение
    @DisplayName("Проверка возврата значения по умолчанию при пустом вводе")
    @Test
    void generateGreetings_NullInput_ThrowsException() {
        final String input = "Проверка пройдена, все круто!";

        assertThrows(IllegalArgumentException.class, () ->
                greetingsService.generateGreetings(input));

    }
//    параметризованный тест
    @ParameterizedTest
    @MethodSource("provideData")
    @SneakyThrows
    void generateGreetings_CorrectInput_OK(String input, String expected) {
         String actual = greetingsService.generateGreetings(input);
         assertEquals(expected, actual);
    }
    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("anton", "Greetings, Anton!"),
                Arguments.of("aNTOn", "Greetings, Anton!"),
                Arguments.of("janE", "Greetings, Jane!")
        );
    }
}
