public class Task {
    protected String description;
    protected boolean completed = false;

    public Task(String description) {
        this.description = description;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        if (completed) {
            return ("[X] " + description);
        } else {
            return "[] " + description;
        }

    }
}
