import java.util.Scanner;

public class Product
{
    
    private String name;
    private String desc;
    private Double price;
    private int qtyOnHand;
    private int minOrderQty;

    
    public Product()
    {
       name = "";
       desc = "";
       price = 0.0;
       qtyOnHand = 0;
       minOrderQty = 0;
    }
    public Product(String name, String desc, Double price,int qtyOnHand,int minOrderQty)
    {
        
        this.name = name;
        this.desc = desc;
        this.price = price; 
        this.qtyOnHand = qtyOnHand;
        this.minOrderQty = minOrderQty;
        
    }
    
    public void setName(String name)
    {
        this.name = name;       
    }
    public String getName()
    {
        return name;
    }
    public void setDesc(String desc)
    {           
        this.desc = desc;
    }
    public String getDesc()
    {   
        return desc;
    }
    public void setPrice(Double price)
    {        
        this.price = price;
    }
    public Double getPrice()
    {
        return price;
    }
    public void setMinQty(int minOrderQty)
    {
        this.minOrderQty = minOrderQty;
    }
    public int getMinQty()
    {
        return minOrderQty;
    }
    public void setQtyOnHand(int qtyOnHand)
    {
        this.qtyOnHand = qtyOnHand;
    }
    public int getQtyOnHand()
    {
        return qtyOnHand;
    }
    public void display()
    {
          System.out.println("Name:" + name);
          System.out.println("Description:" + desc);
          System.out.println("Price:" + price);
          System.out.println("Quantity:" + qtyOnHand);
          System.out.println("Min Order Quantity:" + minOrderQty);
        }
    }
