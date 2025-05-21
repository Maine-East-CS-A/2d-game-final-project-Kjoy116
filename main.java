import java.util.*;

public class main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean playing = false;
        String playPrompt = "";

        // while(!playing){
        //     System.out.println("Would you like to start a new game? (y/n)");
        //     playPrompt = scan.nextLine();
        //     if(playPrompt.equals("y")){
        //         Box game = new Box();
        //         playing = true;
        //     }
        // }
        Box game = new Box();
        playing = true;
        while(playing){

            System.out.println();
            System.out.println(game.toString());
            System.out.println();

            game.PlayerTurn();

            System.out.println();
            System.out.println(game.toString());
            System.out.println();

            if(!(game.checkWin() == "")){
                System.out.print(game.checkWin());
                playing = false;
            }

            game.ComputerTurn();

            if(!(game.checkWin() == "")){
                System.out.print(game.checkWin());
                playing = false;
            }

        }
    }
}

