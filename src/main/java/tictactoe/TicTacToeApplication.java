package tictactoe;

import tictactoe.controllers.GameController;
import tictactoe.models.*;
import tictactoe.services.winningstrategy.WinningStrategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToeApplication {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the board:");
        int dimension=sc.nextInt();
        System.out.println("is bot player allowed?:Y/N");
        String isBotPresent=sc.next();
        List<Player> players=new ArrayList<>();
        int iteratorNumber = dimension - 1;

        if(isBotPresent.equalsIgnoreCase("Y")){
            iteratorNumber = iteratorNumber - 1;
        }
        for(int i=1;i<=iteratorNumber;i++){
            System.out.println("What is the name of player, number : " + i);
            String playerName = sc.next();

            System.out.println("What is the symbol of player, number : " + i);
            String symbol = sc.next();

            players.add(new Player(i, playerName, symbol.charAt(0), PlayerType.HUMAN));
        }

        if(isBotPresent.equalsIgnoreCase("Y")){
            System.out.println("What is the name of BOT");
            String botName = sc.next();

            System.out.println("What is the symbol of BOT");
            String botSymbol = sc.next();

            //TODO: Take input for BOT difficulty level, and set strategy accordingly
            Botdifficultylevel botDifficultyLevel = Botdifficultylevel.EASY.EASY;
            Bot bot = new Bot(
                    dimension,
                    botName,
                    botSymbol.charAt(0),
                    PlayerType.BOT,
                    botDifficultyLevel
            );
            players.add(bot);
        }

        Collections.shuffle(players);
        GameController gameController=new GameController();
        Game game=gameController.creategame(dimension, WinningStrategies.ORDERONEWINNINGSTRATEGY,players);
        int playerindex=-1;
        while(gameController.gamestatus(game).equals(Gamestatus.INPROGRESS))
        {
            System.out.println("Current Board status: ");
            gameController.displayBoard(game);
            playerindex++;
            playerindex=playerindex%(players.size());
            Move moveplayed=gameController.executemove(game,players.get(playerindex));
            System.out.println("Do you want to undo your move? Y/N");
            String isundoRequired=sc.next();
            if(isundoRequired.equalsIgnoreCase("Y"))
            {
                gameController.undoMove(game,moveplayed);
            }
            Player winner=gameController.checkwinner(game,moveplayed);
            if(winner!=null)
            {
                System.out.println("The winner is: "+winner.getName());
                gameController.updategamestatus(game);
            }

        }
        System.out.println("Final board status");
        gameController.displayBoard(game);
        System.out.println("Do you want a replay? Y/N");
        String replay=sc.next();
        if(replay.equalsIgnoreCase("Y")) {
            //TODO : call the replay logic here
            gameController.replayGame(game);
        }




    }
}
