package blackjack

import blackjack.domain.Card
import blackjack.domain.Cards
import blackjack.domain.Ranks
import blackjack.domain.Suits
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CardsTest {
    @Test
    fun `카드들의 합을 계산할 수 있다`() {
        val tenOfClubs = Card.createCard(Ranks.TEN, Suits.CLUBS)
        val jackOfHearts = Card.createCard(Ranks.JACK, Suits.HEARTS)
        val cards = Cards.empty()
            .add(tenOfClubs)
            .add(jackOfHearts)

        assertThat(cards.sum()).isEqualTo(20)
    }
}