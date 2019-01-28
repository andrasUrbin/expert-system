import java.util.*;

public class FactRepository {

    private List<Fact> facts = new ArrayList<>();
    private Iterator<Fact> iterator;

    public FactRepository() {
        this.iterator = new FactRepository.FactIterator();
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public Iterator<Fact> getIterator() {
        return this.iterator;
    }

    public class FactIterator implements Iterator {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

    }
}
