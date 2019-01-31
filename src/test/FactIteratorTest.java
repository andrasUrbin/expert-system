import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactIteratorTest {

    @Test
    void testFactIterator() {
        FactRepository factRepo = new FactRepository();
        assertFalse(factRepo.getIterator().hasNext());
    }
}
