package composite;

import utils.Logger;

public class Button extends Component {
    private String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public void render() {
        Logger.info("Rendering Button: " + label);
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add components to a leaf");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove components from a leaf");
    }
}
