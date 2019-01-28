import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RuleRepository {

    private Map<String, Question> questions = new HashMap<>();
    private Iterator<Question> iterator;

    public RuleRepository() {
        this.iterator = new RuleRepository.QuestionIterator();
    }

    public void addQuestion(Question question) {
        questions.put(question.getId(), question);
    }

    public Iterator<Question> getIterator() {
        return this.iterator;
    }

    public class QuestionIterator implements Iterator {
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
