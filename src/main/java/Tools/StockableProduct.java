package Tools;


import java.io.*;

public class StockableProduct extends Product{
    int numUnits, productID;
    public StockableProduct(){
        super();
        this.numUnits = 0;
        this.productID = 0;
    }
    public StockableProduct(String NAME, String MEASSUREMENTUNIT, char CATEGORY, Boolean ISCOUNTABLE){
        super(NAME, MEASSUREMENTUNIT, CATEGORY, ISCOUNTABLE);
    }
    public void setNumUnits(int numUnits) {
        if(numUnits < 0) throw new IllegalArgumentException("Number of units must be positive");
        else this.numUnits = numUnits;
    }
    public void setProductID(int productID) {
        if(productID < 0) throw new IllegalArgumentException("Product ID must be positive");
        else this.productID = productID;
    }
    public int getNumUnits() {
        return numUnits;
    }
    public int getProductID() {
        return productID;
    }
    public void set(String[] data){
        try {
            this.setName(data[0]);
            this.setMeassurementUnit(data[1]);
            this.setCategory(data[2].charAt(0));
            this.setCountable(Boolean.parseBoolean(data[3]));
            this.setNumUnits(Integer.parseInt(data[4]));
            this.setProductID(Integer.parseInt(data[5]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    public String toString(){
        return this.getName() + " " + this.getMeassurementUnit() + " " + this.getCategory() + " " + this.isCountable() + " " + this.getNumUnits() + " " + this.getProductID();
    }
    public void print(){
        System.out.println(this);
    }
    public static StockableProduct readFromFile(String file) {
        StockableProduct product = new StockableProduct();
        BufferedReader in = null;
        String line = null;
        if(file != null){
            try{
                in = new BufferedReader(new FileReader(file));
                line = in.readLine();
                String[] data = line.split(" ");
                product.set(data);
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
            finally {
                try {
                    if (in != null) in.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    System.exit(1);
                }
            }
        }
        return product;
    }
}
