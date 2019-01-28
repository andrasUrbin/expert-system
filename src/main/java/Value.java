import java.util.List;

public abstract class Value {


    protected boolean selectionType;
    private List<String> values;

    public List<String> getInputPattern() {
        return values;
    }

    public boolean getSelectionType() {
        return selectionType;
    }
}
