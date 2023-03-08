package Tools;

public class Provider {
    int vat;
    String name, taxAddress, contactPerson;
    Provider(){
        this.vat = 999999999;
        this.name = "NONDEFINED";
        this.taxAddress = "NA/NA";
        this.contactPerson = "NA/NA";
    }
    Provider(int VAT, String NAME, String TAXADDRESS, String CONTACTPERSON){
        try{
            setVat(VAT);
            setName(NAME);
            setTaxAddress(TAXADDRESS);
            setContactPerson(CONTACTPERSON);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    public void setVat(int vat) {
        if(vat < 0) throw new IllegalArgumentException("VAT must be positive");
        else this.vat = vat;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTaxAddress(String taxAddress) {
        if(taxAddress.length() < 5) throw new IllegalArgumentException("Tax address must be at least 5 characters long");
        else this.taxAddress = taxAddress;
    }
    public void setContactPerson(String contactPerson) {
        if(contactPerson.length() == 0 ) throw new IllegalArgumentException("Contact person must be at least 1 character long");
        else this.contactPerson = contactPerson;
    }
    public int getVat() {
        return vat;
    }
    public String getName() {
        return name;
    }
    public String getTaxAddress() {
        return taxAddress;
    }
    public String getContactPerson() {
        return contactPerson;
    }
    public void set(String[] data){
        try {
            this.setVat(Integer.parseInt(data[0]));
            this.setName(data[1]);
            this.setTaxAddress(data[2]);
            this.setContactPerson(data[3]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    public String toString(){
        return "VAT: "+ this.getVat()+ "|Name: "+ this.getName()+ "|Tax Address: "+ this.getTaxAddress()+ "|Contact Person: "+ this.getContactPerson()+"|";
    }
}
