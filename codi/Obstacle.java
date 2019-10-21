package Inici;

/**
 * @brief Constitueix l'obstacle que es troba un tank, és a dir, la pared en el tauler de tanks
 */
public class Obstacle extends ObjectesDeTauler{
    private String imatge; /**< Constitueix l'imatge que es posarà al obstacle */
    /**
     * @pre: --
     * @post: Es crea un obstacle
     */
    public Obstacle() {
        imatge = " ";
    }
}
