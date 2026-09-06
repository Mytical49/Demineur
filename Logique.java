public class Logique {

    public static int nbMineCote(Game partie , Game.Case c){
        int h = c.hCase;
        int l = c.lCase;
        int compteur = 0;
        for(int i=h-1;i<=h+1;i++){
            int iTemp = i<0 ? 0 : i ;
            iTemp = i>= partie.getHauteur() ? partie.getHauteur()-1 : iTemp ;
            if((i>= partie.getHauteur()) || (i<0)){continue;}
            for(int j=l-1;j<=l+1;j++){
                if((i==h) && (j==l)){continue;}
                if((j>= partie.getLongueur()) || (j<0)){continue;}
            int jTemp = j<0 ? 0 : j ;
            jTemp = j>= partie.getLongueur() ? partie.getLongueur()-1 : jTemp ;
            //partie.afficherCase(partie.accedeCase(jTemp, iTemp));
            if ( partie.estMine(jTemp, iTemp)){

                compteur++;
            }
        }
        }

        return compteur;
    }

    public static void revele(Game game){
int longueur = game.getLongueur() ;
int hauteur = game.getHauteur() ;
        for(int i=0; i<hauteur;i++){
    int tempI = longueur-i-1;
    for(int j=0;j<longueur;j++){
        if (game.estMine(game.accedeCase(j,tempI)) == false){
            if (nbMineCote(game, game.accedeCase(j,tempI))==0){
                game.accedeCase(j,tempI).apparence = ".";
            }else{
                game.accedeCase(j,tempI).apparence = Integer.toString(nbMineCote(game, game.accedeCase(j,tempI)));
            }
            
        }
        game.afficherCase(game.accedeCase(j,tempI));
    }}}

    public static boolean verifWin(Game game){
int longueur = game.getLongueur() ;
int hauteur = game.getHauteur() ;
int compteMine = 0;
        for(int i=0; i<hauteur;i++){
    int tempI = longueur-i-1;
    for(int j=0;j<longueur;j++){
        if (game.accedeCase(j,tempI).marquer == true){
            compteMine++;
        }
        
    }}
if(((longueur * hauteur)- compteMine) == game.nbMine){
    return true;
}else{return false;}
}

    public static void decouvre(Game game, Game.Case laCase){
        if (laCase.marquer){return;}
        if (game.estMine(laCase)){return;}
        int mines = nbMineCote(game, laCase);
        if (mines > 0){
            laCase.apparence = Integer.toString(mines);
            game.afficherCase(laCase);
            laCase.marquer = true;
            return;
        }else{
        laCase.apparence = ".";
        game.afficherCase(laCase);
        laCase.marquer = true;
        int h = laCase.hCase;
        int l = laCase.lCase;
        for(int i=h-1;i<=h+1;i++){
            int iTemp = i<0 ? 0 : i ;
            iTemp = i>= game.getHauteur() ? game.getHauteur()-1 : iTemp ;
            for(int j=l-1;j<=l+1;j++){
            int jTemp = j<0 ? 0 : j ;
            jTemp = j>= game.getLongueur() ? game.getLongueur()-1 : jTemp ;
            
            decouvre(game, game.accedeCase(jTemp, iTemp));
            
        }
        }
        }

    }

    public static Game.Case inputToCase(String input, Game partie){
    int h;
    int l;
    int virgule = input.indexOf(",");
    l = Integer.parseInt(input.substring(0, virgule));
    h = Integer.parseInt(input.substring(virgule+1));
    System.out.println();
    System.out.println();
    System.out.println();
    return partie.accedeCase(l, h);
    }

}
