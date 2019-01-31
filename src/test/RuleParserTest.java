import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleParserTest {

    @Test
    void testRuleParser() {
        RuleParser ruleParser = new RuleParser("src/main/resources/Facts.xml");
        assertEquals(6, ruleParser.getRuleRepository().getQuestions().size());
    }
}
