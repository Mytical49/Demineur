import java.util.Random;

public class Game {

private Random rd = new Random();
private int eviteH;
private int eviteL;
private int hauteur;
private int longueur; 
public int nbMine;
private Case[][] grille;

public static class Case{
    public int lCase;
    public int hCase;
    private boolean estMine;
    private boolean estAffiche;
    public String apparence = "#";
    public boolean marquer = false;


    public Case(int l, int h){
        this.lCase = l;
        this.hCase = h;
        this.estAffiche = false;
    }

}
public boolean estafficher(Case c){return c.estAffiche;
}
public void afficherCase(Case c){
    c.estAffiche = true;
}
public Case accedeCase(int l, int h){
    return grille[h][l];
}
public int getHauteur(){return hauteur;}
public int getLongueur(){return longueur;}
public boolean estMine(int l, int h){
    return  accedeCase(l, h).estMine;
}
public boolean estMine(Case c){
    return  accedeCase(c.lCase , c.hCase).estMine;
}

public void placeMine(Game game){
    for(int i = nbMine; i != 0; i-- ){
        int l = rd.nextInt(longueur);
        int h = rd.nextInt(hauteur);
        while(l == eviteL && h == eviteH){
        l = rd.nextInt(longueur);
        h = rd.nextInt(hauteur);
        }
        accedeCase(l, h).estMine = true;
        accedeCase(l, h).apparence = "O";
    }

}

public Game(int longueur,int hauteur,int nbMine,int eviteH, int eviteL){
    this.eviteH = eviteH;
    this.eviteL = eviteL;
    this.hauteur = hauteur;
    this.longueur = longueur;
    this.nbMine = nbMine;
    this.grille = new Case[hauteur][longueur];
    for(int i=0;i<hauteur;i++){
        for(int j=0;j<longueur;j++){
            grille[i][j] = new Case(j, i);
            grille[i][j].estMine = false;
        }
    }
    placeMine(this);
}


}
