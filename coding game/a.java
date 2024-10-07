import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Keep track of used pod IDs
        Set<Integer> usedPodIds = new HashSet<>();
        int nextPodId = 42; // Start with the first pod ID at 42 (you can change this starting value)
        int resources=0;
        int numTravelRoutes=0;
        List<Route> routes=new ArrayList<>();
        Set<String> existingRoutes = new HashSet<>();
        int numPods=0; 
        List<Pod> pods = new ArrayList<>(); // store pod routes
        int numNewBuildings=0;
        List<Building> newBuildings = new ArrayList<>();

        // game loop
        while (true) {
            resources = in.nextInt(); // total resources available for the month
            numTravelRoutes = in.nextInt(); // number of existing routes
            routes = new ArrayList<>(); // store routes information
            existingRoutes = new HashSet<>();
            // to track valid routes
            for (int i = 0; i < numTravelRoutes; i++) {
                int buildingId1 = in.nextInt();
                int buildingId2 = in.nextInt();
                int capacity = in.nextInt();
                routes.add(new Route(buildingId1, buildingId2, capacity));
                existingRoutes.add(buildingId1 + "-" + buildingId2); // store as valid route
                existingRoutes.add(buildingId2 + "-" + buildingId1); // store reverse as well
            }
            
            numPods = in.nextInt(); // number of transport pods
            if (in.hasNextLine()) {
                in.nextLine();
            }
            pods = new ArrayList<>(); // store pod routes
            for (int i = 0; i < numPods; i++) {
                String podProperties = in.nextLine();
                pods.add(new Pod(podProperties)); // parse pod data
            }

            // Update used pod IDs to avoid reusing them
            for (Pod pod : pods) {
                usedPodIds.add(pod.id); // Track IDs of existing pods
            }

            numNewBuildings = in.nextInt(); // number of new buildings
            if (in.hasNextLine()) {
                in.nextLine();
            }
            newBuildings = new ArrayList<>();
            for (int i = 0; i < numNewBuildings; i++) {
                String buildingProperties = in.nextLine();
                newBuildings.add(new Building(buildingProperties)); // parse building data
            }

            // We will build actions based on available resources
            StringBuilder actions = new StringBuilder();
            
            // 1. Create valid tubes between different buildings, if enough resources
            if (resources >= 100 && newBuildings.size() > 0) {
                Building newBuilding = newBuildings.get(0);

                // Example: Connect newBuilding to building 1 and 2
                if (!existingRoutes.contains(newBuilding.id + "-1") && resources >= 100) {
                    actions.append("TUBE ").append(newBuilding.id).append(" 1;");
                    resources -= 100;
                    existingRoutes.add(newBuilding.id + "-1");
                    existingRoutes.add("1-" + newBuilding.id); // Add reverse route
                }

                if (!existingRoutes.contains(newBuilding.id + "-2") && resources >= 100) {
                    actions.append("TUBE ").append(newBuilding.id).append(" 2;");
                    resources -= 100;
                    existingRoutes.add(newBuilding.id + "-2");
                    existingRoutes.add("2-" + newBuilding.id); // Add reverse route
                }
            }

            // 2. If resources allow, create a pod on a valid route with a new unique ID
            if (resources >= 1000 && existingRoutes.contains("0-1")) {
                // Ensure we use a new unique pod ID
                while (usedPodIds.contains(nextPodId)) {
                    nextPodId++; // Increment until we find an unused ID
                }
                actions.append("POD ").append(nextPodId).append(" 0 1;");
                resources -= 1000;
                usedPodIds.add(nextPodId); // Mark this pod ID as used
                nextPodId++; // Prepare the next unique pod ID
            }

            // 3. If enough resources, upgrade a tube
            if (resources >= 2500) { 
                if (routes.size() > 0) {
                    Route route = routes.get(0); // Choose the first route to upgrade
                    actions.append("UPGRADE ").append(route.building1).append(" ").append(route.building2).append(";");
                    resources -= 2500;
                }
            }

            // 4. If no valid action can be performed, WAIT
            if (actions.length() == 0) {
                actions.append("WAIT");
            }

            // Output the actions for this turn
            System.out.println(actions.toString().trim());
        }
    }

    // Class to represent a route between buildings
    static class Route {
        int building1, building2, capacity;

        Route(int building1, int building2, int capacity) {
            this.building1 = building1;
            this.building2 = building2;
            this.capacity = capacity;
        }
    }

    // Class to represent a pod's properties
    static class Pod extends Building {
        int numAstronouts;
        ArrayList<Integer> astronouts= new ArrayList<>();

        Pod(String properties) {
            super(properties);
            String[] s=properties.split(" ");
            numAstronouts=Integer.parseInt(s[4]);
            for (int i = 5; i < s.length; i++) {
                astronouts.add(Integer.parseInt(s[i]));
            }
        }
    }

    // Class to represent a building and its properties
    static class Building  {
        int id;
        int x;
        int y;

        Building(String properties) {
            String[] parts = properties.split(" ");
            this.id = Integer.parseInt(parts[1]);
            x=Integer.parseInt(parts[2]);
            y=Integer.parseInt(parts[3]);
        }
        public double distanceToBuilding(Building a){
            return distance(this, a);
        }
    }
    static class LunarModule extends Building{

        LunarModule(String properties) {
            super(properties);
        }
        
    }


    public static double distance(Building b1, Building b2) {
        return Math.sqrt((b1.x-b2.x)*(b1.x-b2.x) + (b2.y - b2.y)*(b2.y - b2.y));
    }
    
    public static boolean pointOnSegment(Building A,Building B,Building C) {
        double epsilon = 0.0000001;
        return (-epsilon < (distance(B, A) + distance(A, C)) && distance(B, C) < epsilon);
    }
}

