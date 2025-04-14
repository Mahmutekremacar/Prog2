package de.thws.Lektion16.schach;

public class Brett
{
  boolean[][] brett = new boolean[8][8];
  
  public Brett()
  {
    
  }

  public Brett kombiniere(Brett anderes)
  {
    Brett neu = new Brett();
    for (int i = 1; i <= 8; i++)
    {
      for (int j = 1; j <= 8; j++)
      {
        if (this.gibFeld(i, j) || anderes.gibFeld(i, j)) {
          neu.markiereFeld(i, j);
        }
      }
    }
    return neu;
  }


  public void markiereFeld(int x, int y)
  {
    brett[x-1][y-1] = true;
  }
  
  public boolean gibFeld(int x, int y)
  {
    return brett[x-1][y-1];
  }
  
}
