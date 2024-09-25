
class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Passenger extends Person {

    String seatNumber;
    String ticketNumber;

    public Passenger(String name, int age, String seatNumber, String ticketNumber) {
        super(name, age);
        this.seatNumber = seatNumber;
        this.ticketNumber = ticketNumber;
    }

    public void boardPlane() {
        System.out.println(name + " is boarding the plane.");
    }

    public void getOffPlane() {
        System.out.println(name + " is getting off the plane.");
    }
}

class FlightAttendant extends Person {

    String employeeID;

    public FlightAttendant(String name, int age, String employeeID) {
        super(name, age);
        this.employeeID = employeeID;
    }

    public void servePassengers() {
        System.out.println("Flight attendant " + name + " is serving passengers.");
    }

    public void handleEmergencies() {
        System.out.println(name + " is handling emergencies.");
    }
}

class Pilot extends Person {

    String licenseNumber;

    public Pilot(String name, int age, String licenseNumber) {
        super(name, age);
        this.licenseNumber = licenseNumber;
    }

    public void flyPlane() {
        System.out.println("Cpt." + name + " is flying the plane.");
    }

    public void landPlane() {
        System.out.println("Cpt." + name + " has landed the plane.");
    }
}

class Plane {

    String planeNumber;
    int capacity;
    int currentPassengers;
    Passenger[] passengers;

    public Plane(String planeNumber, int capacity) {
        this.planeNumber = planeNumber;
        this.capacity = capacity;
        this.passengers = new Passenger[capacity];
        this.currentPassengers = 0;
    }

    public void addPassenger(Passenger passenger) {
        if (currentPassengers < capacity) {
            passengers[currentPassengers] = passenger;
            currentPassengers++;
            System.out.println(passenger.name + " bought a plane ticket. " + passenger.name + " is added to the plane");
        } else {
            System.out.println("The plane is full.");
        }
    }

    public void removePassenger(Passenger passenger) {
        for (int i = 0; i < currentPassengers; i++) {
            if (passengers[i].ticketNumber.equals(passenger.ticketNumber)) {
                passengers[i] = passengers[currentPassengers - 1];
                passengers[currentPassengers - 1] = null;
                currentPassengers--;
                System.out.println(passenger.name + " removed from the plane.");
                return;
            }
        }
        System.out.println(passenger.name + " is not on the plane.");
    }
}

class Airport {

    String airportCode;
    String location;

    public Airport(String airportCode, String location) {
        this.airportCode = airportCode;
        this.location = location;
    }

    public void announceDeparture() {
        System.out.println("Departure from " + location + " has been announced.");
    }

    public void prepareForArrival() {
        System.out.println("Airport " + location + " is preparing for arrival.");
    }
}

class Ticket {

    String ticketNumber;
    double fareAmount;

    public Ticket(String ticketNumber, double fareAmount) {
        this.ticketNumber = ticketNumber;
        this.fareAmount = fareAmount;
    }

    public void validate() {
        System.out.println("Ticket " + ticketNumber + " has been validated.");
    }

    public double getFareAmount() {
        return fareAmount;
    }
}

class Route {

    String routeNumber;
    Airport departureAirport;
    Airport arrivalAirport;
    Airport[] stops;
    int stopCount;

    public Route(String routeNumber, Airport departureAirport, Airport arrivalAirport) {
        this.routeNumber = routeNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.stops = new Airport[10];
        this.stopCount = 0;
    }

    public void addStop(Airport airport) {
        if (stopCount < stops.length) {
            stops[stopCount] = airport;
            stopCount++;
            System.out.println("Plane stoped at " + airport.location);
        } else {
            System.out.println("Maximum number of stops reached.");
        }
    }

    public void removeStop(Airport airport) {
        for (int i = 0; i < stopCount; i++) {
            if (stops[i].airportCode.equals(airport.airportCode)) {
                stops[i] = stops[stopCount - 1];
                stops[stopCount - 1] = null;
                stopCount--;
                System.out.println("Stop removed from " + airport.location);
                return;
            }
        }
        System.out.println("Stop not found at " + airport.location);
    }
}

public class Airplane {

    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("Gabriel Benedicto", 69, "12A", "TK12345");
        Pilot pilot = new Pilot("James Clark Cautivar", 80, "LN67890");
        FlightAttendant attendant = new FlightAttendant("John Laurence Andica", 25, "EID98765");

        Plane plane = new Plane("PL123", 2);

        Airport departure = new Airport("ILO", "Iloilo");
        Airport arrival = new Airport("PPS", "Palawan");

        Route route = new Route("R123", departure, arrival);

        Ticket ticket = new Ticket("TK12345", 4062.00);

        plane.addPassenger(passenger1);

        ticket.validate();
        System.out.println("Ticket fare: Php " + ticket.getFareAmount());

        passenger1.boardPlane();
        pilot.flyPlane();
        attendant.servePassengers();

        pilot.landPlane();

        route.addStop(new Airport("PPS", "Palawan"));

        passenger1.getOffPlane();
        plane.removePassenger(passenger1);
    }
}
