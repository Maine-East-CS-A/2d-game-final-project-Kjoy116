import java.util.*;

public class main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean playing = false;
        boolean gamePlay = true;
        String playPrompt = "";
        boolean active = true;

        while(active){
            while (gamePlay){
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
                        System.out.println(game.checkWin());
                        playing = false;

                        System.out.println("Would you like to play again?");
                        if(!scan.nextLine().equals("y")){
                            gamePlay = false;
                            break;
                        }
                    }

                    game.ComputerTurn();

                    if(!(game.checkWin() == "")){
                        System.out.println(game.checkWin());
                        playing = false;

                        System.out.println("Would you like to play again? (y/n)");
                        if(!scan.nextLine().equals("y")){
                            gamePlay = false;
                        }
                    }

                }
            }

            while(!gamePlay){
                System.out.println("Would you like to start a new game? (y/n) or type END to end.");
                playPrompt = scan.nextLine();
                if(playPrompt.equals("y")){
                    gamePlay = true;
                } else if(playPrompt.equals("END")){
                    active = false;
                    break;
                }
            }
        }
    }
}

