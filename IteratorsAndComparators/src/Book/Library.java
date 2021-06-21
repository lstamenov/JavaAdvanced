package Book;

import java.util.Iterator;

public class Library implements Iterable<Book>{
    private Book[] books;

    Library (Book... books){
        this.books = books;
    }

    public class LibIterator implements Iterator<Book>{
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < books.length;
        }

        @Override
        public Book next() {
            Book b =  books[counter];
            counter++;
            return b;
        }

    }
    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
