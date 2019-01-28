import java.util.*;

public class RuleRepository {
    private Iterator<Question> questionIterator;
    private List<Question> questions;

    public RuleRepository() {
        this.questions = new ArrayList<>();
        this.questionIterator = new QuestionIterator();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public Iterator<Question> getIterator() {
        return this.questionIterator;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public class QuestionIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < questions.size();
        }

        @Override
        public Question next() {
            if (this.hasNext()) {
                return questions.get(index++);
            } else {
                return null;
            }
        }
    }
}
