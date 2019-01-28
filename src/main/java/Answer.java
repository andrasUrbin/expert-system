import java.util.ArrayList;
import java.util.List;

public class Answer {

    protected List<Value> valueList = new ArrayList<>();

    public boolean evaluateAnswerByInput(String input) {

        if (input.equals("yes")) {
            return true;
        } else if (input.equals("no")) {
            return false;
        }
        return false;
    }

    public void addValue(Value value) {
        valueList.add(value);
    }
}
