import java.util.List;

public class Book extends OfficeSupplies {
    private String publisher;
    private List<String> authors;
    private int numberOfPages;

    public Book(double price, String releaseDate, String coverTitle, String publisher, List<String> authors, int numberOfPages) {
        super(price, releaseDate, coverTitle);
        this.publisher = publisher;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Type: Book\n" +
                "Item ID: " + getId() + "\n" +
                "Price: " + getPrice() + " $\n" +
                "Release Date: " + getReleaseDate() + "\n" +
                "Title: " + getCoverTitle() + "\n" +
                "Publisher: " + publisher + "\n" +
                "Author: " + String.join(",", authors) + "\n" +
                "Page: " + numberOfPages + " pages";
    }
}
