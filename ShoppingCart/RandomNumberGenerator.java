import java.util.Random;

public class RandomNumberGenerator
{
    
    private int minimumValue;
    private int maximumValue;

    public RandomNumberGenerator()
    {
        
        minimumValue = 0;
        maximumValue = 0;
    }
    public RandomNumberGenerator(int minimumValue,int maximumValue)
    {
        
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }
    

   
    public void setminimumValue(int minimumValue)
    {
      this.minimumValue = minimumValue;
      
    }
    public void setmaximumValue(int maximumValue)
    {
      this.maximumValue = maximumValue;
      
    }
    public int getmaxmumValue()
    {
      return maximumValue;
      
    }
    public int getminimumValue()
    {
      return minimumValue;
      
    }
    public int getNumber()
    {
       return minimumValue + (int)(Math.random() *(maximumValue-minimumValue+1));   
        
    }
}
