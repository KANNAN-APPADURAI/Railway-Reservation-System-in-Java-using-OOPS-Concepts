package railwayreservationsystem;

import java.util.*;
class ReservationSystem {
    private final Map<String, Coach> coaches = new HashMap<>();

    public ReservationSystem() {
        coaches.put("AC", new ACCoach());
        coaches.put("Non-AC", new NonACCoach());
        coaches.put("Seater", new SeaterCoach());
    }

    // Polymorphic call to book a ticket
    public void bookTicket(String coachType, String name, int age) {
        Coach coach = coaches.get(coachType);
        if (coach != null) {
            coach.bookPassenger(name, age);
        } else {
            System.out.println("Invalid coach type.");
        }
    }

    // Polymorphic call to cancel a ticket
    public void cancelTicket(String coachType, String name) {
        Coach coach = coaches.get(coachType);
        if (coach != null) {
            coach.cancelPassenger(name);
        } else {
            System.out.println("Invalid coach type.");
        }
    }

    // Polymorphic call to check status
    public void checkStatus(String coachType) {
        Coach coach = coaches.get(coachType);
        if (coach != null) {
            coach.printStatus();
        } else {
            System.out.println("Invalid coach type.");
        }
    }
}

