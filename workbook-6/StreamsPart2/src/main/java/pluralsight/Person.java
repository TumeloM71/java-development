package pluralsight;

public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getFullName(){ return firstName+" "+lastName;}

    @Override
    public int compareTo(Person o) {

        if (this.getLastName().compareTo(o.getLastName()) != 0)
            return this.getLastName().compareTo(o.getLastName());

        if (this.getFirstName().compareTo(o.getFirstName()) != 0)
            return this.getFirstName().compareTo(o.getFirstName());

        return Integer.compare(this.age,o.getAge());
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " " + getAge();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
