package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    } 

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            ++player1Score;
        } else if (playerName.equals(player2Name)) {
            ++player2Score;
        }
    }

    public String getScore() {
        if (player1Score==player2Score)              return getTieScore();
        else if (player1Score>=4 || player2Score>=4) return getHighScore();
        else                                         return getNormalScore();
    }

    private String getTieScore() {
        switch (player1Score) {
                case 0: return "Love-All";
                case 1: return "Fifteen-All";
                case 2: return "Thirty-All";
                case 3: return "Forty-All";
                default: return "Deuce";
        }
    }

    private String getHighScore() {
        int scoreDifference = player1Score-player2Score;
        if (scoreDifference == 1)       return "Advantage player1";
        else if (scoreDifference == -1) return "Advantage player2";
        else if (scoreDifference >= 2)  return "Win for player1";
        else                            return "Win for player2";
    }

    private String getNormalScore() {
        return getPlayerScore(player1Score) + "-" + getPlayerScore(player2Score);
    }

    private String getPlayerScore(int playerScore) {
        switch(playerScore) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return "Error";
        }
    }

}
