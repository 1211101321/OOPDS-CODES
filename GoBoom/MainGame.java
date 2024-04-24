import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class MainGame {
    
    public void startGame() {
        Scanner input = new Scanner(System.in);
        Deck deck = new Deck();

        Card leadCard = deck.getCard(0); // Get the first card in the deck as the lead card
        deck.removeCard(0); // Remove the lead card from the deck

        // Create arrays to represent the hands of the players
        Card[][] playerHands = new Card[4][7];

        // Draw 7 cards for each player
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                playerHands[j][i] = deck.getCard(0); // Get the top card from the deck
                deck.removeCard(0); // Remove the drawn card from the deck
            }
        }

        // Create instances of the Player class
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");

        // Assign cards from playerHands array to each player
        for (int i = 0; i < 7; i++) {
            player1.addCard(playerHands[0][i]);
            player2.addCard(playerHands[1][i]);
            player3.addCard(playerHands[2][i]);
            player4.addCard(playerHands[3][i]);
        }

        ArrayList<Card> centerArray = new ArrayList<>();
        centerArray.add(leadCard);

        // Print out the cards in the players' hands
        int trickCount = 1; // Initialize trick count
        Player highestPlayer = null; // Declare highestPlayer variable
        while (true) {
            Scanner scanner = new Scanner(System.in);

            // Ask the user if they want to load a saved game
            System.out.println("\n");
            System.out.print("Do you want to load a saved game? (y/n): ");
            String loadOption = scanner.next();

            if (loadOption.equalsIgnoreCase("y")) {
                System.out.print("Enter the file name to load: ");
                String fileName = scanner.next();
                loadGame(fileName, leadCard, deck, playerHands, null, centerArray, trickCount);
            } else {
                // Start a new game
                System.out.println("\n");
                System.out.println("Trick #" + trickCount); // Perform trick logic here
                System.out.println(player1);
                System.out.println(player2);
                System.out.println(player3);
                System.out.println(player4);
                System.out.println("Center  : " + centerArray.toString()); // The center card
                System.out.println(deck);
                System.out.println("Score   : Player1 = " + player1.getScore() + " | Player2 = " + player2.getScore() + " | Player3 = " + player3.getScore() + " | Player4 = " + player4.getScore() + " |");

                // First player determination
                Player firstPlayer = determineFirstPlayer(leadCard, player1, player2, player3, player4, trickCount);
                System.out.println("Turn " + firstPlayer);

                for (int i = 0; i < 4; i++) {
                    String userInput;

                    // Rotate the players' turns
                    Player currentPlayer = firstPlayer;
                    firstPlayer = getNextPlayer(firstPlayer, player1, player2, player3, player4);
                    System.out.print("> ");
                    userInput = scanner.next();

                    switch (userInput) { // what the user entered
                        case "menu": // display all the game controls
                            System.out.println("\n");
                            gameMenu.gameControl();
                        case "r": // resets the game
                            System.out.println("\n");
                            resetGame();
                        case "x": // exits the game
                            System.exit(0);
                        case "d": // Draw cards from deck
                            while (deck.getDeckSize() > 0) {
                                String result = currentPlayer.drawCard(centerArray, deck);
                                if (result.equals("success")) {
                                    break;
                                } else if (result.equals("error")) {
                                    break;
                                }
                            }
                            break;
                        default:
                            try {
                                if (currentPlayer.playCard(userInput, centerArray)) {
                                    break;
                                } else {
                                    System.out.println("Invalid input, please enter again.\n");
                                }
                            } catch (Exception e) {
                                System.out.println("An error occurred: " + e.getMessage());
                                System.out.println("Please enter a valid input.\n");
                            }
                            break;
                    }
                    System.out.println("\n");
                    System.out.println("Trick #" + trickCount);
                    System.out.println(player1);
                    System.out.println(player2);
                    System.out.println(player3);
                    System.out.println(player4);
                    System.out.println("Center  : " + centerArray.toString()); // The center card
                    System.out.println(deck);
                    System.out.println("Score   : Player1 = " + player1.getScore() + " | Player2 = " + player2.getScore() + " | Player3 = " + player3.getScore() + " | Player4 = " + player4.getScore() + " |");
                    System.out.println("Turn " + firstPlayer);
                }
                System.out.println("\n");

                // Determine the trick winner
                highestPlayer = determineFirstPlayer(leadCard, player1, player2, player3, player4, trickCount);
                System.out.println("*****Winner of Trick#" + trickCount + " is " + highestPlayer.getPlayerName() + "*****");
                System.out.println("\n");

                // Increment trick count
                trickCount++;
                
                //This will add score to a player after trick
                Card highestCard = highestPlayer.getPlayedCard();
                highestPlayer.addScore(highestCard);

                // Clear the centerArray after every trick
                centerArray.clear(); 

                // Ask the user if they want to save the game before exiting
                System.out.print("Do you want to save the game before exiting? (y/n): ");
                String saveOption = scanner.next();

                if (saveOption.equalsIgnoreCase("y")) {
                    System.out.print("Enter the file name to save: ");
                    String fileName = scanner.next();
                    saveGame(fileName, leadCard, deck, playerHands, new Player[] { player1, player2, player3, player4 },
                            centerArray, trickCount);
                }
            }
        }
    }

    private static Player determineFirstPlayer(Card leadCard, Player player1, Player player2, Player player3, Player player4, int trickCount) {
        if (trickCount == 1) { //switch case that assigns the lead card the first, second , third, fourth player
            switch (leadCard.getValue()) {
                case cA, c5, c9, cK, sA, s5, s9, sK, dA, d5, d9, dK, hA, h5, h9, hK:
                    return player1;
                case c2, c6, c10, s2, s6, s10, d2, d6, d10, h2, h6, h10:
                    return player2;
                case c3, c7, cJ, s3, s7, sJ, d3, d7, dJ, h3, h7, hJ:
                    return player3;
                case c4, c8, cQ, s4, s8, sQ, d4, d8, dQ, h4, h8, hQ:
                    return player4;
            }
        }

        // Use the original logic to determine the winner for subsequent tricks

        Player highestPlayer = player1; //higehst player 1 default
        Card highestCard = player1.getPlayedCard();

        if (player1.getPlayedCard() != null && !player1.getPlayedCard().equals("d") && player1.getPlayedCard().getValue().getCardValue() > highestCard.getValue().getCardValue()) {
            highestPlayer = player1;
            highestCard = player1.getPlayedCard();
        }
        if (player2.getPlayedCard() != null && !player2.getPlayedCard().equals("d") && player2.getPlayedCard().getValue().getCardValue() > highestCard.getValue().getCardValue()) {
            highestPlayer = player2;
            highestCard = player2.getPlayedCard();
        }
        if (player3.getPlayedCard() != null && !player3.getPlayedCard().equals("d") && player3.getPlayedCard().getValue().getCardValue() > highestCard.getValue().getCardValue()) {
            highestPlayer = player3;
            highestCard = player3.getPlayedCard();
        }
        if (player4.getPlayedCard() != null && !player4.getPlayedCard().equals("d") && player4.getPlayedCard().getValue().getCardValue() > highestCard.getValue().getCardValue()) {
            highestPlayer = player4;
            highestCard = player4.getPlayedCard();
        }
        return highestPlayer;
    }

    // Helper method to get the next player in a clockwise rotation
    private static Player getNextPlayer(Player currentPlayer, Player player1, Player player2, Player player3,
            Player player4) {
        if (currentPlayer == player1) {
            return player2;
        } else if (currentPlayer == player2) {
            return player3;
        } else if (currentPlayer == player3) {
            return player4;
        } else {
            return player1;
        }
    }

    private static void saveGame(String fileName, Card leadCard, Deck deck, Card[][] playerHands, Player[] players, ArrayList<Card> centerArray, int trickCount) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(leadCard);
            out.writeObject(deck);
            out.writeObject(playerHands);
            out.writeObject(players);
            out.writeObject(centerArray);
            out.writeInt(trickCount);
            out.close();
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save the game: " + e.getMessage());
        }
    }

    //load game function but doesnt really work


    private static void loadGame(String fileName, Card leadCard, Deck deck, Card[][] playerHands, Player[] players, ArrayList<Card> centerArray, int trickCount) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            leadCard = (Card) in.readObject();
            deck = (Deck) in.readObject();
            playerHands = (Card[][]) in.readObject();
            players = (Player[]) in.readObject();
            centerArray = (ArrayList<Card>) in.readObject();
            trickCount = in.readInt();
            in.close();

            // Set the loaded game state
            Deck.setInstance(deck); // Set the loaded deck instance

            // Update player hands
            Player player1 = players[0];
            Player player2 = players[1];
            Player player3 = players[2];
            Player player4 = players[3];

            for (int i = 0; i < 7; i++) {
                player1.addCard(playerHands[0][i]);
                player2.addCard(playerHands[1][i]);
                player3.addCard(playerHands[2][i]);
                player4.addCard(playerHands[3][i]);
            }

            // Update center array
            ArrayList<Card> updatedCenterArray = new ArrayList<>(centerArray.size());
            for (Card card : centerArray) {
                updatedCenterArray.add(new Card(card.getSuit(), card.getValue()));
            }

            // Update lead card
            Card updatedLeadCard = new Card(leadCard.getSuit(), leadCard.getValue());

            System.out.println("Game loaded successfully."); //exeption messages
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load the game: " + e.getMessage());
        }
    }

    public void resetGame(){ //reset game method
        MainGame reset = new MainGame();
        reset.startGame();
    }
}
