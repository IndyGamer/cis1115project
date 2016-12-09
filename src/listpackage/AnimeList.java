package listpackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 55jphillip
 */
public class AnimeList {

    private final String fileName = "animedata.txt";
    private List<Anime> myList;

    public AnimeList() {
        myList = new ArrayList();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(AnimeList.class.getName()).log(Level.SEVERE, null, ex);
        }
        readList();
    }

    public void create(Anime anime) {
        myList.add(anime);
        writeList();
    }

    public Anime retrieve(int id) {
        for (Anime anime : myList) {
            if (anime.getId() == id) {
                return anime;
            }
        }
        return null;
    }

    public void delete(int id) {
        for (Anime anime : myList) {
            if (anime.getId() == id) {
                myList.remove(anime);
            }
        }
        writeList();
    }

    public String orderById() {
        myList.sort(Comparator.comparing(Anime::getId));
        return this.toString();
    }

    public String orderByName() {
        myList.sort(Comparator.comparing(Anime::getName));
        return this.toString();
    }

    public String orderByGenre() {
        myList.sort(Comparator.comparing(Anime::getGenre).reversed());
        return this.toString();
    }

    public String orderByStudio() {
        myList.sort(Comparator.comparing(Anime::getStudio).reversed());
        return this.toString();
    }

    public String orderByEpisodenumber() {
        myList.sort(Comparator.comparing(Anime::getEpisodenumber).reversed());
        return this.toString();
    }

    public String orderByRating() {
        myList.sort(Comparator.comparing(Anime::getRating).reversed());
        return this.toString();
    }

    public String orderByNameGenre() {
        myList.sort(Comparator.comparing(Anime::getName).thenComparing(Anime::getGenre).reversed());
        return this.toString();
    }

    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String genre = data[2];
                String studio = data[3];
                int episodenumber = Integer.parseInt(data[4]);
                double rating = Double.parseDouble(data[5]);
                Anime myanime = new Anime(id, name, genre, studio, episodenumber, rating);
                myList.add(myanime);
            }
        } catch (IOException ex) {
            Logger.getLogger(AnimeList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Anime anime : myList) {
                writer.write(String.format("%d,%s,%s,%s,%d,%f,/n",
                        anime.getId(),
                        anime.getName(),
                        anime.getGenre(),
                        anime.getStudio(),
                        anime.getEpisodenumber(),
                        anime.getRating()));
            }
        } catch (IOException ex) {
            Logger.getLogger(AnimeList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Anime anime : myList) {
            sb.append(anime).append("\n");
        }
        return sb.toString();
        //return myList.toString();
    }
}
