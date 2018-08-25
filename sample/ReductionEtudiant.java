
package sample;

import java.io.Serializable;

public class ReductionEtudiant implements Reduction ,Serializable {
    
    
    @Override
    public double donnerPourcentage(Commande commande, client client) {
        if(client.type==Typeclient.Etudiant)
        {
            return 0.08;
        }
       else return 0;
    }
}
