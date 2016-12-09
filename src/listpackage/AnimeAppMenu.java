package listpackage;

import java.util.Scanner;
import utilities.Prompt;

/**
 *
 * @author 55jphillip
 */
public class AnimeAppMenu {

    Scanner sc = new Scanner(System.in);
    DAOAnime data = new DAOAnime();

    public AnimeAppMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id;
        String name;
        String genre;
        String studio;
        int episodenumber;
        double rating;

        while (choice != 0) {
            System.out.println("\nAnime App");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All: Order by Id");
            System.out.println("7 = Retrieve All: Order by Name");
            System.out.println("8 = Retrieve All: Order by Genre");
            System.out.println("9 = Retrieve All: Order by Studio");
            System.out.println("10 = Retrieve All: Order by Total Episodes from least to most.");
            System.out.println("11 = Retrieve All: Order by Total from most to least");
            System.out.println("12 = Retrieve All: Order by Rating from least to most");
            System.out.println("13 = Retrieve All: Order by Rating from most to least");
            System.out.println("14 = Retrieve All: Order by Genre, then by Name both alphabetically.");
            System.out.println("15 = Statistics");
            choice = Prompt.getInt("Number of choice: ", 0, 15);

            switch (choice) {
                case 1:
                    System.out.printf("\n%5s %-25s %-20s %-20s %-20s %-20s %n", "Id", "Name", "Genre", "Studio", "Total Episodes", "Rating");
                    System.out.println("********************************************************************************************************");
                    System.out.println(data.toString());
                    break;
                case 2:
                    id = Prompt.getInt("Enter anime id: ");
                    name = Prompt.getLine("Enter name: ");
                    genre = Prompt.getLine("Enter genre: ");
                    studio = Prompt.getLine("Enter studio: ");
                    episodenumber = Prompt.getInt("Enter total number of episodes: ");
                    rating = Prompt.getDouble("Enter rating: ");
                    Anime anime = new Anime(id, name, genre, studio, episodenumber, rating);
                    data.create(anime);
                    break;
                case 3:
                    id = Prompt.getInt("Enter Anime id: ");
                    System.out.printf("\n%5s %-25s %-20s %-20s %-20s %-20s %n", "Id", "Name", "Genre", "Studio", "Total Episodes", "Rating");
                    System.out.println("********************************************************************************************************");
                    System.out.println(data.retrieve(id));
                    break;
                case 4:
                    id = Prompt.getInt("Enter anime id: ");
                    name = Prompt.getLine("Enter name: ");
                    genre = Prompt.getLine("Enter genre: ");
                    studio = Prompt.getLine("Enter studio: ");
                    episodenumber = Prompt.getInt("Enter total number of episodes: ");
                    rating = Prompt.getDouble("Enter rating: ");
                    Anime Anime = new Anime(id, name, genre, studio, episodenumber, rating);
                    data.update(Anime);
                    break;
                case 5:
                    id = Prompt.getInt("Enter Anime id: ");
                    data.delete(id);
                    break;
                case 6:
                    System.out.printf("\n%5s %-25s %-20s %-20s %-20s %-20s %n", "Id", "Name", "Genre", "Studio", "Total Episodes", "Rating");
                    System.out.println("********************************************************************************************************");
                    System.out.println(data.orderById());
                    break;
                case 7:
                    System.out.printf("\n%5s %-25s %-20s %-20s %-20s %-20s %n", "Id", "Name", "Genre", "Studio", "Total Episodes", "Rating");
                    System.out.println("********************************************************************************************************");
                    System.out.println(data.orderByName());
                    break;
                case 8:
                    System.out.printf("\n%5s %-25s %-20s %-20s %-20s %-20s %n", "Id", "Name", "Genre", "Studio", "Total Episodes", "Rating");
                    System.out.println("********************************************************************************************************");
                    System.out.println(data.orderByGenre());
                    break;
                case 9:
                    System.out.printf("\n%5s %-25s %-20s %-20s %-20s %-20s %n", "Id", "Name", "Genre", "Studio", "Total Episodes", "Rating");
                    System.out.println("********************************************************************************************************");
                    System.out.println(data.orderByStudio());
                    break;
                case 10:
                    System.out.printf("\n%5s %-25s %-20s %-20s %-20s %-20s %n", "Id", "Name", "Genre", "Studio", "Total Episodes", "Rating");
                    System.out.println("********************************************************************************************************");
                    System.out.println(data.orderByEpisodenumber());
                    break;
                case 11:
                    System.out.printf("\n%5s %-25s %-20s %-20s %-20s %-20s %n", "Id", "Name", "Genre", "Studio", "Total Episodes", "Rating");
                    System.out.println("********************************************************************************************************");
                    System.out.println(data.orderByEpisodeNumberReversed());
                    break;
                case 12:
                    System.out.printf("\n%5s %-25s %-20s %-20s %-20s %-20s %n", "Id", "Name", "Genre", "Studio", "Total Episodes", "Rating");
                    System.out.println("********************************************************************************************************");
                    System.out.println(data.orderByRating());
                    break;
                case 13:
                    System.out.printf("\n%5s %-25s %-20s %-20s %-20s %-20s %n", "Id", "Name", "Genre", "Studio", "Total Episodes", "Rating");
                    System.out.println("********************************************************************************************************");
                    System.out.println(data.orderByRatingReversed());
                    break;
                case 14:
                    System.out.printf("\n%5s %-25s %-20s %-20s %-20s %-20s %n", "Id", "Name", "Genre", "Studio", "Total Episodes", "Rating");
                    System.out.println("********************************************************************************************************");
                    System.out.println(data.orderByNameGenre());
                    break;
                case 15:
                    System.out.printf("%n %-20s %-20s %-20s %-20s %-20s", "sum", "average", "maximum", "minimum", "standard deviation", "\n");
                    System.out.println(data.statistics());
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new AnimeAppMenu();
    }
}
