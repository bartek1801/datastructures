package datastructures;

/**
 * Created by bartek on 05.08.2017.
 */
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;

    public Person(String firstName, String lastName, Integer age) {
        if (firstName == null || lastName == null || age == null)
            throw  new IllegalArgumentException();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }



   /* public boolean equals(Object other) {
        if (!(other instanceof Person))
            return false;
        Person otherPerson = (Person) other;
        return otherPerson != null &&
                firstName .equals(otherPerson.firstName) &&
                lastName.equals(otherPerson.lastName) &&
                age.equals(otherPerson.age) &&
                ((gender == null && otherPerson.gender == null) ||
                         (gender != null && gender.equals(otherPerson.gender)));
    }*/

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;
        if (!age.equals(person.age)) return false;
        return gender == person.gender;
    }*/

  /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;
        if (!age.equals(person.age)) return false;
        return gender == person.gender;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }



    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;
        if (age != null ? !age.equals(person.age) : person.age != null) return false;
        return gender == person.gender;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }




   /* @Override
    public int compareTo(Person o) {
        return lastName.compareTo(o.lastName);
    }*/
}
