package comricharddip28.httpsgithub.bankingapp;

/**
 * Created by Richard Dip on 4/16/2018.
 */

public class BeneficiaryInfo {

    public String fname, lname, phone, civic, address;

    public BeneficiaryInfo(String first, String last, String phonenum, String unit, String addr){

        this.fname = first;
        this.lname = last;
        this.phone = phonenum;
        this.civic = unit;
        this.address = addr;
    }

}
