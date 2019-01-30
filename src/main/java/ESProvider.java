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
<<<<<<< HEAD

            for (Question question:ruleParser.getRuleRepository().getQuestions()) {
                do {
                    System.out.println(ruleParser.getRuleRepository().getIterator().next().getQuestion());
=======
            int i = 0;
            for (Question question: ruleParser.getRuleRepository().getQuestions()) {
                Question current = ruleParser.getRuleRepository().getIterator().next();
                System.out.println(current.getQuestion());
                input = ui.getInput();
                while(!isValid(input)) {
                    System.out.println(ruleParser.getRuleRepository().getQuestions().get(i).getQuestion());
>>>>>>> 93d0c3f076a2a8c2c40b9b964b7f2dc594e2daab
                    input = ui.getInput();
                }
                i++;
                answers.put(question.getId(), answer.evaluateAnswerByInput(input));

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
