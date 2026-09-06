import java.util.Scanner;


public class Demineur{
Scanner sc = new Scanner(System.in);

String input;
    public  void main(String[] args){
        System.out.println();
        Game partie = new Game(9, 9, 8, 2, 2);
        Affichage.affiche(partie);
        System.out.println();
        do{
            System.out.println();
            System.out.println();
           System.out.print(" Case à jouer ? (format x,y)  :  ");
           input = sc.nextLine();
           Game.Case laCase = Logique.inputToCase(input, partie);
           if(partie.estMine(laCase) == true){
            Logique.revele(partie);
            Affichage.affiche(partie);
            System.out.println();
            System.out.println();
            System.out.println("PERDU");
            break;
           }
           System.out.println();
           Logique.decouvre(partie, laCase);
           if(Logique.verifWin(partie) == true){
            Logique.revele(partie);
            Affichage.affiche(partie);
            System.out.println();
            System.out.println();
            System.out.println("GAGNER");
            break;
           }
           for(int n=0; n<10;n++){
           System.out.println();}
           Affichage.affiche(partie);
           
        }while(true);
    }

}