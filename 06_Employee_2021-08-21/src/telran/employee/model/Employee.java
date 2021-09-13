package telran.employee.model;

public abstract class Employee {
   // Нельзя создать объект абстрактного класса
    protected int id;
    protected String firstName;
    protected String lastName;
    protected double hours;  //protected - доступ и для наследников

    public Employee(int id, String firstName, String lastName, double hours) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "firstName= " + firstName + ", lastName= " + lastName + ", salary= " + calcSalary();
    }
    abstract public double calcSalary();
    //Абстрактные методы не требуют реализации в данном классе.
    // Они могут быть реализованы у наследников
}
