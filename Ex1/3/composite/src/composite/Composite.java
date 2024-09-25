package composite;

import utils.Logger;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private List<Component> children = new ArrayList<>();

    @Override
    public void render() {
        Logger.info("Rendering composite component with " + children.size() + " children.");
        for (Component child : children) {
            child.render();
        }
    }

    @Override
    public void add(Component component) {
        children.add(component);
        Logger.info("Component added.");
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
        Logger.info("Component removed.");
    }
}
