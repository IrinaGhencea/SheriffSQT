package ase.en.sqt.Dispatcher;

import ase.en.sqt.Controllers.Sheriff;
import ase.en.sqt.Models.Request;

public abstract class Dispatcher {
    protected String id;
    public String address;

    public Dispatcher(String id, String address) {
        this.id = id;
        this.address = address;
    }


    public String getId() {
        return id;
    }


    public String getAddress() {
        return address;
    }

    public abstract void sendRequest(Sheriff sheriff, Request request);
}
