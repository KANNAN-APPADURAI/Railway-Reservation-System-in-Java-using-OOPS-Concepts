package railwayreservationsystem;
import java.util.*;

abstract class Coach {
	protected final int totalSeats = 60;
    protected final int waitingListLimit = 10;

    // Encapsulated lists for confirmed and waiting passengers
    protected final List<Passenger> bookedPassengers = new ArrayList<>();
    protected final List<Passenger> waitingList = new ArrayList<>();

    // Abstract method to be implemented by specific coach types
    public abstract String getCoachType();

    // Booking logic with Encapsulation
    public boolean bookPassenger(String name, int age) {
        if (bookedPassengers.size() < totalSeats) {
            bookedPassengers.add(new Passenger(name, age, "Confirmed"));
            System.out.println("Ticket confirmed for " + name);
            return true;
        } else if (waitingList.size() < waitingListLimit) {
            waitingList.add(new Passenger(name, age, "Waiting"));
            System.out.println("Added to waiting list: " + name);
            return true;
        }
        System.out.println("Booking failed: No seats or waiting slots available.");
        return false;
    }

    // Cancellation logic with automatic promotion from the waiting list
    public boolean cancelPassenger(String name) {
        Passenger passenger = findAndRemovePassenger(bookedPassengers, name);
        if (passenger != null) {
            System.out.println("Cancelled ticket for: " + name);
            promoteFromWaitingList();
            return true;
        }
        System.out.println("Passenger not found: " + name);
        return false;
    }

    // Promote the first passenger from the waiting list, if available
    protected void promoteFromWaitingList() {
        if (!waitingList.isEmpty()) {
            Passenger nextPassenger = waitingList.remove(0);
            nextPassenger.status = "Confirmed";
            bookedPassengers.add(nextPassenger);
            System.out.println("Promoted from waiting list: " + nextPassenger.name);
        }
    }

    // Find and remove passenger from a given list using Streams (for efficiency)
    protected Passenger findAndRemovePassenger(List<Passenger> list, String name) {
        return list.stream()
                .filter(p -> p.name.equals(name))
                .findFirst()
                .map(p -> {
                    list.remove(p);
                    return p;
                }).orElse(null);
    }

    // Display the current status of the coach
    public void printStatus() {
        System.out.println("\n--- " + getCoachType() + " Coach Status ---");
        System.out.println("Confirmed Passengers (" + bookedPassengers.size() + "/" + totalSeats + "):");
        bookedPassengers.forEach(System.out::println);

        System.out.println("\nWaiting List (" + waitingList.size() + "/" + waitingListLimit + "):");
        waitingList.forEach(System.out::println);
    }
}

