package Book;

import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    Book(String title, int year, String... authors){
        this.title = title;
        this.year = year;
        this.authors = Arrays.asList(authors);
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }
}
