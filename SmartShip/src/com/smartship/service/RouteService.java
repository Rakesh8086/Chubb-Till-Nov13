package com.smartship.service;

import com.smartship.exception.RouteUnavailableException;
import com.smartship.model.Route;

import java.util.*;

public class RouteService {

    private List<Route> routes;

    public RouteService() {
        routes = new ArrayList<>();
    }


    public void addRoute(String fromCity, String toCity) {
        routes.add(new Route(fromCity, toCity));
    }


    public void validateRoute(String fromCity, String toCity) throws RouteUnavailableException {
        boolean found = routes.stream()
                .anyMatch(r -> r.getFromCity().equalsIgnoreCase(fromCity)
                        && r.getToCity().equalsIgnoreCase(toCity));

        if (!found) {
            throw new RouteUnavailableException("No available route from " + fromCity + " to " + toCity);
        }
    }


    public List<Route> getAllRoutes() {
        return routes;
    }
}
