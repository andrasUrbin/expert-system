import java.util.Set;

public class Fact {

    private String id;
    private String description;
    private Set<String> idSet;

    public Fact(String id, String description){
        id = this.id;
        description = this.description;
    }

    public String getDescription() {
        return description;
    }

    public Set<String> getIdSet() {
        return idSet;
    }

    public void setFactValueById(String id) {

    }

    public boolean getValueById(String id) {
        return false;
    }
}
