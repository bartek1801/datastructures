package datastructures;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by bartek on 08.08.2017.
 */
public class BookCollections {

    // zwraca książki z kolekcji books które zostały napisane przez zadanego autora
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByAuthor(Collection<Book> books, Person author) {
        Collection<Book> newBooks = new LinkedList<>();

        for (Book item : books) {
            if (item.getAuthor().equals(author))
                newBooks.add(item);
        }
        return newBooks;
    }

    // zwraca książki z kolekcji books których tytuł zaczyna się od zadanej frazy,
    // wielkość liter nie ma znaczenia
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByTitle(Collection<Book> books, String phrase) {
        Collection<Book> newBooks = new LinkedList<>();
        String newPhrase = phrase.trim().toLowerCase();
        for (Book item : books) {
            if (item.getTitle().toLowerCase().contains(newPhrase))
                newBooks.add(item);
        }
        return newBooks;
    }

    // zwraca książki z kolekcji books które należą do wszystkich zadanych gatunków
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByGenres(Collection<Book> books, Set<Genre> genres) {
        Collection<Book> genresBooks = new LinkedList<>();
        for (Book item : books) {
            if (genres.containsAll(item.getGenres()))
                genresBooks.add(item);
        }
        return genresBooks;
    }

    // zwraca posortowaną rosnąco po tytule listę książek stworzoną z kolekcji books
    // NIE modyfikuje kolekcji books!
    public static List<Book> sortByTitle(Collection<Book> books) {
        List<Book> newList = new ArrayList<>(books);

        newList.sort(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });
        return newList;
    }

    // zwraca posortowaną rosnąco listę książek z kolekcji books po nazwisku, imieniu autora i
    // po tytule
    // NIE modyfikuje kolekcji books!
    public static List<Book> sortByAuthorAndTitle(Collection<Book> books) {
        List<Book> newList = new ArrayList<>(books);

        newList.sort(new Comparator<Book>() {
            private static final int LAST_NAME_PRIORITY = 100;
            private static final int FIRST_NAME_PRIORITY = 10;
            private static final int TITLE_PRIORITY = 1;

            @Override
            public int compare(Book b1, Book b2) {
                int lastNameComparator = b1.getAuthor().getLastName().compareTo(b2.getAuthor().getLastName());
                int firstNameComparator = b1.getAuthor().getFirstName().compareTo(b2.getAuthor().getFirstName());
                int titleComparator = b1.getTitle().compareTo(b2.getTitle());
                return lastNameComparator * LAST_NAME_PRIORITY + firstNameComparator * FIRST_NAME_PRIORITY
                        + titleComparator * TITLE_PRIORITY;
            }
        });

        return newList;
    }

    //tworzy mapę książek należących do poszczególnych gatunków, jeśli ksiżąka należy
    //do wielu gatunków, powinna wiele razy występować na mapie
    public static Map<Genre, Collection<Book>> genresMap(Collection<Book> books) {
        Map<Genre, Collection<Book>> genresBooksMap = new HashMap<>();
        Collection<Book> booksOfGenre;
        for (Book bookItem : books){
            for (Genre genreItem : bookItem.getGenres()){
                booksOfGenre = genresBooksMap.get(genreItem);
                if (booksOfGenre == null){
                    booksOfGenre = new LinkedList<>();
                    genresBooksMap.put(genreItem, booksOfGenre);
                }
                booksOfGenre.add(bookItem);
            }
        }
        return genresBooksMap;
    }

    //tworzy mapę książek należących napisanych przez poszczególnych autorów
    public static Map<Person, Collection<Book>> authorsMap(Collection<Book> books) {
        Map<Person, Collection<Book>> mapOfBooks = new HashMap<>();
        Collection<Book> booksOfAuthor;
        for (Book item : books){
            booksOfAuthor =  mapOfBooks.get(item.getAuthor());
            if (booksOfAuthor == null) {
                booksOfAuthor = new LinkedList<>();
                mapOfBooks.put(item.getAuthor(), booksOfAuthor);
            }
            booksOfAuthor.add(item);
        }
        return mapOfBooks;
    }

    //tworzy mapę z ilością książek napisanych przez zadanego autora
    public static Map<Person, Integer> authorsBookCountMap(Collection<Book> books) {
        Map<Person, Integer> booksCount = new HashMap<>();

        for (Book item : books) {
            Integer currentCount = booksCount.get(item.getAuthor());
            if (currentCount == null)
                booksCount.put(item.getAuthor(), 1);
            else
                booksCount.put(item.getAuthor(), currentCount + 1);
        }
        return booksCount;
    }

    public static Map<Genre, Integer> genresBookCountMap(Collection<Book> books){
       /* Map<Genre, Integer> coutMap = new HashMap<>();
        for (Book item : books){
            Integer currentCount = coutMap.get(item.getGenres());
            if (currentCount == null){
                coutMap.put(item.getGenres(), 1)
            }
        }*/

        return null;
    }

    // zwraca liczbę książek których autorem jest auhtor
    public static int booksCount(Collection<Book> books, Person author) {
        int booksCounter = 0;
        for (Book item : books) {
            if (item.getAuthor().equals(author))
                booksCounter++;
        }
        return booksCounter;
    }

    // zwraca liczbę książek z danego gatunku
    public static int booksCount(Collection<Book> books, Genre genre) {
        int counter = 0;
        for (Book item : books) {
            if (item.hasGenre(genre))
                counter++;
        }
        return counter;
    }


    // zwraca autora który napisał najwięcej książek
    // ? co w przypadku autorów z taką smą liczba książek
    public static Person bestAuthor(Collection<Book> books) {
        Map<Person, Integer> m = authorsBookCountMap(books);
        int tmp = 0;
        Person tmpAuthor = null;
        for (Map.Entry<Person, Integer> item : m.entrySet()) {
            if (tmp < item.getValue()) {
                tmp = item.getValue();
                tmpAuthor = item.getKey();
            }
        }
        return tmpAuthor;
    }

    // zwraca gatunek który ma najwięcej książek
    public Genre mostPopularGenre(Collection<Book> books) {


        return null;
    }


    public static void main(String[] args) {
        Set<Genre> otherGenres = new HashSet<>();

        Person martin = new Person("George R.R.", "Martin", 68);
        Person puzo = new Person("Mario", "Puzo", 70);
        Person sienkiewicz = new Person("Henryk", "Sienkiewicz", 80);

        otherGenres.add(Genre.FANTASY);
        Book b1 = new Book("A Game of throne", martin, otherGenres);
        otherGenres.remove(Genre.FANTASY);
        otherGenres.add(Genre.DRAMA);
        Book b2 = new Book("A Family Corleone", puzo, otherGenres);
        otherGenres.remove(Genre.DRAMA);
        otherGenres.add(Genre.FANTASY);
        Book b3 = new Book("A Clash of Kings", martin, otherGenres);
        Book b10 = new Book("A Game ...........", martin, otherGenres);
        otherGenres.remove(Genre.FANTASY);
        otherGenres.add(Genre.DRAMA);
        Book b4 = new Book("God father", puzo, otherGenres);
        otherGenres.remove(Genre.DRAMA);
        otherGenres.add(Genre.FANTASY);
        Book b5 = new Book("A Storm of Swords", martin, otherGenres);
        otherGenres.remove(Genre.FANTASY);
        otherGenres.add(Genre.HISTORICAL);
        otherGenres.add(Genre.REALISTIC);
        Book b6 = new Book("Ogniem i mieczem", sienkiewicz, otherGenres);
        Book b7 = new Book("Potop", sienkiewicz, otherGenres);
        Book b8 = new Book("Pan Wołodyjowski", sienkiewicz, otherGenres);
        Book b9 = new Book("Krzyżacy", sienkiewicz, otherGenres);


        Collection<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
        books.add(b8);
        books.add(b9);
        books.add(b10);

        System.out.println("=================findByAuthor================");

        Collection<Book> authorsBooks = findByAuthor(books, martin);
        for (Book item : authorsBooks) {
            System.out.println(item.toString());
        }

        System.out.println("=================findByTitle================");

        Collection<Book> booksFindByTitle = findByTitle(books, "a Game");
        for (Book item : booksFindByTitle) {
            System.out.println(item.toString());
        }

        System.out.println("=================findByGenre================");

        Set<Genre> genresToFind = new HashSet<>();
        genresToFind.add(Genre.HISTORICAL);
        genresToFind.add(Genre.REALISTIC);
        Collection<Book> booksFindByGenres = findByGenres(books, genresToFind);
        for (Book item : booksFindByGenres) {
            System.out.println(item.toString());
        }


        System.out.println("================sortByTitle=================");
        List<Book> booksSortedByTitle = sortByTitle(books);

        for (Book item : booksSortedByTitle) {
            System.out.println(item.toString());
        }

        System.out.println("=============sortByAuthorAndTitle====================");
        List<Book> sortedBooks = sortByAuthorAndTitle(books);

        for (Book item : sortedBooks) {
            System.out.println(item.toString());
        }

        System.out.println("===============genresMap==================");
        Map<Genre, Collection<Book>> genresMapOfBooks = genresMap(books);

        for (Map.Entry<Genre, Collection<Book>> item : genresMapOfBooks.entrySet()){
            System.out.println("Genre -> " + item.getKey().toString());
            System.out.println("Book -> " + item.getValue().toString());
        }

        System.out.println("===============authorsMap==================");
        Map<Person, Collection<Book>> mapOfAuthors = authorsMap(books);

        for (Map.Entry<Person, Collection<Book>> item : mapOfAuthors.entrySet()){
            System.out.println("Author: " + item.getKey().toString());
            System.out.println( "Book" + item.getValue().toString());
        }

        System.out.println("================authorsBookCountMap=================");
        Map<Person, Integer> booksMap = authorsBookCountMap(books);

        for (Map.Entry<Person, Integer> item : booksMap.entrySet()) {
            System.out.println("Author: " + item.getKey().getFirstName() + " " + item.getKey().getLastName() +
                    " - count of books: " + item.getValue());
        }

        System.out.println("===============booksCount==================");
        System.out.println(martin.getFirstName() + " " + martin.getLastName() + " - count of books: " + booksCount(books, martin));
        System.out.println(puzo.getFirstName() + " " + puzo.getLastName() + " - count of books: " + booksCount(books, puzo));
        System.out.println(sienkiewicz.getFirstName() + " " + sienkiewicz.getLastName() + " - count of books: " + booksCount(books, sienkiewicz));


        System.out.println("===============booksCount-genre==================");
        System.out.println("Count of FANTASY books is: " + booksCount(books, Genre.FANTASY));

        System.out.println("===============bestAuthor==================");
        System.out.println("Best Author is: " + bestAuthor(books));

    }

}
