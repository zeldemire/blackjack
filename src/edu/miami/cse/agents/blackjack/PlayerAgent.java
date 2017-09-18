package edu.miami.cse.agents.blackjack;

public class PlayerAgent {
    public Action act(Hand playerCards, Hand dealerCards) {
        if (playerCards.getValue() <= 12) {
            switch (dealerCards.getTop()) {
                case 4:
                    return Action.STAND;
                case 5:
                    return Action.STAND;
                case 6:
                    return Action.STAND;
                default:
                    return Action.HIT;

            }
        } else if (playerCards.getValue() > 12 && playerCards.getValue() < 17) {
            switch (dealerCards.getTop()) {
                case 2:
                    return Action.STAND;
                case 3:
                    return Action.STAND;
                case 4:
                    return Action.STAND;
                case 5:
                    return Action.STAND;
                case 6:
                    return Action.STAND;
                default:
                    return Action.HIT;
            }

        } else {
            return Action.STAND;
        }
    }
}
