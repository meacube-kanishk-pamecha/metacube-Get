import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
       // Current Cart  using oops 
        int j = 0;
        int qty = 0;
        Cart m = new Cart();
        Scanner Sc = new Scanner(System.in);
        HashMap<Integer, Item> market = new HashMap<>();
        Item a = new Item("apple", "Kashmiri apple", 100);
        Item b = new Item("banana", "banana", 500);
        Item c = new Item("box", "box", 1040);

        market.put(a.getItemId(), a);
        market.put(b.getItemId(), b);
        market.put(c.getItemId(), c);

        
        while (j < 1) {
            System.out.println("press \n 1 : addtoCart \n 2 : displayQty \n 3 : update quantity \n 4 : display Bill \n 5 : Delete \n 6 : To End Loop");
            int num = Sc.nextInt();
            Item curr = a;
            if (num != 4) {
                System.out.println("press  \n 1 : apple \n 2 : banana \n 3 : box");
                int xID = Sc.nextInt();
                curr = market.get(xID);
                if (num == 1 || num == 3) {
                    System.out.println("Number of Quantity");
                    qty = Sc.nextInt();

                }

            } 
            // Switch Case 
            switch (num) {
                case 1:
                    m.addToCart(curr, qty);
                    break;
                case 2:
                    System.out.println(" Quantity is :"+m.displayQty(curr));
                    break;
                case 3:
                    m.updateQty(curr, qty);
                    break;
                case 4:
                    System.out.println(m.display());
                    break;
                case 5:
                    m.deleteItem(curr);
                    break;
                default:
                    j++;
            }

        }
        Sc.close();
    }
   static class Item 
   {
     private static  int id =1;
    private int itemId;
    private String name;
   private String description;
   private Integer price;
	Item( String a , String d , int p)
	{ 
 	  this.itemId =id++;
   	  this.name =a;
   	  this.description = d;
  	  this.price =p;
 	}
	Item(){}
    public Integer getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
    
    public int getItemId() {
        return itemId;
    }
    public String getName() {
        return name;
    }
}

 static class Cart {
 HashMap<Item,Integer> market ;
       Cart(){
        market = new HashMap<>();
       }
        public  void addToCart(Item item ,Integer quantity)
         {
             if(market.containsKey(item)) System.out.println("Already Added");
             else {
                  market.put(item,quantity); 
                 }
         }
    
    
         public  Integer displayQty(Item item)
         {
           return market.get(item);
         }
    
    
        public  void updateQty(Item item , Integer Quantity)
        {
             market.put(item,Quantity);
             System.out.println("Quantity Updated");
        }
    
    
        public  void deleteItem(Item item)
        {
           market.remove(item);
        }
    
    
        public  double display()
        { 
             double a =0;
               for(Item i: market.keySet())
            {
                double nn = i.getPrice()*market.get(i);
                 a+=nn;
             }
             return a; 
        } 
    
    
    
    }
}
