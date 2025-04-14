package de.thws.Lektion14;

public class Strecke {
    private int a;
    private int b;

    public Strecke(int punkt1, int punkt2) {
        if (punkt1 <= punkt2) {
            this.a = punkt1;
            this.b = punkt2;
        } else {
            this.a = punkt2;
            this.b = punkt1;
        }
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
    public boolean ueberschneidet(Strecke andere) {
        // Eine Berührung (z. B. this.b == andere.a) zählt **nicht** als Überschneidung
        return !(this.b <= andere.a || andere.b <= this.a);
    }
    @Override
    public String toString() {
        if (a == b) return String.valueOf(a);

        StringBuilder sb = new StringBuilder();
        sb.append(a);
        for (int i = 0; i < (b - a - 1); i++) {
            sb.append("-");
        }
        sb.append("-").append(b);
        return sb.toString();
    }
}



