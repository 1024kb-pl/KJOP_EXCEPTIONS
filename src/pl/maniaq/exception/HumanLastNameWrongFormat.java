package pl.maniaq.exception;

public class HumanLastNameWrongFormat extends Exception{
    public HumanLastNameWrongFormat() {
        super();
    }
    public HumanLastNameWrongFormat(String message) {
        super(message);
    }
}
