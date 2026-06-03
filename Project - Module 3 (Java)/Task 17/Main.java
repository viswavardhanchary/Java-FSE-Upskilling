class Car {
    String make;
    String model;
    int year;
     Car (String make , String model , int year) {
        this.make = make;
        this.model = model;
        this.year = year;
     }

     public void displayDetails() {
        System.out.println("Make : " + this.make);
        System.out.println("Model : " + this.model);
        System.out.println("Year : " + this.year);
     }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car("Audi" , "hezz 5.0" , 2025);
        c.displayDetails();
    }
}
