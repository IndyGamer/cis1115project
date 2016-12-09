package listpackage;

/**
 * Pet Application
 *
 * @author 55jphillip
 */
public class AnimeApp {

    public static void main(String[] args) {
        AnimeArray pa = new AnimeArray();
        pa.create(new Anime(1,"One Piece", "Shounen", "Idk", 700, 4));
        pa.create(new Anime(2,"Hunter x Hunter", "Shounen", "Idk", 700, 4.5));
        pa.create(new Anime(3,"Bleach", "Shounen", "Idk", 700, 3));

        System.out.println(pa);
        
        DAOAnime pl = new DAOAnime();
        pl.create(new Anime(1,"Test", "Shounen", "Idk", 700, 4));
        pl.create(new Anime(2,"Test", "Shounen", "Idk", 700, 4));
        pl.create(new Anime(3,"Test", "Shounen", "Idk", 700, 4));
        System.out.println("pl");
    }
}
