package Tools;

public class Order {
    int orderID;
    ProductList productList;
    Person person;
    Provider provider;
    Order(){
        this.orderID = 0;
        this.productList = new ProductList();
        this.person = new Person();
    }
    Order(int ORDERID, Provider PROVIDER, ProductList PRODUCTLIST, Person PERSON){
        try{
            setOrderID(ORDERID);
            setProvider(PROVIDER);
            setProductList(PRODUCTLIST);
            setPerson(PERSON);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    public void setOrderID(int orderID) {
        if(orderID < 0) throw new IllegalArgumentException("Order ID must be positive");
        else this.orderID = orderID;
    }
    public void setProvider(Provider provider) {
        if(provider == null) throw new IllegalArgumentException("Provider must be defined");
        else provider = provider;
    }
    public void setProductList(ProductList productList) {
        if(productList == null) throw new IllegalArgumentException("Product list must be defined");
        else this.productList = productList;
    }
    public void setPerson(Person person) {
        if(person == null) throw new IllegalArgumentException("Person must be defined");
        else this.person = person;
    }
    public int getOrderID() {
        return orderID;
    }
    public Provider getProvider() {
        return provider;
    }
    public ProductList getProductList() {
        return productList;
    }
    public Person getPerson() {
        return person;
    }
    /*
    public void set(String[] orderData) {
        try {
            setOrderID(Integer.parseInt(orderData[0]));
            setProvider(new Provider(orderData[1]));
            setProductList(new ProductList(orderData[2]));
            setPerson(new Person(orderData[3]));
        } catch (IllegalArgumentException pe) {
            pe.printStackTrace();
            System.exit(1);
        }
    }

     */
    public String toString() {
        return orderID + "|" + provider + "|" + productList + "|" + person;
    }
}
