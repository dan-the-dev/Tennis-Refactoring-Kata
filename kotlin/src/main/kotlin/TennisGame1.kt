class TennisGame1() : TennisGame {
    private val player1Name = "player1"
    
    private var player1Score: Int = 0
    private var player2Score: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === player1Name)
            player1Score += 1
        else
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
                0 -> score += "Love"
                1 -> score += "Fifteen"
                2 -> score += "Thirty"
                3 -> score += "Forty"
            }
        }
        return score
    }

    private fun highScores(): String {
        val scoreDifference = player1Score - player2Score
        if (scoreDifference == 1)
            return "Advantage player1"
        else if (scoreDifference == -1)
            return "Advantage player2"
        else if (scoreDifference >= 2)
            return "Win for player1"
        else
            return "Win for player2"
    }

    private fun equalScores(): String {
        return when (player1Score) {
            0 -> "Love-All"
            1 -> "Fifteen-All"
            2 -> "Thirty-All"
            else -> "Deuce"
        }
    }
}
