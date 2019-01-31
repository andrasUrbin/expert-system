import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactParserTest {

    @Test
    void testFactParser() {
        FactParser parser = new FactParser("src/main/resources/Facts.xml");
        assertEquals(40, parser.getFactRepository().getFacts().size(), "Database size error!");
    }
}
