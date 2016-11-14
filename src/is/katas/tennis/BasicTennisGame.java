package is.katas.tennis;

import java.util.ArrayList;
import java.util.List;

public class BasicTennisGame implements TennisGame {

    private String[] points = {"Love","Fifteen","Thirty","Forty"};
    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1;
    private final String player2;

    public BasicTennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) m_score1 += 1;
        else m_score2 += 1;
    }

    private String getDrawScore() {
        if (m_score1 <= 3) return points[m_score1] + "-All";
        else return "Deuce";

    }

    private String getAdvantage() {
        if (m_score1-m_score2 == 1) return "Advantage player1";
        else if (m_score1-m_score2 == -1) return "Advantage player2";
        else if (m_score1-m_score2 >= 2) return "Win for player1";
        else return "Win for player2";

    }

    private String getNamedScore(int score) {
        return points[score];
    }

    public String getScore() {
        if (m_score1 == m_score2) return getDrawScore();
        else if (m_score1>=4 || m_score2>=4) return getAdvantage();
        else return getNamedScore(m_score1) + "-" + getNamedScore(m_score2);

    }
}
