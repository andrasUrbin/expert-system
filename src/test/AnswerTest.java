import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    void testAnswer() {
        Answer answer = new Answer();
        assertTrue(answer.evaluateAnswerByInput("yes"));
        assertFalse(answer.evaluateAnswerByInput("no"));
    }
}
