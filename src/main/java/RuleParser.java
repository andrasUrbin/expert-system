import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;
    private NodeList nodeList;

    public RuleParser(String xmlPath) {
        loadXmlDocument(xmlPath); //We get the actual document
        this.ruleRepository = new RuleRepository();
        this.nodeList = document.getElementsByTagName("Rule"); //Counting how many Rules there are - needed for iteration later
        addRulesToRepository();
    }

    public RuleRepository getRuleRepository() {
        return this.ruleRepository;
    }

    private void addRulesToRepository() {
        for (int i = 0; i < nodeList.getLength(); i++) { // Iterate through all Rule type nodes
            Node tempNode = nodeList.item(i); // This is the current node at index i
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) { // Type check to make sure it's an element type node (not text node or white space etc)
                Element tempElement = (Element) tempNode; // casting this node to element
                String id = tempElement.getAttribute("id"); // get the value of "id" attribute - for example: single
                String questionText = tempElement.getElementsByTagName("Question").item(0).getTextContent(); // Saving the text content of the first question node
                Answer answer = getAnswers(tempElement); // see method below

                Question question = new Question(id, questionText, answer); // init question object
                this.ruleRepository.addQuestion(question); // store in memory via repository class
            }
        }
    }

    private Answer getAnswers(Element tempElement) {
        Answer answer = new Answer(); // init an answer object
        NodeList answersList = tempElement.getElementsByTagName("Selection"); // making a list as long as the number of "selection" nodes

        for (int i= 0; i < answersList.getLength(); i++) { // iteration, same as before
            Node answerNode = answersList.item(i);

            if (answerNode.getNodeType() == Node.ELEMENT_NODE) { // these couple of lines are for getting the actual value (true/false) of each answer
                Element answerElement = (Element) answerNode;
                Element valueNode = (Element) answerNode.getChildNodes().item(1);
                boolean answerType = Boolean.valueOf(answerElement.getAttribute("value"));
                Value value;

                if (valueNode.getNodeName().equals("SingleValue")) { // here we can check if node is single or multi value and create the appropriate objects
                    String param = valueNode.getAttribute("value");
                    value = new SingleValue(param, answerType);
                } else {
                    List<String> params = Arrays.asList(valueNode.getAttribute("value").split(","));
                    value = new MultipleValue(params, answerType);
                }
                answer.addValue(value);
            }
        }
        return answer;
    }
}
