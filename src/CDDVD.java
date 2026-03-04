import java.util.List;

public class CDDVD extends OfficeSupplies {
    private String composer;
    private List<String> songs;

    public CDDVD(double price, String releaseDate, String coverTitle, String composer, List<String> songs) {
        super(price, releaseDate, coverTitle);
        this.composer = composer;
        this.songs = songs;
    }

    public String getComposer() {
        return composer;
    }

    public List<String> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return "Type: CDDVD\n" +
                "Item ID: " + getId() + "\n" +
                "Price: " + getPrice() + " $\n" +
                "Release Date: " + getReleaseDate() + "\n" +
                "Title: " + getCoverTitle() + "\n" +
                "Composer: " + composer + "\n" +
                "Songs: " + String.join(",", songs);
    }
}
