package listpackage;

/**
 *
 * @author 55jphillip
 */
public class AnimeArray {
    private Anime[] animes;
    private int n;
    
    public AnimeArray() {
        animes = new Anime[100];
        n = 0;
    }
    
    // CRUD - create new pet, retrieve pets, update pet object, delete pet object
    public void create(Anime anime) {
        animes[n] = anime;
        n++;
    }
    
    @Override
    public String toString() {        
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<n; i++) {
            sb.append(animes[i]).append("\n");
        }
        return sb.toString();
    }
}
