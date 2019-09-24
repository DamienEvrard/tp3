package bowling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
        
        private int score[];// tableau taille 11
        private int tour;// [0-10]
        private int scoreTour; // score cumule du tour
        private int nbBoule; // boule lance
        private boolean strike[];
        private boolean spear[];
        
	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            score= new int[11];
            for(int i=0;i<score.length;i++){
                score[i]=0;
            }
            tour=0;
            scoreTour=0;
            nbBoule=1;
            strike= new boolean[11];
            spear= new boolean[11];
            for(int i=0;i<strike.length;i++){
                strike[i]=false;
                spear[i]=false;
            }
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            
            scoreTour+=nombreDeQuillesAbattues;
            
            if(nombreDeQuillesAbattues==10){
                strike[tour]=true;
                score[tour]=scoreTour;
                tour++;
                nbBoule=1;
                scoreTour=0;
            }
            else if(scoreTour==10){
                spear[tour]=true;
                score[tour]=scoreTour;
                tour++;
                nbBoule=1;
                scoreTour=0;
            }
            else if (nbBoule==2){
                score[tour]=scoreTour;
                tour++;
                nbBoule=1;
                scoreTour=0;
            }
            else{
                nbBoule++;
            }            
          }
        
        /*
        calcule le score en fin de partie
        */
        private void calculeScore(){
            
        }

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
            int pts=0;
            for(int i : score){
                pts+=i;
            }          
            return pts;
            //throw new UnsupportedOperationException("Pas encore implémenté");
	}
}
