public class Affichage {


public static void affiche(Game game){
int spacing = 2;
int spacingVertical = 1;
int longueur = game.getLongueur() ;
int hauteur = game.getHauteur() ;
int ecartLetter = 1;


for(int i=0; i<hauteur;i++){
    int tempI = hauteur-i-1;
    System.out.print(String.valueOf(tempI));
    System.out.print((tempI>9 ? (" ".repeat(spacing)) : (" ".repeat(spacing+1))));
    for(int j=0;j<longueur;j++){
        if (game.estafficher(game.accedeCase(j,tempI))){
        System.out.print(" ".repeat(ecartLetter) + game.accedeCase(j,tempI).apparence + " ".repeat(ecartLetter));
        }else{
            System.out.print(" ".repeat(ecartLetter) + "#" + " ".repeat(ecartLetter));

        }
    }
System.out.println();
for(int n=0;n<spacingVertical;n++){
System.out.println();
}

}
String spacingBot = (" ".repeat(spacing+2));
for(int i=0; i<spacing-1; i++){System.out.println();}
System.out.print(spacingBot);
for(int i=0;i<longueur;i++){
System.out.print(" ".repeat(ecartLetter) + String.valueOf(i) + " ".repeat(ecartLetter));
}

    }
}
