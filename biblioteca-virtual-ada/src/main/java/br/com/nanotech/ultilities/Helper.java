package br.com.nanotech.ultilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Helper {
    private static final String DATE_PATTERN = "dd/MM/yyyy";

    public static boolean isDataValida(String data) {
        if (data == null) return false;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        sdf.setLenient(false);
        try {
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}

