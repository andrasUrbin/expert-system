import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {

    private String id;
    private String description;
    private Map<String, Boolean> evaluations;

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
        this.evaluations = new HashMap<>();
    }

    public Set<String> getIdSet() {
        return this.evaluations.keySet();
    }

    public void setFactValueById(String id, boolean value) {
        this.evaluations.put(id, value);
    }

    public boolean getValueById(String id) {
        return this.evaluations.get(id);
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, Boolean> getEvaluations() {
        return evaluations;
    }
}
