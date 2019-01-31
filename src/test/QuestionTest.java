import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void testQuestion() {
        Question q = new Question("1", "Van kávé?", null);
        assertEquals("Van kávé?", q.getQuestion());
    }
}
