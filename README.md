# Uno Engine

The Uno Engine is structured with five classes, each carrying a distinct responsibility that corresponds to a specific aspect of the game. Among these, three classes are abstract, sharing a common theme in that they encapsulate the fundamental logic of the game, which remains consistent across various game variations. Below is an overview of the classes and their relationships (the design diagram is on the next page).

## Class Overview

### Game
The `Game` class takes charge of overseeing the overall progression of the game. It incorporates three abstract methods that serve to implement the unique configuration of any game variation:

- **play()**: This method orchestrates the general flow of the game, encompassing actions like game initiation, card dealing, and turn management.
- **performPlayerTurn(Player)**: Responsible for managing a player's turn, this method involves prompting the player to select a card, validating the choice, and executing the corresponding action.
- **isGameOver()**: Since determining the winner varies across game variations, this method implements the logic for deciding when the game comes to a conclusion.

### UnoDeck
The `UnoDeck` class serves as a container for deck-related functionalities. As mentioned earlier, deck size and composition differ across game variations. To accommodate these variations, the `createDeck()` method needs to be implemented.

### UnoCard
The `UnoCard` interface heavily relies on polymorphism, abstracting the essential API for interacting with any Uno card, irrespective of its specific characteristics. Its primary methods include:
- Determining whether it can be placed on top of another card.
- Executing its associated action.

### Player
The pivotal method in this abstract class is `chooseACard()`, an abstract method that must be implemented based on the player type, whether Human or machine. The implementation for a Human Console player is outlined. Extending this abstract class to create an AI player is relatively straightforward, involving furnishing the necessary implementation for the `chooseACard()` method.

### GameManager
Monitoring the game state is a substantial responsibility that warrants a dedicated standalone class. This class minimizes direct accessibility to the game state, ensuring that card actions can be executed without exposing internal fields.
