package com.smartship.service;

import com.smartship.exception.DuplicateEntryException;
import com.smartship.exception.InvalidPackageException;
import com.smartship.model.Package;
import com.smartship.model.PackagePriority;

import java.util.*;


public class PackageService {

    private PriorityQueue<Package> packageQueue;

    private Set<String> packageIds;

    public PackageService() {
        packageQueue = new PriorityQueue<>(new Comparator<Package>() {
            @Override
            public int compare(Package p1, Package p2) {
                return p2.getPriority().ordinal() - p1.getPriority().ordinal();
            }
        });
        packageIds = new HashSet<>();
    }

 
    public void addPackage(Package pkg) throws DuplicateEntryException, InvalidPackageException {
        if (pkg == null) {
            throw new InvalidPackageException("Package cannot be null");
        }
        if (packageIds.contains(pkg.getPackageId())) {
            throw new DuplicateEntryException("Package with ID " + pkg.getPackageId() + " already exists");
        }

        packageQueue.add(pkg);
        packageIds.add(pkg.getPackageId());
    }

    
    public Package getNextPackage() {
        Package pkg = packageQueue.poll();
        if(pkg != null) {
            packageIds.remove(pkg.getPackageId());
        }
        return pkg;
    }


    public boolean hasPackages() {
        return !packageQueue.isEmpty();
    }


    public List<Package> getAllPackages() {
        return new ArrayList<>(packageQueue);
    }
}
