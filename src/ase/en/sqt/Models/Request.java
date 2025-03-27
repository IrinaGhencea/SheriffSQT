package ase.en.sqt.Models;

public class Request {
    private String description;
    private DispatcherType type;

    public Request(String description, DispatcherType type) {
        this.description = description;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public DispatcherType getType() {
        return type;
    }

    public void setType(DispatcherType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + description;
    }

    public DispatcherType getDispatcherType() {
        return type;
    }

    public void setDispatcherType(DispatcherType newType) {
        this.type=newType;
    }
}
