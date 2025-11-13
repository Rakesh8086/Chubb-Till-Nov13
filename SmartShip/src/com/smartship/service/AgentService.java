package com.smartship.service;

import com.smartship.exception.AgentNotAvailableException;
import com.smartship.exception.OverloadException;
import com.smartship.model.DeliveryAgent;
import com.smartship.model.Package;

import java.util.*;
import java.util.stream.Collectors;


public class AgentService {

    private Map<String, List<DeliveryAgent>> cityAgentsMap;

    public AgentService() {
        cityAgentsMap = new HashMap<>();
    }


    public void addAgent(DeliveryAgent agent) {
        cityAgentsMap.computeIfAbsent(agent.getCity(), k -> new ArrayList<>()).add(agent);
    }


    public void assignPackageToAgent(Package pkg) throws AgentNotAvailableException, OverloadException {
        List<DeliveryAgent> agentsInCity = cityAgentsMap.get(pkg.getDestinationCity());

        if (agentsInCity == null || agentsInCity.isEmpty()) {
            throw new AgentNotAvailableException("No agents available in city: " + pkg.getDestinationCity());
        }

        List<DeliveryAgent> sortedAgents = agentsInCity.stream()
                .sorted(Comparator.comparingInt(a -> a.getAssignedPackages().size()))
                .collect(Collectors.toList());

        boolean assigned = false;

        for (DeliveryAgent agent : sortedAgents) {
            try {
                agent.assignPackage(pkg);
                assigned = true;
                System.out.println("Package " + pkg.getPackageId() + " assigned to agent " + agent.getName());
                break;
            } catch (OverloadException e) {
                // Try next agent
            }
        }

        if (!assigned) {
            throw new OverloadException("All agents in " + pkg.getDestinationCity() + " are overloaded!");
        }
    }


    public List<DeliveryAgent> getAllAgents() {
        return cityAgentsMap.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
