package main.java.bean;

public abstract class Plane {
    private Model model;
    private boolean free;

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

}
