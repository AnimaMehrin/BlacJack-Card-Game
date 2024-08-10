# BlacJack-Card-Game

## Introduction

Welcome to the Blackjack game implemented in Java! This console-based application allows you to play a simplified version of the popular card game, Blackjack, against the computer. You start with a fixed amount of money and place bets on each round, trying to win more money by beating the computer's hand.

## Features

- **Deck of Cards**: A standard 52-card deck is used, shuffled at the beginning of each game.
- **Player vs. Computer**: Play against the computer, which follows a basic strategy of drawing cards until it reaches 17 or more.
- **Betting System**: Start with $100 and place bets on each round. The game ends when you run out of money or choose to quit.
- **Input Handling**: User-friendly input handling with error checking, ensuring a smooth gameplay experience.

## How to Play

1. **Start the Game**: Run the `Game.java` file to start the game. You'll be greeted with a welcome message and a starting balance of $100.

2. **Place Your Bet**: You'll be prompted to place a bet. Enter the amount you'd like to wager for the round. If you enter `0`, the game will end.

3. **Play the Round**:
   - Both you and the computer are dealt two cards.
   - If either you or the computer have a total of 21 with the first two cards, the game ends with that player as the winner.
   - Otherwise, you'll have the option to "Hit" (take another card) or "Stand" (end your turn).
   - The computer then plays its turn, drawing cards until it reaches a total of 17 or more.

4. **Win or Lose**: The round ends with either a win, loss, or tie. Your balance is adjusted based on the outcome, and you can continue playing until you run out of money or decide to quit.

5. **End the Game**: When you choose to stop playing, your final balance will be displayed.

## Project Structure

- `Card.java`: Defines a card with a suit and rank, and provides methods to retrieve the card's value and string representation.
- `Deck.java`: Manages the deck of 52 cards, including shuffling and dealing cards.
- `Player.java`: Represents a player (either the user or the computer) with a hand of cards and methods to add cards, get the hand's total value, and display cards.
- `Keyboard.java`: Handles user input, including reading integers and characters, with built-in error handling.
- `Game.java`: Contains the main game loop and logic, including dealing cards, handling user actions, and determining the winner.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your machine.

