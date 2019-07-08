import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Dota {
    static Scanner in = new Scanner(System.in);
    
    public static void main() throws IOException {
        //FUNCTIONS YOU CAN TEST:
        //addPlayer("NAME", ROLE", WINRATE.0, GPM, XPM)
        //printPlayers()
        //printHighestGPM()
        //printHighestXPM()
        //printWinrate("NAME")
        //amountOfPeopleWhoPlayRole("ROLE") //returns how many people can play Support, Core, Mid, Offlane
        //savePlayers() //saves everything in the arraylist, if u add a player you need to save the players.
        //changeSomething("NAMEOFPLAYER", "VALUECHANGING", "NEWVALUE"); -VALUECHANGING: GPM(int), XPM(int), WinRate(Double), Role(String)
        //printPlayersWith("VALUE", "BY") //Value must = GPM, XPM, or Winrate, uses the sort type, HIGH OR LOW
        DotaFilerReader doto = new DotaFilerReader();
        doto.reader();
        
        //Put commands underneath here to test
        doto.printPlayersWith("XPM", "LOW");
        
        
        //Saves any changes to the .txt file
        doto.savePlayers();
    }
}

