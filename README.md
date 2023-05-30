# Card Game

This is a simple card game implemented in Java. The game is played between two players who each have their own deck of cards. The objective of the game is to collect all the cards from the opponent.

## Getting Started

To run the card game, follow these steps:

1. Open the project in your preferred Java IDE.
2. Compile and run the `Main` class, which contains the main method.

## Game Rules

1. At the start of the game, two players are created and given their own deck of cards.
2. The deck of cards is initialized with 52 standard playing cards.
3. The cards are shuffled to randomize their order using the Fisher-Yates algorithm.
4. The game proceeds with each player drawing a card from their respective decks.
5. The player with the higher-ranking card wins the round and collects both cards.
6. If both players draw cards with the same rank, a "WAR" situation occurs.
   - In a war, two cards from each player's deck are placed in a pot.
   - The game continues to the next round, and the player with the higher-ranking card wins all the cards in the pot.
7. The game continues until one player runs out of cards or a maximum number of rounds is reached.
8. At the end of the game, the player with the most cards is declared the winner. If both players have the same number of cards, it's a tie.

## Class Descriptions

### Main.java

The `Main` class contains the main method and is responsible for starting the game. It creates two players and their respective decks, shuffles the cards, and manages the game flow.

### DeckOfCards.java

The `DeckOfCards` class represents a deck of cards. It initializes the deck with 52 standard playing cards, shuffles the cards, and provides methods to deal cards, add cards to the deck, and check if the deck is empty.

### Card.java

The `Card` class represents an individual playing card. Each card has a face (Ace, Deuce, Three, etc.) and a suit (Hearts, Diamonds, Clubs, Spades). It provides methods to retrieve the card's attributes and rank.

## Game Flow

1. The game starts by calling the `StartGame` method in the `Main` class.
2. The players' decks are initialized and shuffled.
3. The game proceeds in a loop until one player runs out of cards or a maximum number of rounds is reached.
4. In each round, both players draw a card from their respective decks.
5. The ranks of the drawn cards are compared to determine the winner of the round.
6. If it's a tie, a "WAR" situation occurs, and two cards from each player are added to the pot.
7. The game continues until there is a winner or a tie.
8. At the end of the game, the winner is determined based on the number of cards each player has.

## Running the Game

To run the game, execute the `Main` class. The game will proceed automatically, and the results of each round will be displayed using JOptionPane.

Note: You can modify the `MAX_NUM_OF_ROUNDS` constant in the `Main` class to set a different maximum number of rounds for the game.

Enjoy playing the card game!
