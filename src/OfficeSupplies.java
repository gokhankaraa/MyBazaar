public abstract class OfficeSupplies extends Item {
    private String releaseDate;
    private String coverTitle;

    public OfficeSupplies(double price, String releaseDate, String coverTitle) {
        super(price);
        this.releaseDate = releaseDate;
        this.coverTitle = coverTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getCoverTitle() {
        return coverTitle;
    }
}
