package basics;

public class DirectLink {

    private String from;
    private String to;
    private String type;

    public DirectLink(String fromPoint, String toPoint, String Type) {
        this.from = fromPoint;
        this.to = toPoint;
        this.type = Type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
