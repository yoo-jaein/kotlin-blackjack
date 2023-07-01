package blackjack

import blackjack.domain.GameCardsSet
import blackjack.domain.Player
import blackjack.domain.PlayerState
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PlayerTest {
    private lateinit var gameCardsSet: GameCardsSet
    private lateinit var player1: Player

    @BeforeEach
    fun setUp() {
        gameCardsSet = GameCardsSet()
        player1 = Player("사람1", gameCardsSet)
    }

    @Test
    fun `플레이어는 카드들을 가질 수 있다`() {
        player1.hit()
        val cards = player1.getMyCards()
        assertThat(cards.cards.size).isEqualTo(1)
    }

    @Test
    fun `플레이어의 상태를 확인할 수 있다`() {
        player1.hit()
        assertThat(player1.state).isEqualTo(PlayerState.HIT)
    }

    @Test
    fun `플레이어가 스탠드를 선언하면 더이상 카드를 뽑을 수 없다`() {
        player1.hit()
        player1.stand()
        assertThat(player1.state.canDraw).isEqualTo(false)
    }

    @Test
    fun `플레이어가 스탠드를 선언했는데 카드를 뽑을 경우 IllegalStateException`() {
        player1.hit()
        player1.stand()
        assertThrows<IllegalStateException> {
            player1.hit()
        }
    }
}
