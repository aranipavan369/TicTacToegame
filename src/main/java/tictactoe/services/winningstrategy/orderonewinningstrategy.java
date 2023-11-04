package tictactoe.services.winningstrategy;

import tictactoe.models.Board;
import tictactoe.models.Move;
import tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class orderonewinningstrategy implements winningstrategy {
    private int dimension;
    private List<HashMap<Character,Integer>> rowhashmaps;
    private List<HashMap<Character,Integer>> colhashmaps;
    private HashMap<Character,Integer> topleft;
    private HashMap<Character,Integer> topright;
    private HashMap<Character,Integer> cornerhashmap;

    public orderonewinningstrategy(int dimension) {
        this.dimension=dimension;
        this.rowhashmaps = new ArrayList<>();
        this.colhashmaps = new ArrayList<>();
        this.topleft = new HashMap<>();
        this.topright = new HashMap<>();
        this.cornerhashmap = new HashMap<>();
        for(int i=0;i<dimension;i++)
            rowhashmaps.add(new HashMap<>());
        for(int i=0;i<dimension;i++)
            colhashmaps.add(new HashMap<>());
    }

    @Override
    public Player checkwinner(Board board, Move lastMove) {
        char symbol=lastMove.getCell().getPlayer().getSymbol();
        int row=lastMove.getCell().getRow();
        int col=lastMove.getCell().getCol();
        if(rowhashmaps.get(row).containsKey(symbol))
        rowhashmaps.get(row).put(symbol,rowhashmaps.get(row).get(symbol)+1);
        else
            rowhashmaps.get(row).put(symbol,1);

        if(colhashmaps.get(col).containsKey(symbol))
            colhashmaps.get(col).put(symbol,colhashmaps.get(col).get(symbol)+1);
        else
            colhashmaps.get(col).put(symbol,1);

        if(row==col) {
//
            if (topleft.containsKey(symbol))
                topleft.put(symbol, topleft.get(symbol) + 1);
            else
                topleft.put(symbol, 1);
        }
        if((row+col)==dimension-1)
        {
            if (topright.containsKey(symbol))
                topright.put(symbol, topright.get(symbol) + 1);
            else
                topright.put(symbol, 1);
        }
        if((row==0 && col==0) || (row==0 && col==dimension-1) || (row==dimension-1 && col==dimension-1)
                || (row==0 && col==dimension-1)) {
            if (cornerhashmap.containsKey(symbol))
                cornerhashmap.put(symbol, topleft.get(symbol) + 1);
            else
                cornerhashmap.put(symbol, 1);
        }
        if(checkrow(symbol) || checkcol(symbol) || checkbottom(symbol) || checktop(symbol) || checkbottom(symbol) || checkcorner(symbol))
            return lastMove.getCurrenplayer();
        return null;
    }

    public boolean checkrow(char symbol)
    {
        for(int i=0;i<dimension;i++)
        {
            if(rowhashmaps.get(i).containsKey(symbol))
            {
                if(rowhashmaps.get(i).get(symbol)==dimension)
                    return true;
            }
        }
        return false;
    }
    public boolean checkcol(char symbol)
    {
        for(int i=0;i<dimension;i++)
        {
            if(colhashmaps.get(i).containsKey(symbol))
            {
                if(colhashmaps.get(i).get(symbol)==dimension)
                    return true;
            }
        }
        return false;
    }
    public boolean checktop(char symbol)
    {
        if(topleft.containsKey(symbol))
        {
            if(topleft.get(symbol)==dimension)
                return true;
        }
        return false;
    }
    public boolean checkbottom(char symbol)
    {
        if(topright.containsKey(symbol))
        {
            if(topright.get(symbol)==dimension)
                return true;
        }
        return false;
    }
    public boolean checkcorner(char symbol)
    {
        if(cornerhashmap.containsKey(symbol))
        {
            if(cornerhashmap.get(symbol)==dimension)
                return true;
        }
        return false;
    }

}
