public class Match {
	private Player player1;
	private int player1Score;
	private Player player2;
	private int player2Score;

	public Match(Player player1, int player1Score, Player player2, int player2Score) {
		this.player1 = player1;
		this.player1Score = player1Score;
		this.player2 = player2;
		this.player2Score = player2Score;
	}

	public Player getPlayer1() {
		return player1;
	}

	public int getPlayer1Score() {
		return player1Score;
	}

	public Player getPlayer2() {
		return player2;
	}

	public int getPlayer2Score() {
		return player2Score;
	}
}
