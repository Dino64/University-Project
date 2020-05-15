package sample.Model;

import sample.DataBaseConsole.DBConnect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification {

    public static int verifyAccount(String email, String pass, String SSN,int accesID){
        int status;

        if(email.contentEquals("") || pass.contentEquals("")){
            status = 1;
        } else if (pass.length() > 15 || pass.length() < 4){
            status = 2;
        } else if (!validateEmail(email)){
            status = 4;
        } else if (!validateSSN(SSN)){
            status = 5;
        }
        else{
            if(DBConnect.getInstance().verifyAccount(email, pass, SSN)){
                status = 1;
            }else{
                status = 0;
            }
        }
        return status;
    }

    public static boolean validateEmail(String emailStr) {
        final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean validateSSN(String SSN){
        if (SSN == null){
            return true;
        }else{
            final Pattern SSN_REGEX = Pattern.compile("^[0-9]{4}\\-?[0-9]{2}\\-?[0-9]{2}\\-?[0-9]{4}$");
            Matcher matcher = SSN_REGEX.matcher(SSN);
            return matcher.find();
        }
    }
}


