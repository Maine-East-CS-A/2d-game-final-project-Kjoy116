import java.util.*;
public class Box{
    Scanner scan = new Scanner(System.in);
    private int[][] nums;
    
    public Box(){
        nums = new int[2][12];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++){
                nums[i][j] = j+1;
            }
        }

        System.out.println("Welcome to shut the box! Try to collect all your numbers to win.\nNote that selecting 2 with doubles rolled will result in the number you rolled 2 of being closed.");
    }

    public String toString(){
        ArrayList<Integer> playerBoxes = new ArrayList<Integer>();

        for(int e : nums[0]){
            if(e != 0){
                playerBoxes.add(e);
            }
        }

        ArrayList<Integer> comBoxes = new ArrayList<Integer>();

        for(int e : nums[1]){
            if(e != 0){
                comBoxes.add(e);
            }
        }

        return "Player still has to shut " + playerBoxes + "\nComputer still has to shut " + comBoxes;
        //change later to remove zeros from printed nums left
    }


    private static int rollDie(){
        return (int)(Math.random() * 6) + 1;
    }

    public void PlayerTurn(){
        int die1 = rollDie();
        int die2 = rollDie();
        int totalRoll = die1 + die2;
        int numsDown = 0;
        boolean move = false;
        boolean moving = true;

        System.out.println("The first die rolled " + die1 + "\nThe second die rolled " + die2 + "\nCombined roll of " + totalRoll);
        System.out.println("Do you see a move (y/n)?");
        if(scan.nextLine().equals("y")){
            move = true;
        } else {
            move = false;
        }
        System.out.println();

        while(moving){

            if(move){

                System.out.println("Would you like to put down 1 number or 2?");
                numsDown = Integer.parseInt(scan.nextLine());

                if(numsDown == 1){

                    if(nums[0][totalRoll-1] == totalRoll){
                        nums[0][totalRoll - 1] = 0;
                        System.out.println("You have shut " + totalRoll);
                    } else {
                        System.out.println(totalRoll + " is not avalible! Checking your rolled dice avalibility...");
                    
                        if(nums[0][die1 - 1] == die1 && nums[0][die2 - 1] == die2){
                            nums[0][die1 - 1] = 0;
                            nums[0][die2 - 1] = 0;
                            System.out.println("You have shut " + die1 + " and " + die2);
                        } else {
                            System.out.println("You cannot shut any numbers.");
                        }

                    }
                } else if(numsDown == 2){

                    if(nums[0][die1 - 1] == die1 && nums[0][die2 - 1] == die2){
                        nums[0][die1 - 1] = 0;
                        nums[0][die2 - 1] = 0;
                        System.out.println("You have shut " + die1 + " and " + die2);

                    } else {
                        System.out.println("Those numbers are not both available! Checking your total avalibility...");
                    
                        if(nums[0][totalRoll-1] == totalRoll){
                            nums[0][totalRoll - 1] = 0;
                            System.out.println("You have shut " + totalRoll);
                        } else {
                            System.out.println("You cannot shut any numbers.");
                        }

                    }
                } else {
                    System.out.println("You did not enter a valid input! Turn forfeited.\n");
                }
            }
            
            if(die1 == die2 && this.checkWin().equals("")){
                System.out.println("\nYou rolled doubles! You get to re-roll!\n");
                System.out.println(this.toString());
                System.out.println();
                die1 = rollDie();
                die2 = rollDie();
                totalRoll = die1 + die2;
                System.out.println("The first die rolled " + die1 + "\nThe second die rolled " + die2 + "\nCombined roll of " + totalRoll);
                System.out.println("Do you see a move (y/n)?");
                if(scan.nextLine().equals("y")){
                    move = true;
                } else {
                    move = false;
                }
                System.out.println();
            } else {
                moving = false;
                break;
            }
        }
    }

    public String checkWin(){
        int closedCount = 0;
        for(int e : nums[0]){
            if(e == 0){
                closedCount++;
            }
        }

        if(closedCount == 12){
            return "Player wins!";
        }

        closedCount = 0;
        for(int e : nums[1]){
            if(e == 0){
                closedCount++;
            }
        }
        
        if(closedCount == 12){
            return "Computer wins!";
        }

        return "";
    }

    public void ComputerTurn(){
        int die1 = rollDie();
        int die2 = rollDie();
        int totalRoll = die1 + die2;
        int numsDown = 0;
        boolean moving = true;

        System.out.println("The computer's first die rolled " + die1 + "\nThe computer's second die rolled " + die2 + "\nCombined roll of " + totalRoll);
        
        while(moving){
            if(totalRoll >= 7){
                numsDown = 1;
            } else {
                numsDown = 2;
            }

            if(numsDown == 1){

                if(nums[1][totalRoll-1] == totalRoll){
                    nums[1][totalRoll - 1] = 0;
                    System.out.println("The computer shut " + totalRoll);
                } else {
                
                    if(nums[1][die1 - 1] == die1 && nums[1][die2 - 1] == die2){
                        nums[1][die1 - 1] = 0;
                        nums[1][die2 - 1] = 0;
                        System.out.println("The computer shut " + die1 + " and " + die2);
                    } else {
                        System.out.println("The computer cannot shut any numbers.");
                    }

                }
            }

            if(numsDown == 2){

                if(nums[1][die1 - 1] == die1 && nums[1][die2 - 1] == die2){
                    nums[1][die1 - 1] = 0;
                    nums[1][die2 - 1] = 0;
                    System.out.print("The computer shut " + die1 + " and " + die2);

                } else {
        
                    if(nums[1][totalRoll-1] == totalRoll){
                        nums[1][totalRoll - 1] = 0;
                        System.out.println("The computer shut " + totalRoll);
                    } else {
                        System.out.println("The computer cannot shut any numbers.");
                    }

                }
            }

            if(die1 == die2 && this.checkWin().equals("")){
                System.out.println("Since the computer rolled doubles, it rolls again!\n");
                die1 = rollDie();
                die2 = rollDie();
                totalRoll = die1 + die2;
                System.out.println("The computer's first die rolled " + die1 + "\nThe computer's second die rolled " + die2 + "\nCombined roll of " + totalRoll);
            } else {
                moving = false;
                break;
            }
        }
        
    }


}