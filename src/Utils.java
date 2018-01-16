
public class Utils {
	
    public static Locale getLocale() {
        return Locale.US;
    }

    public static Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance(getLocale());
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        return calendar;
    }

    public static String convertDate(long dateInMilliseconds, String dateFormat) {
        return (new SimpleDateFormat(dateFormat, Locale.getDefault()).format(new Date(dateInMilliseconds)));
    }
}
