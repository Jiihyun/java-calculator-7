package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberExtractorTest {

    @DisplayName("구분자로 나뉜 숫자를 구할 수 있다.")
    @Test
    void getNumbersWithoutDelimiters() {
        //given
        String stringToAdd = "1,2,3";
        NumberExtractor numberExtractor = createNumberStringExtractor();
        //when
        List<Integer> numbers = numberExtractor.getNumbers(stringToAdd);
        //then
        assertThat(numbers).hasSize(3);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @DisplayName("구분자로 나뉜 숫자를 구할 수 있다.")
    @Test
    void getNumbersWithoutDelimiters2() {
        //given
        String stringToAdd = "10:20,30:40";
        NumberExtractor numberExtractor = createNumberStringExtractor();
        //when
        List<Integer> numbers = numberExtractor.getNumbers(stringToAdd);
        //then
        assertThat(numbers).hasSize(4);
        assertThat(numbers).containsExactly(10, 20, 30, 40);
    }

    @DisplayName("구분자로 나뉜 숫자를 구할 수 있다.")
    @Test
    void getNumbersWithoutDelimiters3() {
        //given
        String stringToAdd = "//%\\n1%5,55:40%2,3%7:9";
        NumberExtractor numberExtractor = createNumberStringExtractor();
        //when
        List<Integer> numbers = numberExtractor.getNumbers(stringToAdd);
        //then
        assertThat(numbers).hasSize(8);
        assertThat(numbers).containsExactly(1, 5, 55, 40, 2, 3, 7, 9);
    }

    private NumberExtractor createNumberStringExtractor() {
        return new NumberExtractor(
                new StringSplitter(new CustomDelimiterExtractor()));
    }
}