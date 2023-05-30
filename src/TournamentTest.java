import java.util.ArrayList;
import java.util.List;

public class TournamentTest {
	public static void main(String[] args) {
		// Creëer acht spelers
		List<Player> players = new ArrayList<>();
		players.add(new Player("Jan"));
		players.add(new Player("Piet"));
		players.add(new Player("Klaas"));
		players.add(new Player("Bram"));
		players.add(new Player("Sofie"));
		players.add(new Player("Els"));
		players.add(new Player("Annelies"));
		players.add(new Player("Laura"));

		// Maak een toernooi en voeg een observer toe
		Tournament tournament = new Tournament(players);
		tournament.registerObserver(new ConsoleObserver());

		// Start het toernooi
		tournament.start();
	}
}
