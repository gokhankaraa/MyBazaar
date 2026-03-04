import java.util.Date;

public class Campaign {
    private Date startDate;
    private Date endDate;
    private String itemType;
    private double discountRate;

    public Campaign(Date startDate, Date endDate, String itemType, double discountRate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.itemType = itemType;
        this.discountRate = discountRate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getItemType() {
        return itemType;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
