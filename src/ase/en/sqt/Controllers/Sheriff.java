package ase.en.sqt.Controllers;

import ase.en.sqt.Dispatcher.Dispatcher;
import ase.en.sqt.Models.DispatcherType;
import ase.en.sqt.Models.Request;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Sheriff {
    private String name;
    private int tenure;
    private LinkedList<Request> queue;
    private int maxQueueSize;
    private final Map<String, Dispatcher> dispatchers = new HashMap<>();

    public Sheriff(String name, int tenure, int maxQueueSize) {
        this.name = name;
        this.tenure = tenure;
        this.maxQueueSize = maxQueueSize;
        this.queue = new LinkedList<>();
    }

    public void addDispatcher(String id, Dispatcher dispatcher) {
        dispatchers.put(id, dispatcher);
    }

    public Dispatcher getDispatcher(String id) {
        return dispatchers.get(id);
    }

    public void updateDispatcher(String id, String newAddress) {
        Dispatcher dispatcher = dispatchers.get(id);
        if (dispatcher != null) {
            dispatcher.address = newAddress;
        }
    }

    public void removeDispatcher(String id) {
        dispatchers.remove(id);
    }

    public void listDispatchers() {
        dispatchers.forEach((id, dispatcher) ->
                System.out.println("ID: " + id + ", Address: " + dispatcher.getAddress())
        );
    }

    public void addRegularRequest(Request request) {
        if (queue.size() < maxQueueSize) {
            queue.addLast(request);
        }
    }

    public void addEmergencyRequest(Request request) {
        if (queue.size() < maxQueueSize) {
            int insertIndex = 0;
            for (Request r : queue) {
                if (r.getDispatcherType() == DispatcherType.CRISIS) insertIndex++;
            }
            queue.add(insertIndex, request);
        }
    }

    public void addCrisisRequest(Request request) {
        if (queue.size() >= maxQueueSize) {
            queue.removeLast();
        }
        queue.addFirst(request);
    }

    public void resolveRequest() {
        if (!queue.isEmpty()) {
            queue.removeFirst();
        }
    }

    public void transformRequest(int index, DispatcherType newType) {
        if (index < 0 || index >= queue.size()) return;
        Request req = queue.remove(index);
        req.setDispatcherType(newType);
        switch (newType) {
            case REGULAR -> addRegularRequest(req);
            case EMERGENCY -> addEmergencyRequest(req);
            case CRISIS -> addCrisisRequest(req);
        }
    }

    public void printQueue() {
        for (Request r : queue) {
            System.out.println(r);
        }
    }

}
