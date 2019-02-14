import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class FactParser extends XMLParser {

    private FactRepository factRepository;
    private NodeList nodeList;

    public FactParser(String xmlPath) {
        loadXmlDocument(xmlPath);
        this.factRepository = new FactRepository();
        this.nodeList = document.getElementsByTagName("Fact");
        addFactsToRepository();
    }

    public FactRepository getFactRepository() {
        return this.factRepository;
    }

    private void addFactsToRepository() { // creating the fact objects based on xml - see ruleparser for more detailed explanation of the process :)
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node tempNode = nodeList.item(i);
            Element tempElement = (Element) tempNode;
            String id = tempElement.getAttribute("id");
            Node descriptionNode = tempElement.getElementsByTagName("Description").item(0);
            String description = ((Element) descriptionNode).getAttribute("value");

            Fact fact = new Fact(id, description);
            setFactEvaluations(fact, tempElement);

            this.factRepository.addFact(fact);
        }
    }

    private void setFactEvaluations(Fact fact, Element tempElement) {
        Element evaluationNode = (Element) tempElement.getElementsByTagName("Evals").item(0); // the we get a list of "evals" nodes and take the first element
        NodeList evaluations = evaluationNode.getElementsByTagName("Eval"); // list of eval child nodes (for iteration)

        for (int i = 0; i < evaluations.getLength(); i++) {
            Element evaluation = (Element) evaluations.item(i);
            String id = evaluation.getAttribute("id"); // getting each id, like single, multi, f2play...
            String value = evaluation.getTextContent(); // text content of the id, so true or false
            fact.setFactValueById(id, Boolean.valueOf(value)); // setting the value of each fact object based on their id
        }
    }
}