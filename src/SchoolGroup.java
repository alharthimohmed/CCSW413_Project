import java.util.ArrayList;
import java.util.List;



public class SchoolGroup implements SchoolComponent{
    private final String name;
    private final List<SchoolComponent> children;

    public SchoolGroup(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(SchoolComponent component) {
        children.add(component);
    }

    public void remove(SchoolComponent component) {
        children.remove(component);

    }

    public String getDetails(String indent) {
        StringBuilder result = new StringBuilder();

        result.append(indent)
                .append(name)
                .append("\n");
        for (SchoolComponent child : children) {
            result.append(child.getDetails(indent + "   "));
        }
        return result.toString();

    }
}
