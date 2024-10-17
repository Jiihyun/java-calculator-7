package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputViewTest {
    @DisplayName("덧셈할 문자열을 입력 받을 수 있다.")
    @Test
    void readStringToSum() {
        //given
        String input = "1;2;3";
        InputView inputView = new InputView();

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //when
        String stringToAdd = inputView.readStringToAdd();
        //then
        assertThat(out.toString()).contains("덧셈할 문자열을 입력해 주세요.");
        assertThat(stringToAdd).isEqualTo(input);
    }
}