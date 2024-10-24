package railwayreservationsystem;
import java.util.*;
public class RailwayReservationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem system = new ReservationSystem();

        while (true) {
            System.out.println("\n--- Railway Reservation System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Check Status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Coach Type (AC/Non-AC/Seater): ");
                    String coachType = scanner.next();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    system.bookTicket(coachType, name, age);
                }
                case 2 -> {
                    System.out.print("Enter Coach Type (AC/Non-AC/Seater): ");
                    String coachType = scanner.next();
                    System.out.print("Enter Passenger Name to Cancel: ");
                    String name = scanner.next();
                    system.cancelTicket(coachType, name);
                }
                case 3 -> {
                    System.out.print("Enter Coach Type (AC/Non-AC/Seater): ");
                    String coachType = scanner.next();
                    system.checkStatus(coachType);
                }
                case 4 -> {
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
