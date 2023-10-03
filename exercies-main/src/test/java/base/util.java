package base;
import java.text.SimpleDateFormat;
import java.util.Date;

public class util {
	public static String generateCurrentDateAndTime() {
        return new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date());
    }
}
