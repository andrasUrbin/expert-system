import java.util.HashMap;
import java.util.Map;

public class ESProvider {

    private FactParser factParser;
    private RuleParser ruleParser;
    private Map<String, Boolean> answers;


    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    //Skeleton code
    public void collectAnswers() {
        answers = new HashMap<>();
        Ui ui = new ui();
        while(ruleParser.getRuleRepository().getIterator().hasNext()){
            do{
                System.out.println("Question");
                String input = ui.getInput();
            }while(!isValid(input));
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
