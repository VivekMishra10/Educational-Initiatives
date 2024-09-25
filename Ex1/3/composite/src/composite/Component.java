package composite;

public abstract class Component {
    public abstract void render();
    public abstract void add(Component component);
    public abstract void remove(Component component);
}
