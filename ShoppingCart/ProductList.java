

public class ProductList
{
    
    private Product[] products;

    
    public ProductList()
    {
        
        products = new Product[5];
    }
    public ProductList(Product [] products)
    {
        
        this.products = products;
    }

   
     public void setProductList(Product[] products)
    {
     this.products = products;
    }
    public Product[] getProductList()
    {
     return products;
    }
    public boolean isFull()
    {
      for (int i = 0; i < products.length; i++)
      {
          
          if(products[i] == null)
          {
            return false;
            }
      
      }
      return true;
    }
    public boolean isEmpty()
    {
      for(int i = 0 ; i < products.length; i++)
      {
       if(products[i] != null)
       {
        return false;
        
        } 
        }
      return true;
   }
    public boolean isExist(String name)
    {
      for (int i = 0; i < products.length; i++)
      {
          if(products[i] != null)
          {
            String existname = products[i].getName();
            if(existname.equals(name))
            {
             return true;
            }
           
        }
      
     }
     return false;
    }
    public void addProduct(String name,String desc,Double price, int qtyOnHand, int minOrderQty)
    {
        Product product = new Product(name,desc,price,qtyOnHand,minOrderQty);
        for(int i = 0;i < products.length; i++)
         {
             if(products[i] == null)
             {
               products[i] = product ;
               break;
                }
          }
         
    }
    public void display()
    {
     
       for(int i = 0;i < products.length; i++)
      {
        if(products[i] != null)
        {
          System.out.println("Product:"+ (i+1));
          products[i].display();
          System.out.println("");
        }
        }
    }
    public Product getProduct(int i)
    {
      if(i > products.length)
      {
        System.out.println("You can't choose a invalid option. return to the main menu");
        return null;
        }
      if(products[i-1] == null )
      {
        System.out.println("The product in this position is not avaliable. return to the main menu");
        return null;

        }
    
      return products[i-1];
    }
    public Product getProductByName(String name)
    {
        for(int i = 0;i < products.length; i++)
       {
         if(products[i] != null)
        {
         if(products[i].getName().equals(name))
         {
           return products[i];
            }
        }
       }
        return null;
    }
    public void checkout(Product[] prod)
    
    {
     double totalcost = 0.0;
     for(int i = 0; i < prod.length; i++)
     {
      if(prod[i] != null)
       {
         Product p = getProductByName(prod[i].getName());
       
         if(p.getMinQty() > p.getQtyOnHand())
        {
          p.display(); 
          System.out.println("Can not be ordered as quantity on hand is less than minimum order quantity");
          continue;
        }
        
         
        p.setQtyOnHand(p.getQtyOnHand() - p.getMinQty());
        totalcost +=  p.getPrice()*p.getMinQty();
        
        }
     }
      
      System.out.println("Totalcost:"+totalcost);
     }
    public boolean Return(int i)
    {
      
         if(products[i-1] == null)
         {
            
           return true ;
            }
         return false ;
     }
    public void getListLength()
    {
      for(int i = 0;i < products.length; i++)
        {
         if(products[i] == null)
         {
           System.out.print(i+1); 
           break;
            }
        }
    }
}
