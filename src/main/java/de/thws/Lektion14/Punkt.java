package de.thws.Lektion14;

public class Punkt {
    int x;
    int y;

    public void verschiebePunkt(int zielX, int zielY) {
        if (zielX < 0 || zielY < 0 || zielX > 1920 || zielY > 1080) {
            throw new RuntimeException("Ungültige Koordinaten: x=" + zielX + ", y=" + zielY);
        }
        x = zielX;
        y = zielY;
    }

    // Getter zum Testen
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

