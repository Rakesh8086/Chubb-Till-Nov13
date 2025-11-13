package com.smartship.app;

import com.smartship.exception.*;
import com.smartship.model.*;
import com.smartship.model.Package;
import com.smartship.service.*;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("===== SmartShip: Intelligent Delivery Management System =====");

        PackageService packageService = new PackageService();
        AgentService agentService = new AgentService();
        RouteService routeService = new RouteService();

        try {
            routeService.addRoute("Mumbai", "Delhi");
            routeService.addRoute("Mumbai", "Bangalore");
            routeService.addRoute("Delhi", "Chennai");
            routeService.addRoute("Delhi", "Kolkata");
            routeService.addRoute("Bangalore", "Hyderabad");

            agentService.addAgent(new DeliveryAgent("A1", "Ramesh", "Delhi", 3));
            agentService.addAgent(new DeliveryAgent("A2", "Suresh", "Delhi", 2));
            agentService.addAgent(new DeliveryAgent("A3", "Priya", "Bangalore", 3));
            agentService.addAgent(new DeliveryAgent("A4", "Anita", "Chennai", 2));
            agentService.addAgent(new DeliveryAgent("A5", "Vikram", "Kolkata", 2));

            packageService.addPackage(new Package("P1", "Delhi", 5.0, PackagePriority.HIGH));
            packageService.addPackage(new Package("P2", "Delhi", 2.0, PackagePriority.LOW));
            packageService.addPackage(new Package("P3", "Chennai", 3.5, PackagePriority.HIGH));
            packageService.addPackage(new Package("P4", "Kolkata", 4.0, PackagePriority.LOW));
            packageService.addPackage(new Package("P5", "Bangalore", 1.2, PackagePriority.HIGH));
            packageService.addPackage(new Package("P6", "Delhi", 3.0, PackagePriority.LOW));

            System.out.println("Initial packages queued for delivery:");
            for (Package p : packageService.getAllPackages()) {
                System.out.println(" - " + p);
            }


            while (packageService.hasPackages()) {
                Package pkg = packageService.getNextPackage();

                try {
                    routeService.validateRoute("Mumbai", pkg.getDestinationCity());

                    agentService.assignPackageToAgent(pkg);

                } catch (RouteUnavailableException | AgentNotAvailableException | OverloadException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Final Agent Load");
            List<DeliveryAgent> agents = agentService.getAllAgents();
            for (DeliveryAgent agent : agents) {
                System.out.println("\n" + agent.getName() + " (" + agent.getCity() + "):");
                for (Package pkg : agent.getAssignedPackages()) {
                    System.out.println("   → " + pkg);
                }
                if (agent.getAssignedPackages().isEmpty()) {
                    System.out.println("   (No packages assigned)");
                }
            }

        } catch (InvalidPackageException | DuplicateEntryException e) {
            System.out.println("Initialization error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        System.out.println("==== Delivery Assignment Completed =====");
    }
}
