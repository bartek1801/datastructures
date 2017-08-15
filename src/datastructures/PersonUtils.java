package datastructures;

import java.util.*;

/**
 * Created by bartek on 06.08.2017.
 */
public class PersonUtils {

    public static int firstIndexOver20(List<Person> persons) {
        if (persons == null)
            throw new IllegalArgumentException();
        int index = 0;
        for (Person item : persons) {
            if (item.getAge() > 20)
                return index;
            index++;
        }
        return -1;
    }

    public static int firstIndexOver20Iterator(List<Person> persons) {
        for (ListIterator<Person> i = persons.listIterator(); i.hasNext(); ) {
            Person person = i.next();
            if (person.getAge() > 20)
                return i.previousIndex();
        }
        return -1;
    }

    public static void displaySortedPeople(Collection<Person> people) {
        List<Person> peopleList = new ArrayList<>(people);
        //peopleList.addAll(people);
        peopleList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int lastNameComparator = o1.getLastName().compareTo(o2.getLastName());
                if (lastNameComparator == 0) {
                    int firstNameComparator = o1.getLastName().compareTo(o2.getLastName());
                    if (firstNameComparator == 0) {
                        return o1.getAge().compareTo(o2.getAge());
                    } else
                        return firstNameComparator;
                } else
                    return lastNameComparator;

            }
        });

        Comparator<Person> otherComparator = new Comparator<Person>() {

            private static final int LAST_NAME_PRIORITY = 100;
            private static final int FIRST_NAME_PRIORITY = 10;
            private static final int AGE_PRIORITY = 1;

            @Override
            public int compare(Person o1, Person o2) {
                int lastNameComparator = (int) Math.signum(o1.getLastName().compareTo(o2.getLastName()));
                int firstNameComparator = (int) Math.signum(o1.getLastName().compareTo(o2.getLastName()));
                int ageComparator = (int) Math.signum(o1.getAge().compareTo(o2.getAge()));
                return lastNameComparator * LAST_NAME_PRIORITY + firstNameComparator * FIRST_NAME_PRIORITY + ageComparator * AGE_PRIORITY;
            }
        };

        for (Person item : peopleList) {
            System.out.println(item);
        }
    }

    public static List<Person> personsOver20SortedList(Set<Person> personsSet) {
        List<Person> newList = new ArrayList<>();

        for (Person item : personsSet) {
            if (item.getAge() > 20) {
                newList.add(item);
            }
        }
        newList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        return newList;
    }

    public static List<Person> personsOver20SortedListVer2(Set<Person> personsSet) {
        //druga wersja funkcji powyżej
        List<Person> newList = new LinkedList<>(personsSet);
        newList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });

        for (Iterator<Person> i = newList.iterator(); i.hasNext(); ) {
            if (i.next().getAge() <= 20)
                i.remove();
            else
                break;
            return newList;
        }

        return newList;
    }

    public static boolean containsPerson(Set<Person> people, String firstName, String lastName, Integer age) {
        return people.contains(new Person(firstName, lastName, age));
    }

    public static Map<Integer, Integer> ageMap(Collection<Person> people) {
        Map<Integer, Integer> m = new HashMap<>();
        for (Person item : people) {
            Integer currentCount = m.get(item.getAge());
            if (currentCount == null)
                m.put(item.getAge(), 1);
            else
                m.put(item.getAge(), currentCount + 1);
        }
        return m;

    }


    public static void main(String[] args) {
        Person p1 = new Person("Jan", "Nowak", 17);
        Person p2 = new Person("Janina", "Nowak", 22);
        Person p3 = new Person("John", "Doe", 30);
        Person p4 = new Person("Jan", "Nowak", 40);
        Person p5 = new Person("Jan", "Kowalski", 17);
        Person p6 = new Person("Karol", "Kwiatkowski", 22);

        System.out.println("========================================================");
        System.out.println("Funkcja 1");

        List<Person> people = new LinkedList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        System.out.println(firstIndexOver20(people));
        System.out.println(firstIndexOver20Iterator(people));

        System.out.println("========================================================");
        System.out.println("Funkcja 2");

        Set<Person> peopleSet = new HashSet<>();
        peopleSet.add(p1);
        peopleSet.add(p2);
        peopleSet.add(p3);
        peopleSet.add(p4);
        peopleSet.add(p5);
        peopleSet.add(p6);

        displaySortedPeople(peopleSet);
        System.out.println("========================================================");
        System.out.println("Funkcja 3");

        List<Person> personsOver20 = personsOver20SortedList(peopleSet);

        for (Person item : personsOver20) {
            System.out.println(item);
        }

        System.out.println("========================================================");
        System.out.println("Funkcja 4");

        System.out.println(containsPerson(peopleSet, "Jan", "Nowak", 40));
        System.out.println(containsPerson(peopleSet, "Jan", "Nowak", 50));

        System.out.println("========================================================");
        System.out.println("Funkcja 4");

        Map<Integer, Integer> map = ageMap(peopleSet);
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            System.out.print("{" + item.getKey() + ";" + item.getValue() + "}  ");
        }

    }

}
