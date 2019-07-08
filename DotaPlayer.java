import java.util.Scanner;
import java.io.*;
import java.util.*;
public class DotaPlayer
  {
   private String name;
   private String role;
   private double winRate;
   private int gpm;
   private int xpm;
   
   public DotaPlayer(String n, String r, double wr, int gp, int xp) {
       name = n;
       role = r;
       winRate = wr;
       gpm = gp;
       xpm = xp;
    }
   
   public String getName() {
       return name;
    }
   public String getRole() {
       return role;
    }
   public double getWinRate() {
       return winRate;
    }
   public int getGPM() {
       return gpm;
    }
   public int getXPM() {
       return xpm;
    }
   
   public void changeName(String n) {
       name = n;
    }
   public void changeRole(String r) {
       role = r;
    }
   public void changeWinRate(double wr) {
       winRate = wr;
    }
   public void changeGPM(int gp) {
       gpm = gp;
    }
    public void changeXPM(int xp) {
        xpm = xp;
    }
 }

