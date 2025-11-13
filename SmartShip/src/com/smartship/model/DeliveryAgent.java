package com.smartship.model;

import java.util.ArrayList;
import java.util.List;

import com.smartship.exception.OverloadException;


public class DeliveryAgent {
    private String agentId;
    private String name;
    private String city;
    private int maxLoad; 
    private List<Package> assignedPackages;

    public DeliveryAgent(String agentId, String name, String city, int maxLoad) {
        this.agentId = agentId;
        this.name = name;
        this.city = city;
        this.maxLoad = maxLoad;
        this.assignedPackages = new ArrayList<>();
    }

    public String getAgentId() {
        return agentId;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<Package> getAssignedPackages() {
        return assignedPackages;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void assignPackage(Package pkg) throws OverloadException {
        if(assignedPackages.size() >= maxLoad) {
            throw new OverloadException("Agent " + name + " has reached maximum load!");
        }
        assignedPackages.add(pkg);
    }

    @Override
    public String toString() {
        return name + " (" + city + ") - Assigned Packages: " + assignedPackages.size();
    }
}
