public class Main {

    public static void main(String[] args) {
        FactParser factParser = new FactParser("src/main/resources/Facts.xml");
        RuleParser ruleParser = new RuleParser("src/main/resources/Rules.xml");

        ESProvider esp = new ESProvider(factParser, ruleParser);
        System.out.println("TESTING FACTS");
        /*for (Fact fact:factParser.getFactRepository().getFacts()
             ) {
            System.out.println(fact.getDescription());
        }
        System.out.println("\nTESTING RULES");
        for (Question question:ruleParser.getRuleRepository().getQuestions()
             ) {
            System.out.println(question.getQuestion());
        }
        */

        esp.collectAnswers();

       // System.out.println(ruleParser.getRuleRepository().getIterator().hasNext());




    }
}
