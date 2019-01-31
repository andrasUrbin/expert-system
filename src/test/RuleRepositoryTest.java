import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleRepositoryTest {

    @Test
    void testRuleRepository() {
        RuleRepository ruleRepo = new RuleRepository();
        assertTrue(ruleRepo.getQuestions().isEmpty());
    }
}
