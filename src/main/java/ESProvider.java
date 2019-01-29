import java.util.HashMap;
import java.util.Map;

public class ESProvider {

    private FactParser factParser;
    private RuleParser ruleParser;
    private Map<String, Boolean> answers;
    private Answer answer = new Answer();



    public Map<String, Boolean> getAnswers() {
        return answers;
    }

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    //Skeleton code
    public void collectAnswers() {
        answers = new HashMap<>();
        Ui ui = new Ui();

        while(ruleParser.getRuleRepository().getIterator().hasNext()){
            String input;

            for (Question question:ruleParser.getRuleRepository().getQuestions()) {
                do {
                    System.out.println(ruleParser.getRuleRepository().getIterator().next().getQuestion());
                    input = ui.getInput();
                    answers.put(question.getId(), answer.evaluateAnswerByInput(input));
                } while (!isValid(input));

            }
        }

    }

    public boolean getAnswerByQuestion(String questionId) {
        return false;
    }

    public String evaluate() {
        return null;
    }

    public boolean isValid(String answer){
        if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")){
            return true;
        }else{
            return false;
        }

    }
}
