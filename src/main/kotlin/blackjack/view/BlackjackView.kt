package blackjack.view

import blackjack.domain.Card
import blackjack.domain.Cards
import blackjack.domain.Dealer
import blackjack.domain.Dealer.Companion.DEALER_INITIAL_TURN_LIMIT
import blackjack.domain.Player
import blackjack.domain.Players

object BlackjackView {
    fun printInitialTurn(dealerName: String, playerNames: List<String>, initialDraw: Int) {
        println("\n${dealerName}와 ${playerNames.joinToString(", ")}에게 ${initialDraw}장을 나누었습니다.")
    }

    fun printDealerExtraHit(dealerName: String) {
        println("\n${dealerName}는 ${DEALER_INITIAL_TURN_LIMIT}이하라 한장의 카드를 더 받았습니다.")
    }

    fun printPlayersCard(players: Players) {
        players.players.forEach {
            printPlayerCard(it)
        }
        println()
    }

    fun printDealerCard(dealer: Dealer) {
        val dealerFirstCard = dealer.getMyCards().cards[0]
        println("${dealer.name}: ${print(dealerFirstCard)}")
    }

    fun printPlayerCard(player: Player) {
        println("${player.name}카드: ${print(player.getMyCards())}")
    }

    fun askDraw(player: Player): Boolean {
        println("${player.name}는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)")
        return when (readln()) {
            YES -> true
            NO -> false
            else -> throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }

    fun printPlayersResult(players: List<Player>) {
        println()
        players.forEach {
            printPlayerResult(it)
        }
    }

    private fun printPlayerResult(player: Player) {
        println("${player.name}카드: ${print(player.getMyCards())} - 결과: ${player.sumOfMyCards()}")
    }

    private fun print(card: Card): String = "${card.rank.description}${card.suit.description}"

    private fun print(cards: Cards): String = cards.cards.joinToString(", ") { print(it) }

    private const val YES: String = "y"
    private const val NO: String = "n"
}
