public class Event extends Task {
    public Event (String content) {
        super(content);
    }
    private String at;
    public Event(String content, String at){
        super(content);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
