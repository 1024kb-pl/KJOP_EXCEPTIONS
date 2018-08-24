package pl.maniaq.validator;

import pl.maniaq.exception.HumanLastNameWrongFormat;
import pl.maniaq.exception.HumanNameWrongFormat;

public class HumanValidator {

    public static boolean isHumanNameCorrect(String name) throws HumanNameWrongFormat {
        if (name.length() < 4) {
            throw new HumanNameWrongFormat();
        }
        return true;
    }

    public static boolean isHumanLastNameCorrect(String name) throws HumanLastNameWrongFormat {
        if (name.length() < 6) {
            throw new HumanLastNameWrongFormat();
        }
        return true;
    }
}
