import java.util.List;

public class ConsoleObserver implements Observer {
	public void update(Tournament tournament) {
		List<Match> matches = tournament.getMatches();

		System.out.println("\n--- Nieuwe ronde ---");

		for (Match match : matches) {
			System.out.printf("%s (%d punten) vs %s (%d punten)\n",
				match.getPlayer1().getName(), match.getPlayer1Score(),
				match.getPlayer2().getName(), match.getPlayer2Score());
		}

		if (tournament.getWinner() != null) {
			System.out.println("\n--- Eind van het toernooi ---");
			System.out.println("Winnaar: " + tournament.getWinner().getName());
		}
	}
}
