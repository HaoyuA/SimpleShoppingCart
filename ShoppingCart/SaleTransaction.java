

public class SaleTransaction
{
   
    private int saleCode;
    private Product[] items;
    private double totalCost;
    
    public SaleTransaction()
    {
        saleCode = 0;
        totalCost = 0.0;
        items = new Product[3];
    }
    public SaleTransaction(int saleCode,int totalCost,Product[] items)
    {
        this.saleCode = saleCode;
        this.totalCost= totalCost;
        this.items = items;
    }

    
    public void setSaleCode(int saleCode)
    {
     this.saleCode = saleCode;
    }
    public void setTotalCost(double totalCost)
    {
     this.totalCost = totalCost;
    }
    public void setSaleTransaction(Product[] items)
    {
     this.items = items;
    }
    public int getSaleCode()
    {
     return saleCode;
    }
     public double getTotalCost()
    {
     return totalCost;
    }
    public Product[] getSaleTransaction()
    {
     return items;
    }
    public void addToCart(String name,String desc,Double price, int qtyOnHand, int minOrderQty)
    {
       Product product = new Product(name,desc,price,qtyOnHand,minOrderQty);
        for(int i = 0;i < items.length; i++)
         {
             if(items[i] == null)
             {
               items[i] = product ;
               break;
                }
          }
         
    }
    public boolean isFull()
    {
      for (int i = 0; i < items.length; i++)
      {
          
          if(items[i] == null)
          {
            return false;
            }
      
      }
      return true;
    }
    public boolean isEmpty()
    {
      for (int i = 0; i < items.length; i++)
      {
          if(items[i] != null)
          {
            return false;
            }
           
      }
      return true;
   }
    public void updateTotalCost()
    {
     Double totalcost = 0.0;
     for(int i = 0; i < items.length; i++)
       {
        if(items[i] != null)
        {
         Product product = items[i];
         totalcost = totalcost + product.getPrice()*product.getMinQty();
         
        }
      }
      System.out.println("Totalcost:"+ totalcost);
    }
    public void remove(int index)
    {
     if ((index - 1) >= items.length)
     {
       System.out.println("Invalid option");
       }
     if (items[(index - 1)] == null)
     {
       System.out.println("No item in that place");
       }
     items[(index - 1)] = null;
     for (int i = (index - 1); i < items.length - 1; i++)
     {
        items[i] = items[i+1];
     
      }
     items[items.length-1] = null;
     
    }
    public void display()
    {
        
        for(int i = 0; i < items.length; i++)
        {
          if(items[i] != null)
         {
            System.out.println("Selected product:" + (i+1));
            items[i].display();
            System.out.println("" );
         }
        }
    }
    public void getListLength()
    {
        for(int i = 0;i < items.length; i++)
        {
         if(items[i] == null)
         {
           System.out.print(i+1); 
           break;
            }
        }
    }
    public boolean Return(int i)
    {
      
         if(items[i-1] == null)
         {
            
           return true ;
            }
         return false ;
     }
    
     
}


