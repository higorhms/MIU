import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(1970, 1, 2);
        Date result = dateFromLocalDate(localDate);

        System.out.println(result.toString());
    }

    public static Date dateFromLocalDate(LocalDate localDate){
        int year = localDate.getYear();
        int month = localDate.getMonthValue() - 1;
        int dayOfMonth = localDate.getDayOfMonth();

        GregorianCalendar calendar = new GregorianCalendar(year, month, dayOfMonth);
        return calendar.getTime();
    }
}