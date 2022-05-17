package fr.jaroddeveloppement.mareu.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {


    public static String formatDate(String formatDate) throws ParseException {
        SimpleDateFormat spf=new SimpleDateFormat("MMM dd, yyyy");
        Date newDate=spf.parse(formatDate);
        spf= new SimpleDateFormat("dd/MM/yyyy");
        formatDate = spf.format(newDate);


        return formatDate;
    }
    public static String dateToDesplay(String formatDate) throws ParseException {
        SimpleDateFormat spf=new SimpleDateFormat("dd/MM/yyyy");
        Date newDate=spf.parse(formatDate);
        spf= new SimpleDateFormat("MMM dd, yyyy");
        formatDate = spf.format(newDate);


        return formatDate;
    }

}
