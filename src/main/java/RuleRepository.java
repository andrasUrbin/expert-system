import java.util.Iterator;

public class RuleRepository {

    private Question question;

    public void addQuestion(Question question) {

    }

    public Question getIterator() {
        return this.question;
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
