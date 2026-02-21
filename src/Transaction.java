import java.util.Date;

public class Transaction {

    private String type;
    private String details;
    private Date timestamp;

    public Transaction(String type, String details) {
        this.type = type;
        this.details = details;
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
        return type + ": " + details + " at " + timestamp;
    }
}
