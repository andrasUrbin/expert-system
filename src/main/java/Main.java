public class Main {

    public static void main(String[] args) {
        FactParser factParser = new FactParser("src/main/resources/Facts.xml");
        RuleParser ruleParser = new RuleParser("src/main/resources/Rules.xml");

        ESProvider esp = new ESProvider(factParser, ruleParser);
        System.out.println("TESTING FACTS");

        esp.collectAnswers();

        System.out.println(esp.evaluate());


    }
}
