package com.smartship.model;

import com.smartship.exception.InvalidPackageException;


public class Package {
    private String packageId;
    private String destinationCity;
    private double weight;
    private PackagePriority priority;

    public Package(String packageId, String destinationCity, double weight, PackagePriority priority) throws InvalidPackageException {
        if(packageId == null || packageId.isEmpty()) {
            throw new InvalidPackageException("Package ID cannot be empty");
        }
        if(destinationCity == null || destinationCity.isEmpty()) {
            throw new InvalidPackageException("Destination city cannot be empty");
        }
        if(weight <= 0) {
            throw new InvalidPackageException("Weight must be greater than zero");
        }
        this.packageId = packageId;
        this.destinationCity = destinationCity;
        this.weight = weight;
        this.priority = priority;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public double getWeight() {
        return weight;
    }

    public PackagePriority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "[" + priority + "] " + packageId + " to " + destinationCity + " (" + weight + "kg)";
    }
}
