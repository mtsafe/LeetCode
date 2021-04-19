package dayChall202103;

import java.util.*;

class UndergroundSystem {
    class Record {
        int id;
        Integer t;
        boolean checkIn;

        Record(int id, int t, boolean checkIn) {
            this.id = id;
            this.t = t;
            this.checkIn = checkIn;
        }
    }

    HashMap<String, List<Record>> hashIn;
    HashMap<String, List<Record>> hashOut;

    public UndergroundSystem() {
        hashIn = new HashMap<>();
        hashOut = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Record r = new Record(id, t, true);
        if (hashIn.containsKey(stationName))
            hashIn.get(stationName).add(r);
        else {
            List<Record> rList = new ArrayList<>();
            rList.add(r);
            hashIn.put(stationName, rList);
        }
    }

    public void checkOut(int id, String stationName, int t) {
        Record r = new Record(id, t, false);
        if (hashOut.containsKey(stationName))
            hashOut.get(stationName).add(r);
        else {
            List<Record> rList = new ArrayList<>();
            rList.add(r);
            hashOut.put(stationName, rList);
        }
    }

    private List<Record> mergeSort(List<Record> a, List<Record> b) {
        if (a == null || b == null) return null;
        List<Record> result = new ArrayList<>(a);
        result.addAll(b);
        result.sort((rA, rB) -> {
            int idSort = Integer.compare(rA.id, rB.id);
            if (idSort != 0)
                return idSort;
            return rA.t.compareTo(rB.t);
        });
        return result;
    }

    private List<Integer> parseTrips(List<Record> list) {
        List<Integer> trips = new ArrayList<>();
        int tIn = 0;
        boolean needCheckIn = true;
        for (Record r : list) {
            if (r.checkIn) {
                tIn = r.t;
                needCheckIn = false;
            } else if (!needCheckIn) {
                trips.add(tIn);
                trips.add(r.t);
                needCheckIn = true;
            }
        }
        return trips;
    }

    public double getAverageTime(String startStation, String endStation) {
        List<Record> rIn = hashIn.get(startStation);
        List<Record> rOut = hashOut.get(endStation);
        List<Record> rList = mergeSort(rIn, rOut);
        if (rList.size() == 0) return 0.0;
        List<Record> idList = new ArrayList<>();
        List<Integer> timeList = new ArrayList<>();
        int id = 0;
        for (Record r : rList) {
            if (id == r.id) {
                idList.add(r);
                continue;
            }
            timeList.addAll(parseTrips(idList));
            idList = new ArrayList<>();
            idList.add(r);
        }
        return 0.0;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

public class Day320_2021 {
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        double avgTime;

        // Example 1
        System.out.println("=== Example 1 ===");
        undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        avgTime = undergroundSystem.getAverageTime("Paradise", "Cambridge");       // return 14.00000. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        System.out.println("14.00000 == " + avgTime);
        avgTime = undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.00000. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.00000
        System.out.println("11.00000 == " + avgTime);
        undergroundSystem.checkIn(10, "Leyton", 24);
        avgTime = undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.00000
        System.out.println("11.00000 == " + avgTime);
        undergroundSystem.checkOut(10, "Waterloo", 38);
        avgTime = undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 12.00000
        System.out.println("12.00000 == " + avgTime);

        // Example 2
        System.out.println("=== Example 2 ===");
        undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8);
        avgTime = undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.00000
        System.out.println("5.00000 == " + avgTime);
        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16);
        avgTime = undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.50000
        System.out.println("5.50000 == " + avgTime);
        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30);
        avgTime = undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 6.66667
        System.out.println("6.66667 == " + avgTime);
    }
}
