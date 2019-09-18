package bean;

/**
 * The type Plane.
 */
public abstract class Plane {
    private Model model;
    private boolean free;

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * Is free boolean.
     *
     * @return the boolean
     */
    public boolean isFree() {
        return free;
    }

    /**
     * Sets free.
     *
     * @param free the free
     */
    public void setFree(boolean free) {
        this.free = free;
    }
}
