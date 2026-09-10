import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Stores information about customers currently inside
    private Map<Integer, CheckInInfo> checkIns;

    // Stores total travel time and number of trips for each route
    private Map<String, RouteInfo> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        // Get the customer's check-in information
        CheckInInfo info = checkIns.get(id);

        // Calculate travel time
        int travelTime = t - info.time;

        // Create a unique key for the route
        String route = info.station + "," + stationName;

        // Add the travel time to the route
        if (!routes.containsKey(route)) {
            routes.put(route, new RouteInfo());
        }

        RouteInfo routeInfo = routes.get(route);
        routeInfo.totalTime += travelTime;
        routeInfo.tripCount++;

        // Customer is no longer checked in
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "," + endStation;

        RouteInfo routeInfo = routes.get(route);

        return (double) routeInfo.totalTime / routeInfo.tripCount;
    }

    // Helper class for check-in information
    private static class CheckInInfo {
        String station;
        int time;

        CheckInInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Helper class for route information
    private static class RouteInfo {
        int totalTime = 0;
        int tripCount = 0;
    }
}
