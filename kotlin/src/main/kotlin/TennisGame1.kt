class TennisGame1() : TennisGame {

    private var player1Score: Int = 0
    private var player2Score: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === "player1")
            player1Score += 1
        else
            player2Score += 1
    }

    override fun getScore(): String {
        var score = ""
        var temporaryScore = 0
        if (player1Score == player2Score) {
            return equalScores(player1Score)
        }

        if (player1Score >= 4 || player2Score >= 4) {
            val scoreDifference = player1Score - player2Score
            if (scoreDifference == 1)
                score = "Advantage player1"
            else if (scoreDifference == -1)
                score = "Advantage player2"
            else if (scoreDifference >= 2)
                score = "Win for player1"
            else
                score = "Win for player2"
        } else {
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
        }
        return score
    }

    private fun equalScores(playersScore: Int): String {
        return when (playersScore) {
            0 -> "Love-All"
            1 -> "Fifteen-All"
            2 -> "Thirty-All"
            else -> "Deuce"
        }
    }
}
