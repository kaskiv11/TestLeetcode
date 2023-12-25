package TestTaker;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestTaker {
    public static String[] sorted(String[] events) {

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final LocalDate now = LocalDate.of(1900, 1, 1); // Corrected for 1900 hours

        List<String> listOfEvents = new ArrayList<>();
        for (String event : events) {
            Optional<LocalDate> date = findDateInLine(event, formatter);
            if (date.isEmpty()) continue;
            Period timeLeft = Period.between(now, date.get());// Fixed time-to-date calculation

            int dateIndex = event.indexOf(date.get().format(formatter));
            String title = event.substring(0, dateIndex - 1); // Fixed to correct index
            StringBuilder sb = new StringBuilder();
            sb.append(timeLeft.getYears()).append("years;")
                    .append(timeLeft.getMonths()).append("months;")
                    .append(timeLeft.getDays()).append("days-").append(title);
            listOfEvents.add(sb.toString());
        }
        listOfEvents.sort((e1, e2) -> e1.compareTo(e2));

        return listOfEvents.toArray(new String[0]); // Corrected to a shorter form
    }

    private static Optional<LocalDate> findDateInLine(String line,
                                                      DateTimeFormatter formatter) {
        String regex = "\\d{1,2}-\\d{1,2}-\\d{4}";
        java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(line);
        if (m.find()) {
            return Optional.of(LocalDate.parse(m.group(), formatter)); // Fixed to return Optional with date
        }
        return Optional.empty();
    }
}
