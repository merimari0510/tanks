package Inici;
import java.util.ArrayList;

/**
 * \brief Conforme un tipus de tank, el tipus Artilleria
 */
public class Artilleria extends Tank {
    /**
     * @pre: --
     * @post: Es crea un tank de tipus Artilleria
     */
    public Artilleria() {
        blindatge = 75;
        dany = 10;
        n_miss = 1;
        punts = 100;
        habilitat = 1;
        mov=6;
    }
    
}
