package ongcphonebook.com.ongctelephone;

/**
 * Created by admin on 23-Jun-17.
 */

public class WorldPopulation {
    private String City;
    private String Designation;//
    private String Mobi;//
    private String Name;//
    private String OffTel;
    private String Office;
    private String SubOffice;
    private String cpf;//
    private String location;//

    public WorldPopulation() {
        //needed for firebase
    }

    public WorldPopulation(String location, String Name, String Designation, String cpf, String OffTel, String Mobi) {
        this.location = location;
        //    this.Office = string3;
        //  this.SubOffice = string4;
        this.Name = Name;
        this.Designation = Designation;
        this.cpf = cpf;
        this.OffTel = OffTel;
        this.Mobi = Mobi;
        //     this.City = string10;

    }
   /* public String getCity()
    {
        return this.City;
    }
*/

    public String getDesignation() {
        return this.Designation;
    }

    public String getLocation() {
        return this.location;
    }

    public String getMobi() {
        return this.Mobi;
    }

    public String getName() {
        return this.Name;
    }

    public String getOffTel() {
        return this.OffTel;
    }
/*    public String getOffice()
    {
        return this.Office;
    }*/
  /*  public  String getSubOffice()
    {
        return this.SubOffice;
    }*/

    public String getCpf() {
        return this.cpf;
    }


}
