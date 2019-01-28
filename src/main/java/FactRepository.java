import java.util.*;

public class FactRepository {

    private List<Fact> facts;
    private Iterator<Fact> iterator;

    public FactRepository() {
        this.facts = new ArrayList<>();
        this.iterator = new FactIterator();
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public Iterator<Fact> getIterator() {
        return this.iterator;
    }

    public List<Fact> getFacts() {
        return this.facts;
    }

    public class FactIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < facts.size();
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return facts.get(index++);
            } else {
                return null;
            }
        }
    }
}
