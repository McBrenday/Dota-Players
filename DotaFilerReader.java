
import java.io.*;
import java.util.*;

public class DotaFilerReader
{
    private ArrayList<DotaPlayer> ar = new ArrayList<DotaPlayer>();
    //Private methods:
    
    //sortPlayers("VALUE", "BY") VALUE: GPM XPM WINRATE     BY: HIGH or LOW
    public void reader() throws IOException   // fills ar with 20 Persons
    {FileReader fr = new FileReader("dotaPlayers.txt");
     BufferedReader br = new BufferedReader(fr);
     String n, r;
     int gp, xp;
     double wr;
     String readWR;
     String readGPM;
     String readXPM;
     int ct =0;

     while((n = br.readLine())!= null) {
       n = br.readLine();
       r = br.readLine();
       readWR = br.readLine();
       readGPM = br.readLine();
       readXPM = br.readLine();

       wr = Double.parseDouble(readWR);
       gp = Integer.parseInt(readGPM);
       xp = Integer.parseInt(readXPM);
       
      DotaPlayer dp = new DotaPlayer(n, r, wr, gp, xp);
      ar.add(dp);
      ct++;
     }
   }
   
   public void addPlayer(String n, String r, double wr, int gpm, int xpm) {
       DotaPlayer newDP = new DotaPlayer(n, r, wr, gpm, xpm);
       ar.add(newDP);
    }
    
   public void printPlayers() {
       for(int x = 0; x < ar.size(); x++) {
           System.out.println(ar.get(x).getName());
        }
   }
   public void printHighestGPM() {
        DotaPlayer highestGPMPlayer = ar.get(0);
        for(int x = 1; x < ar.size(); x++) {
            if(highestGPMPlayer.getGPM() < ar.get(x).getGPM()) {
                highestGPMPlayer = ar.get(x);
            }
            
        }
        System.out.println("Highest GPM Player: " +highestGPMPlayer.getName());
   }
   public void printHighestXPM() {
        DotaPlayer highestXPMPlayer = ar.get(0);
        for(int x = 1; x < ar.size(); x++) {
            if(highestXPMPlayer.getXPM() < ar.get(x).getXPM()) {
                highestXPMPlayer = ar.get(x);
            }
            
        }
        System.out.println("Highest XPM Player: " +highestXPMPlayer.getName());
   }   
   public void printWinrate(String n) {
       for(int x = 0; x < ar.size(); x++) {
           if(ar.get(x).getName().equals(n)) {
               System.out.println(n +" winrate is: " + ar.get(x).getWinRate());
            }
        }
    }
   public int amountOfPeopleWhoPlayRole(String r) {
       int ct = 0;
       for(int x = 0; x < ar.size(); x++) {
           if( ar.get(x).getRole().equals(r)) {
               ct = ct +1;
            }
        }
       return(ct);
    }
   private void sortPlayers(String sort, String amount) {
       if(sort.equals("GPM")) {
           int smallplace;
           for (int x = 0; x < ar.size(); x++) {
               for(int y = x +1; y < ar.size(); y++) {
                   smallplace = x;
                   if (ar.get(y).getGPM() > ar.get(smallplace).getGPM() && amount.equals("HIGH")) {
                       ar.add(x, ar.remove(y));
                    }
                    else if(ar.get(y).getGPM() < ar.get(smallplace).getGPM() && amount.equals("LOW")) {
                       ar.add(x, ar.remove(y));
                }
            }
        }
       }
       else if (sort.equals("XPM")) {
           int smallplace;
           for (int x = 0; x < ar.size(); x++) {
               for(int y = x +1; y < ar.size(); y++) {
                   smallplace = x;
                   if (ar.get(y).getXPM() > ar.get(smallplace).getXPM() && amount.equals("HIGH")) {
                       ar.add(x, ar.remove(y));
                    }
                    else if(ar.get(y).getXPM() < ar.get(smallplace).getXPM() && amount.equals("LOW")) {
                        ar.add(x, ar.remove(y));
                    }
                }
            }
        }
        else if (sort.equals("winrate")) {
            int smallplace;
            for (int x = 0; x < ar.size(); x++) {
               for(int y = x +1; y < ar.size(); y++) {
                   smallplace = x;
                   if (ar.get(y).getWinRate() > ar.get(smallplace).getWinRate() && amount.equals("HIGH")) {
                       ar.add(x, ar.remove(y));
                    }
                   if (ar.get(y).getWinRate() < ar.get(smallplace).getWinRate() && amount.equals("LOW")) {
                       ar.add(x, ar.remove(y));
                   }
                }
            }
        }
        else
            System.out.println("Enter a valid sort type");
    }
    
   public void changeSomething(String n, String change, String value) {
       boolean playerFound = false;
       boolean valueFound = false;
       for(int x = 0; x < ar.size(); x ++) {
           if (ar.get(x).getName().equals(n)) {
               System.out.println("Found Player ");
               DotaPlayer p = ar.get(x);
               playerFound = true;
               //GPM CHANGE:
               if(change.equals("GPM")) { 
                   int val = Integer.parseInt(value);
                   p.changeGPM(val);
                   valueFound = true;
                }
               //XPM CHANGE:
               else if(change.equals("XPM")) {
                   int val = Integer.parseInt(value);
                   p.changeXPM(val);
                   valueFound = true;
                }
               //WINRATE CHANGE:
               else if(change.equals("WinRate")) {
                   double wr = Double.parseDouble(value);
                   p.changeWinRate(wr);
                   valueFound = true;
                }
               //Role Change:
               else if (change.equals("Role")) {
                   p.changeRole(value);
                   valueFound = true;
                }
            }
            
        }
       if (playerFound == false) {
           System.out.println("Error: No player exsists with that name");
        }
       if (valueFound == false) {
           System.out.println("Error: Value does not exsist");
        }
    }
    
   public void printPlayersWith(String with, String by) {
       for(int x = 0; x < ar.size(); x++) {
           sortPlayers(with, by);
           if (with.equals("GPM")) {
               
               System.out.println(ar.get(x).getName() +"'s GPM = " +ar.get(x).getGPM());
            }
           else if(with.equals("XPM")) {
               System.out.println(ar.get(x).getName() +"'s XPM = " +ar.get(x).getXPM());
            }
           else if(with.equals("Winrate")) {
               System.out.println(ar.get(x).getName() +"'s Winrate = " +ar.get(x).getWinRate());
            }
           else
                System.out.println("TYPE NOT FOUND");
        }
    }
   public void savePlayers() throws IOException {
       BufferedWriter out = new BufferedWriter(new FileWriter("dotaPlayers.txt"));
   
       for(int x = 0; x < ar.size(); x++) {
           String n = ar.get(x).getName();
           String r = ar.get(x).getRole();
           double wr = ar.get(x).getWinRate();
           int gpm = ar.get(x).getGPM();
           int xpm = ar.get(x).getXPM();
           
           out.newLine();
           out.write(n);
           out.newLine();
           out.write(r);
           out.newLine();
           out.write(Double.toString(wr));
           out.newLine();
           out.write(Integer.toString(gpm));
           out.newLine();
           out.write(Integer.toString(xpm));
           out.newLine();
        }
        out.close();
    }
    }

