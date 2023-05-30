import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tournament implements Subject {
	private List<Player> players;
	private List<Observer> observers = new ArrayList<>();
	private Player winner;
	private List<Match> matches = new ArrayList<>();

	public Tournament(List<Player> players) {
		this.players = players;
	}

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Player getWinner() {
		return winner;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void start() {
		while (players.size() > 1) {
			matches.clear();  // Verwijder de resultaten van de vorige ronde
			players = simulateMatches(players);
			if (players.size() > 1) {
				notifyObservers();
			}
		}
		winner = players.get(0);  // De laatst overgebleven speler is de winnaar
		notifyObservers();
	}

	private List<Player> simulateMatches(List<Player> players) {
		List<Player> winners = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < players.size(); i += 2) {
			Player player1 = players.get(i);
			Player player2 = players.get(i + 1);
			int player1Wins = 0;
			int player2Wins = 0;

			// Speel games totdat iemand 2 punten heeft
			while (player1Wins < 2 && player2Wins < 2) {
				// Kies een willekeurige winnaar voor elk spel
				if (random.nextBoolean()) {
					player1Wins++;
				} else {
					player2Wins++;
				}
			}

			// Voeg de match toe aan de matches lijst
			matches.add(new Match(player1, player1Wins, player2, player2Wins));

			// Voeg de speler die als eerste 2 games wint toe aan de winnaarslijst
			if (player1Wins == 2) {
				winners.add(player1);
			} else {
				winners.add(player2);
			}
		}
		return winners;
	}
}
