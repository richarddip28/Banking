package comricharddip28.httpsgithub.bankingapp;

/**
 * Created by Richard Dip on 4/16/2018.
 */

public class UserInformation {

    public String email, fname, lname, phone, unitnum, address;

    public UserInformation(String emailcon, String first, String last, String phonenum, String unit, String addr){

        this.email = emailcon;
        this.fname = first;
        this.lname = last;
        this.phone = phonenum;
        this.unitnum = unit;
        this.address = addr;
    }
}
