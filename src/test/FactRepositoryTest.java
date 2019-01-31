import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FactRepositoryTest {

    @Test
    void testFactRepository() {
        FactRepository factrepo = new FactRepository();
        assertTrue(factrepo.getFacts().isEmpty());
    }
}
