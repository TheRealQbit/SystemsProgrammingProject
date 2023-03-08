package Tools;

public class Product {
    String name, meassurementUnit;
    char category;
    boolean isCountable;
    public Product(){
        this.name = "NONDEFINED";
        this.meassurementUnit = "NA/NA";
        this.category = 'N';
        this.isCountable = false;
    }
    public Product (String NAME, String MEASSUREMENTUNIT, char CATEGORY, Boolean ISCOUNTABLE){
        try {
            this.setName(NAME);
            this.setMeassurementUnit(MEASSUREMENTUNIT);
            this.setCategory(CATEGORY);
            this.setCountable(ISCOUNTABLE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMeassurementUnit(String meassurementUnit) {
        this.meassurementUnit = meassurementUnit;
    }
    public void setCountable(boolean isCountable) {
        this.isCountable = isCountable;
    }
    public void setCategory(char category) {
        if(category == 'f' || category == 's' || category == 'e' || category == 'm'){
            this.category = category;
        }
        else throw new IllegalArgumentException("Category must be 'f' for food, 's' for services, 'e' for entertainment or 'm' for miscellaneous");
    }
    public String getName() {
        return name;
    }
    public String getMeassurementUnit() {
        return meassurementUnit;
    }
    public boolean isCountable() {
        return isCountable;
    }
    public char getCategory() {
        return category;
    }
    public void set(String[] data){
        try {
            this.setName(data[0]);
            this.setMeassurementUnit(data[1]);
            this.setCategory(data[2].charAt(0));
            this.setCountable(Boolean.parseBoolean(data[3]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    public String toString(){
        return "Name: " + this.getName() + " | Meassurement Unit: " + this.getMeassurementUnit() + " | Category: " + this.getCategory() + " | Is Countable: " + this.isCountable();
    }
}

