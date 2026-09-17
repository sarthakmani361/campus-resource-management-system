package campus;

import java.time.*;
import java.time.format.DateTimeParseException;

public final class InputValidator {
    private InputValidator(){}
    public static String required(String s) {
        if(s==null || s.trim().isEmpty()) throw new IllegalArgumentException("Value cannot be empty.");
        return s.trim();
    }
    public static LocalDate date(String s) {
        try { return LocalDate.parse(required(s)); }
        catch(DateTimeParseException e){ throw new IllegalArgumentException("Date must be YYYY-MM-DD."); }
    }
    public static LocalTime time(String s) {
        try { return LocalTime.parse(required(s)); }
        catch(DateTimeParseException e){ throw new IllegalArgumentException("Time must be HH:MM."); }
    }
}
