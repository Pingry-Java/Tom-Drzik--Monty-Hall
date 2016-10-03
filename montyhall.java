import java.util.Scanner;

public class montyhall
{
    public static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        //model the doors as ints
        
        int carDoor = (int) (Math.random() * 3 + 1); //random door either 1,2,3
        int userDoor = getUserDoor();
        System.out.println("There is a goat behind door number " + revealDoor(carDoor, userDoor));
        System.out.println("Would you like to switch your door");
        boolean swap = shouldISwap();
        if (swap = true)
        {
           int swappedDoor = changeTheDoor(userDoor, revealDoor(carDoor, userDoor)); 
           if (swappedDoor == carDoor)
           {
               System.out.println("Congragulations, the car was behind door" + carDoor);
           }
           else
           {
               System.out.println("Sorry, you chose door" + swappedDoor + "but the car was behind door" + carDoor);
           }
        }
        else
        {
            if (userDoor == carDoor)
            {
              System.out.println("Congragulations, the car was behind door" + carDoor);  
            }
            else
            {
                System.out.println("Sorry, you chose door" + userDoor + "but the car was behind door" + carDoor);
            }
        }
        //Todo if swap is true change userDoor
        //Todo if swapped userDoor = carDoor Declare winner
        
        
        
        
    }
    public static int getUserDoor()
    {
        System.out.println("Choose door 1, 2, or 3");
        String userDoor = keyboard.nextLine();
        return Integer.parseInt(userDoor);
    }
    
    /**
    *This method calculates a returns a door for the host to open that is neither the correct door nor the user's door
    *@param carDoor The door that the car is behind that the host cannot open
    *@param userDoor The door that the user has chosen that the host cannot open
    *@return The goat door
    */
    
    public static int revealDoor(int carDoor, int userDoor)
    {
        int goatDoor = (int) (Math.random() * 3 + 1);
        if (goatDoor == carDoor || goatDoor == userDoor)
        {
            return revealDoor(carDoor, userDoor);
        }
        
        
        return goatDoor;
        
        
    }
    public static boolean shouldISwap()
    {
        System.out.println("Type 1 if you would like to switch doors, or 0 if not");
        String input = keyboard.nextLine();
        int answer = Integer.parseInt(input);
        if (answer == 1)
            return true;
        return false;
            
    }
    
    public static int changeTheDoor(int userDoor, int goatDoor)
    {
        int swappedDoor = (int) (Math.random() * 3 + 1);
        if (swappedDoor == userDoor || swappedDoor == goatDoor)
        {
            return changeTheDoor(userDoor, goatDoor);
        }
        return swappedDoor;
        
        
        
        
        
        
        
        
    }
    
}