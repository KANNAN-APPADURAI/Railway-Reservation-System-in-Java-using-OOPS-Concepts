package railwayreservationsystem;

class Passenger {
    String name;
    int age;
    String status; // "Confirmed" or "Waiting"

    public Passenger(String name, int age, String status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Status: " + status;
    }
}