/*
 * import java.util.*;

class Player {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Keep track of used pod IDs
        Set<Integer> usedPodIds = new HashSet<>();
        int nextPodId = 42; // Start with the first pod ID at 42 (you can change this starting value)

        // Game loop
        while (true) {
            int resources = in.nextInt(); // total resources available for the month
            int numTravelRoutes = in.nextInt(); // number of existing routes
            List<Route> routes = new ArrayList<>(); // store routes information
            Set<String> existingRoutes = new HashSet<>(); // to track valid routes

            // Read existing routes
            for (int i = 0; i < numTravelRoutes; i++) {
                int buildingId1 = in.nextInt();
                int buildingId2 = in.nextInt();
                int capacity = in.nextInt();
                routes.add(new Route(buildingId1, buildingId2, capacity));
                existingRoutes.add(buildingId1 + "-" + buildingId2); // store as valid route
                existingRoutes.add(buildingId2 + "-" + buildingId1); // store reverse as well
            }

            int numPods = in.nextInt(); // number of transport pods
            if (in.hasNextLine()) {
                in.nextLine();
            }
            List<Pod> pods = new ArrayList<>(); // store pod routes
            for (int i = 0; i < numPods; i++) {
                String podProperties = in.nextLine();
                pods.add(new Pod(podProperties)); // parse pod data
                usedPodIds.add(pods.get(i).id); // Track IDs of existing pods
            }

            int numNewBuildings = in.nextInt(); // number of new buildings
            if (in.hasNextLine()) {
                in.nextLine();
            }
            List<Building> newBuildings = new ArrayList<>();
            for (int i = 0; i < numNewBuildings; i++) {
                String buildingProperties = in.nextLine();
                newBuildings.add(new Building(buildingProperties)); // parse building data
            }

            // We will build actions based on available resources
            StringBuilder actions = new StringBuilder();

            // 1. Create valid tubes between different buildings, if enough resources
            if (resources >= 100 && !newBuildings.isEmpty()) {
                for (Building newBuilding : newBuildings) {
                    for (int j = 1; j <= 2; j++) { // Assuming buildings 1 and 2 are standard connections
                        String routeKey = newBuilding.id + "-" + j;
                        if (!existingRoutes.contains(routeKey) && resources >= 100) {
                            actions.append("TUBE ").append(newBuilding.id).append(" ").append(j).append(";");
                            resources -= 100;
                            existingRoutes.add(routeKey);
                            existingRoutes.add(j + "-" + newBuilding.id); // Add reverse route
                        }
                    }
                }
            }

            // 2. If resources allow, create a pod on a valid route with a new unique ID
            if (resources >= 1000 && existingRoutes.contains("0-1")) {
                while (usedPodIds.contains(nextPodId)) {
                    nextPodId++; // Increment until we find an unused ID
                }
                actions.append("POD ").append(nextPodId).append(" 0 1;");
                resources -= 1000;
                usedPodIds.add(nextPodId); // Mark this pod ID as used
                nextPodId++; // Prepare the next unique pod ID
            }

            // 3. If enough resources, upgrade a tube
            if (resources >= 2500 && !routes.isEmpty()) { 
                for (Route route : routes) {
                    actions.append("UPGRADE ").append(route.building1).append(" ").append(route.building2).append(";");
                    resources -= 2500;
                    break; // Upgrade one route per turn
                }
            }

            // 4. If no valid action can be performed, WAIT
            if (actions.length() == 0) {
                actions.append("WAIT");
            }

            // Output the actions for this turn
            System.out.println(actions.toString().trim());
        }
    }

    // Class to represent a route between buildings
    static class Route {
        int building1, building2, capacity;

        Route(int building1, int building2, int capacity) {
            this.building1 = building1;
            this.building2 = building2;
            this.capacity = capacity;
        }
    }

    // Class to represent a pod's properties
    static class Pod {
        int id;
        String properties;

        Pod(String properties) {
            String[] parts = properties.split(" ");
            this.id = Integer.parseInt(parts[0]);
            this.properties = properties;
        }
    }

    // Class to represent a building and its properties
    static class Building {
        int id;
        String properties;

        Building(String properties) {
            String[] parts = properties.split(" ");
            this.id = Integer.parseInt(parts[0]);
            this.properties = properties;
        }
    }
}

 */




 /*
  * 
  */