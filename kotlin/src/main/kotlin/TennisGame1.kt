import kotlin.math.abs

class TennisGame1() : TennisGame {
    private val WINNER_STRING = "Win for"
    private val ADVANTAGE_STRING = "Advantage"
    private val LOVE = "Love"
    private val FIFTEEN = "Fifteen"
    private val THIRTY = "Thirty"
    private val FORTY = "Forty"
    private val DEUCE = "Deuce"
    private val ALL = "All"
    private val PLAYER_1_NAME = "player1"
    private val PLAYER_2_NAME = "player2"

    private var player1Score: Int = 0
    private var player2Score: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === PLAYER_1_NAME){
            player1Score += 1
            return
        }

        player2Score += 1
    }

    override fun getScore(): String {
        if (scoresAreEquals()) {
            return equalScores()
        }

        if (oneOfPlayersReached4Points()) {
            return highScores()
        }

        return lowScores()
    }

    private fun oneOfPlayersReached4Points() = player1Score >= 4 || player2Score >= 4

    private fun scoresAreEquals() = player1Score == player2Score

    private fun lowScores(): String {
        var temporaryScore: Int
        var score = ""
        for (i in 1..2) {
            if (i == 1)
                temporaryScore = player1Score
            else {
                score += "-"
                temporaryScore = player2Score
            }
            when (temporaryScore) {
                0 -> score += LOVE
                1 -> score += FIFTEEN
                2 -> score += THIRTY
                3 -> score += FORTY
            }
        }
        return score
    }

    private fun highScores(): String {
        val scoreDifference = player1Score - player2Score

        if (abs(scoreDifference) == 1) {
            return advantagesScores(scoreDifference)
        }

        return winnerScores(scoreDifference)
    }

    private fun winnerScores(scoreDifference: Int): String {
        if (scoreDifference >= 2)
            return "$WINNER_STRING $PLAYER_1_NAME"

        return "$WINNER_STRING $PLAYER_2_NAME"
    }

    private fun advantagesScores(scoreDifference: Int): String {
        if (scoreDifference == 1)
            return "$ADVANTAGE_STRING $PLAYER_1_NAME"

        return "$ADVANTAGE_STRING $PLAYER_2_NAME"
    }

    private fun equalScores(): String {
        return when (player1Score) {
            0 -> "$LOVE-$ALL"
            1 -> "$FIFTEEN-$ALL"
            2 -> "$THIRTY-$ALL"
            else -> DEUCE
        }
    }
}
