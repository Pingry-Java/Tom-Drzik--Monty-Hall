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
        if (swap == true)
        {
           userDoor = changeTheDoor(userDoor, revealDoor(carDoor, userDoor)); 
           if (userDoor == carDoor)
           {
               System.out.println("Congragulations, you swapped correctly, the car was behind door" + carDoor);
           }
           else
           {
               System.out.println("Sorry, you swapped to door" + userDoor + "but the car was behind door" + carDoor);
           }
        }
        if (swap == false)
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
    /**
    * Asks the user to choose door 1,2, or 3
    *@return The chosen door
    */
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
    /**
    * Asks the user if they would like to switch doors given the new information
    *@return returns either true for switch or false for don't switch
    */
    public static boolean shouldISwap()
    {
        System.out.println("Type yes if you would like to switch doors, or no if not");
        String answer = keyboard.nextLine();
        
        if (answer.equals("yes"))
            return true;
        if (answer.equals("no"))
            return false;
        return false;
            
    }
    
    /** Changes the door if the user asked to swap. Swapped door cannot be chosen door or opened door
    *@param the initially chosen door
    *@param the opened door
    *@return returns the new door
    */
    
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