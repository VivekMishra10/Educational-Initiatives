package composite;

import utils.Logger;

public class TextField extends Component {
    private String text;

    public TextField(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        Logger.info("Rendering TextField with text: " + text);
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
