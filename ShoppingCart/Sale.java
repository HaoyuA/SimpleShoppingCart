import java.util.Scanner;

public class Sale
{

    private ProductList productlist;
    private SaleTransaction transaction;

    public Sale()
    {

        productlist = new ProductList();
        transaction = new SaleTransaction();

    }

    public Sale(ProductList productlist, SaleTransaction transaction)
    {

        this.productlist = productlist;
        this.transaction = transaction;

    }

    public void setProductList(ProductList productlist)
    {
        this.productlist = productlist;
    }

    public ProductList getProductList()
    {
        return productlist;
    }

    public void setSaleTransaction(SaleTransaction transaction)
    {
        this.transaction = transaction;
    }

    public SaleTransaction getSaleTransaction()
    {
        return transaction;
    }

    public void displayMenu()
    {
        System.out.println("");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Welcome to the Simple Inventory Management System");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("");
        System.out.println("Please Select from the following options:");
        System.out.println("Press 1 to Register a Product for Sale");
        System.out.println("Press 2 to Buy a Product to the Cart");
        System.out.println("Press 3 to Remove a Product from the Cart");
        System.out.println("Press 4 to View all Available Products");
        System.out.println("Press 5 to Check out");
        System.out.println("Press 6 to Get Help");
        System.out.println("Press 7 to Exit");
        System.out.println("");
        System.out.print("Please Enter your Choice:");

    }
    public void Start()
    {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        String value = "";
        do 
        {
            displayMenu();
            value = scan.nextLine();
            if(value == null || value.trim().equals(""))
            {
                System.out.println("invalid option ,please input again");
                continue; 
            }
            option = Integer.parseInt(value);
            if(option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7  )
            {
                System.out.println("invalid ,please input again");
                continue;

            }
            switch(option)
            {
                case 1:
                Register(scan);
                break;
                case 2:
                Buy(scan);
                break;
                case 3:
                Remove(scan);
                break;
                case 4:
                displayProductlist();
                break;
                case 5:
                Checkout(scan);
                break;
                case 6:
                System.out.println("help");
                break;
            } 
        }while (option != 7);

    }

    public void Register(Scanner scan)
    {

        System.out.println("Register for a product:");
        if(productlist.isFull())
        {
            System.out.println("Cart is full");
            return;
        }
        System.out.print("Enter name:");
        String name = scan.nextLine();
        if(productlist.isExist(name))
        {
            System.out.println("Product is already added");
            return;
        }
        if(name.length() < 3 || name.length() > 25)
        {
            System.out.println("Name length error");
            return;
        }
        System.out.print("Enter desc:");
        String desc = scan.nextLine();
        if(desc.length() >50 || name.length() == 0)
        {
            System.out.println("Desc length error");
            return;
        }
        System.out.print("Enter price:");
        String priceString = scan.nextLine();
        Double price = Double.parseDouble(priceString);
        if(price < 0.0)
        {
            System.out.println("Price should be greater than 0");
            return;
        }
        RandomNumberGenerator num1 = new RandomNumberGenerator(0,10);
        RandomNumberGenerator num2 = new RandomNumberGenerator(1,5);
        int qtyOnHand = num1.getNumber();
        int minOrderQty = num2.getNumber();

        System.out.println("Product has been added");
        productlist.addProduct(name,desc,price,qtyOnHand,minOrderQty);
    }

    public void Buy(Scanner scan)
    {
        System.out.println("Please select from the following products which are avaliable:");
        System.out.println("Product list:");
        if(productlist.isEmpty())
        {
            System.out.println("Cart is empty");
            return;
        }

        if(transaction.isFull())
        {
            System.out.println("Cart is full");
            return;
        }
        productlist.display();
        System.out.print("Select Product ");
        productlist.getListLength();
        System.out.print(" to exit menu");
        System.out.println("Please enter selected product:");

        String stringi = scan.nextLine();
        int i = Integer.parseInt(stringi);
        if(productlist.Return(i))
        {
            return;
        }

        int x = productlist.getProduct(i).getQtyOnHand();
        int y = productlist.getProduct(i).getMinQty();
        if (y > x)
        {
            System.out.println("You can't buy this product because the quantity on hand is less than minimun quantity you should buy.");
            return;
        }
        transaction.addToCart(productlist.getProduct(i).getName(),productlist.getProduct(i).getDesc(),productlist.getProduct(i).getPrice(),productlist.getProduct(i).getQtyOnHand(),productlist.getProduct(i).getMinQty());
        System.out.println("Product has been added to cart.");
        transaction.updateTotalCost();

    }

    public void Remove(Scanner scan)
    {
        if(transaction.isEmpty())
        {
            System.out.print("Cart is empty ");
            return;
        }
        System.out.println("Please select from the following products which have been added to the cart:");

        System.out.println("Product list:");
        transaction.display();

        System.out.print("Select Product ");
        transaction.getListLength();
        System.out.print(" to exit menu");
        System.out.println("Please enter added item:");

        String stringi = scan.nextLine();
        int i = Integer.parseInt(stringi);
        if(transaction.Return(i))
        {
            return;
        }

        transaction.remove(i);
        System.out.println("Product has been removed");
        transaction.updateTotalCost();
    }

    public void Checkout(Scanner scan)
    {
        System.out.println("Check out");
        if(transaction.isEmpty())
        {
            System.out.print("Cart is empty");
            return;
        }
        productlist.checkout(transaction.getSaleTransaction());
        RandomNumberGenerator num1 = new RandomNumberGenerator(1000,9999);
        int salecode = num1.getNumber();
        System.out.println("Salecode : "+salecode);
        System.out.println("Thank you for your shopping");
        transaction = new SaleTransaction();
    }

    public void displayProductlist()
    {
        if(productlist.isEmpty())
        {
            System.out.print("Cart is empty");
            return;
        }
        productlist.display();
    }
}
