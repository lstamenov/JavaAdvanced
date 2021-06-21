package ComparableBook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public class BookComparator implements Comparator<Book>{

        @Override
        public int compare(Book first, Book second) {
            if (first.getTitle().compareTo(second.getTitle()) == 0){
                if (first.getYear() > second.getYear()){
                    return 1;
                }else {
                    return -1;
                }
            }else {
                return first.getTitle().compareTo(second.getTitle());
            }
        }
    }

    Book(String title, int year, String... authors){
        this.title = title;
        this.year = year;
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Book other) {
        if (this.title.compareTo(other.getTitle()) > 0){
            return 1;
        }else if (this.title.compareTo(other.getTitle()) < 0){
            return -1;
        }else {
            if (this.year > other.getYear()){
                return 1;
            }else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s", getTitle());
    }
}
