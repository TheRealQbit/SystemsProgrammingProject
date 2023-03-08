package Tools;

import java.util.ArrayList;

public class ProductList {
    ArrayList<StockableProduct> list;
    ProductList(){
        list = new ArrayList<StockableProduct>();
    }
    public void getProduct(int index){
        list.get(index);
    }
    public void addProduct(StockableProduct product){
        list.add(product);
    }
    public void removeProduct(int index){
        list.remove(index);
    }
    public void setProduct(int index, StockableProduct product){
        list.set(index, product);
    }
    public int size(){
        return list.size();
    }
    public void set(String[] data){
        try {
            for (int i = 0; i < data.length; i++) {
                StockableProduct product = new StockableProduct();
                product.set(data[i].split(","));
                this.addProduct(product);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    public String toString(){
        return "ProductList [list=" + list + "]";
    }
}
