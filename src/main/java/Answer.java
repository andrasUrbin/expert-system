import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Answer {

    protected List<Value> valueList = new ArrayList<>();

    public boolean evaluateAnswerByInput(String input) {

        if (input.equalsIgnoreCase("yes")) {
            return true;
        } else if(input.equalsIgnoreCase("no")) {
            return false;
        }
        return false;
    }

    public void addValue(Value value) {
        valueList.add(value);
    }

}
