package pl.maniaq.exception;

public class HumanNameWrongFormat extends Exception{
    public HumanNameWrongFormat() {
        super();
    }

    public HumanNameWrongFormat(String message) {
        super(message);
    }
}
