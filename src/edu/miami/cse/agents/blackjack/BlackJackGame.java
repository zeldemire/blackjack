package edu.miami.cse.agents.blackjack;


public class BlackJackGame {

    private static DealerAgent dealer = new DealerAgent();
    private static PlayerAgent newPlayer = new PlayerAgent();
    private static PlayerAgent oldPlayer = new PlayerAgent();
    private static int money = 1000000;
    private static int gamesWon = 0;
    private static int gamesLost = 0;
    private static int gamesPlayed = 0;
    private static int iteration = 0;
    private static int totalGamesWon = 0;
    private static int totalGamesLost = 0;
    private static int totalAverageWon = 0;
    private static int totalAverageLost = 0;

    public static void main(String[] args) {
        // New strategy
        start(true);

        // Old strategy
//        start(false);
    }

    private static void start(boolean strategy) {
        int bet = 10;

        while (true) {
            if (iteration == 100 || money == 0) {
                break;
            }
            while (true) {
                if (gamesPlayed == 1000) {
                    break;
                }
                Enum result = playGame(strategy);
                if (result == GameResult.WON) {
                    money += bet;
                    gamesWon++;
                } else if (result == GameResult.LOST) {
                    money -= bet;
                    gamesLost++;
                }
                if (money == 0) {
                    break;
                }
                gamesPlayed++;
            }
            totalGamesWon += gamesWon;
            totalGamesLost += gamesLost;
            report();
            totalGamesLost = 0;
            totalGamesWon = 0;
            gamesLost = 0;
            gamesPlayed = 0;
            gamesWon = 0;
            iteration++;
        }
        finalReport();
    }

    private static void finalReport() {
        System.out.println();
        System.out.println("Average money won: " + totalAverageWon / 100);
        System.out.println("Average money lost: " + totalAverageLost / 100);
    }

    private static void report() {
        totalAverageWon += (totalGamesWon * 10) / 1000;
        totalAverageLost += (totalGamesLost * 10) / 1000;
        System.out.println("Game: " + iteration);
        System.out.println("Average money won: " + (totalGamesWon * 10) / 1000);
        System.out.println("Average money lost: " + (totalGamesLost * 10) / 1000);
    }

    private static Enum playGame(boolean strategy) {
        Deck deck = new Deck();

        Hand dealerCards = new Hand();
        dealerCards.add(deck.getCard());
        dealerCards.add(deck.getCard());

        if (dealerCards.getValue() == 21) {
            return GameResult.LOST;
        }

        Hand playerCards = new Hand();
        playerCards.add(deck.getCard());
        playerCards.add(deck.getCard());

        if (playerCards.getValue() == 21) {
            return GameResult.WON;
        }

        while (true) {
            if (strategy) {
                if (newPlayer.act(playerCards, dealerCards) == Action.STAND) {
                    break;
                } else if (newPlayer.act(playerCards, dealerCards) == Action.HIT) {
                    playerCards.add(deck.getCard());
                    if (playerCards.getValue() > 21) {
                        break;
                    }
                }
            } else {
                if (oldPlayer.act(playerCards, dealerCards) == Action.STAND) {
                    break;
                } else if (oldPlayer.act(playerCards, dealerCards) == Action.HIT) {
                    playerCards.add(deck.getCard());
                    if (playerCards.getValue() > 21) {
                        break;
                    }
                }
            }
        }

        while (true) {
            if (dealer.act(dealerCards) == Action.STAND) {
                break;
            }
            dealerCards.add(deck.getCard());
            if (dealerCards.getValue() > 21) {
                return GameResult.WON;
            }
        }

        if (dealerCards.getValue() > playerCards.getValue()) {
            return GameResult.LOST;
        } else if (dealerCards.getValue() < playerCards.getValue()) {
            return GameResult.WON;
        } else {
            return GameResult.PUSH;
        }

    }

}


