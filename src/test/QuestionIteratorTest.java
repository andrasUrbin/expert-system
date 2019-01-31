import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionIteratorTest {

    @Test
    void testQuestionIterator() {
        RuleRepository ruleRepo = new RuleRepository();
        assertFalse(ruleRepo.getIterator().hasNext());
    }
}
