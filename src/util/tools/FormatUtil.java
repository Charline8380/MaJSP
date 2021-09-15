package util.tools;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cette classe permet de faire la conversion de types différents en String <br/>
 * 
 * @author Administrateur
 *
 */
public class FormatUtil {

    /**
     * Format de la date
     * 
     */
    public static final String FORMAT_DATE = "dd/MM/yyyy";

    /**
     * Permet de convertir un entier en String
     * 
     * @param entier
     * @return String
     */
    public static String convertirEntierToString(final int entier) {
        return Integer.toString(entier);

    }

    /**
     * Permet de convertir une date en String
     * 
     * 
     * @param date
     * @return String
     */
    public static String convertirDateToString(final Date date) {
        final DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
        return dateFormat.format(date);
    }

    /**
     * Permet de convertir un string en double
     * 
     * @param mot
     * @return Double
     */
    public static Double convertirStringToDouble(final String mot) {
        return Double.parseDouble(ConversionUtil.convertStringCommaToDot(mot));
    }

    /**
     * Permet de convertir un Double en String
     * 
     * @param nombre
     * @return String
     */
    public static String convertirDoubleToString(final Double nombre) {
        final DecimalFormat df = new DecimalFormat("0.00");
        return df.format(nombre);
    }

    /**
     * Permet de convertir une String en Date
     * 
     * @param date
     * @return Date
     */
    public static Date convertirStringToDate(final String date) {
        if (!Tools.verifDate(date)) {
            return null;
        }

        try {
            final Date date1 = new SimpleDateFormat(FORMAT_DATE).parse(date);
            return date1;
        } catch (final ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
