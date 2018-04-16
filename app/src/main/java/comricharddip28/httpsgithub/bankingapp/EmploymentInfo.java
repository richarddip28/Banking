package comricharddip28.httpsgithub.bankingapp;

/**
 * Created by Richard Dip on 4/16/2018.
 */

public class EmploymentInfo {

    public String cname, civic, address, phone, title, salary;

    public EmploymentInfo(String company, String unit, String address1, String phone1, String job, String salary1){

        this.cname = company;
        this.civic = unit;
        this.address = address1;
        this.phone = phone1;
        this.title = job;
        this.salary = salary1;
    }
}
