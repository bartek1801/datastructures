package datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bartek on 08.08.2017.
 */
public class Book {

    private String title;
    private Person author;
    private Set<Genre> genres = new HashSet<>();

    public Book(String title, Person author, Set<Genre> genres) {
        if (title == null || author == null || genres.isEmpty())
            throw new IllegalArgumentException("All data required");
        this.title = title;
        this.author = author;
        this.genres.addAll(genres);
    }

    public boolean hasGenre(Genre genre){
        return genres.contains(genre);
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return author;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public static Set<Genre> fillGenreSet(Genre ... genres){
        Set<Genre> genreSet = new HashSet<>();
        for (Genre item : genres){
         genreSet.add(item);
        }
        return genreSet;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", genres=" + genres +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!title.equals(book.title)) return false;
        if (!author.equals(book.author)) return false;
        return genres.equals(book.genres);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + genres.hashCode();
        return result;
    }
}
