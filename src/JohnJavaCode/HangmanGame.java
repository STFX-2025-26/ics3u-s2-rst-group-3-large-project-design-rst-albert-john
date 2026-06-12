package JohnJavaCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanGame extends JFrame implements ActionListener {
    private HangmanMethods gameLogic = new HangmanMethods();

    private JLabel wordDisplayLabel;
    private JLabel livesLabel;
    private JLabel pointsLabel;
    private JLabel feedbackLabel;
    private JTextField inputField;
    private JButton submitButton;
    private JButton newGameButton;

    public HangmanGame() {
        setTitle("Hangman Game");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("HANGMAN", SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, 434, 35);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        getContentPane().add(titleLabel);

        JPanel statusPanel = new JPanel();
        statusPanel.setBounds(0, 45, 434, 35);
        livesLabel = new JLabel("Lives: " + gameLogic.lives + "   ");
        livesLabel.setForeground(Color.RED);
        pointsLabel = new JLabel("Points: " + gameLogic.points);
        pointsLabel.setForeground(Color.GREEN);
        statusPanel.add(livesLabel);
        statusPanel.add(pointsLabel);
        getContentPane().add(statusPanel);

        wordDisplayLabel = new JLabel("", SwingConstants.CENTER);
        wordDisplayLabel.setBounds(0, 90, 434, 35);
        wordDisplayLabel.setFont(new Font("Arial", Font.BOLD, 20));
        getContentPane().add(wordDisplayLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setBounds(0, 135, 434, 35);
        inputPanel.add(new JLabel("Guess a letter: "));
        inputField = new JTextField(3);
        inputPanel.add(inputField);
        submitButton = new JButton("Submit");
        inputPanel.add(submitButton);
        getContentPane().add(inputPanel);

        feedbackLabel = new JLabel("", SwingConstants.CENTER);
        feedbackLabel.setBounds(0, 180, 434, 35);
        feedbackLabel.setForeground(Color.ORANGE);
        getContentPane().add(feedbackLabel);

        newGameButton = new JButton("New Game");
        newGameButton.setBounds(0, 225, 434, 35);
        getContentPane().add(newGameButton);

        submitButton.addActionListener(this);
        newGameButton.addActionListener(this);

        resetGame();
    }

    public void updateDisplay() {
        String displayWord = "";
        int currentPoints = 0;

        for (int i = 0; i < gameLogic.randomWord.length(); i++) {
            char currentLetter = gameLogic.randomWord.charAt(i);
            if (gameLogic.guessedLetters.contains(currentLetter)) {
                displayWord += currentLetter + " ";
                currentPoints++;
            } else {
                displayWord += "_ ";
            }
        }

        gameLogic.points = currentPoints;
        wordDisplayLabel.setText(displayWord.trim());
        livesLabel.setText("Lives: " + gameLogic.lives + "   ");
        pointsLabel.setText("Points: " + gameLogic.points);
    }

    public void checkWinLose() {
        if (gameLogic.points == 9) {
            JOptionPane.showMessageDialog(this, "You win!");
            inputField.setEnabled(false);
            submitButton.setEnabled(false);
        } else if (gameLogic.lives <= 0) {
            JOptionPane.showMessageDialog(this, "You lose! The word was: " + gameLogic.randomWord);
            inputField.setEnabled(false);
            submitButton.setEnabled(false);
        }
    }

    public void processGuess() {
        String userInput = inputField.getText().trim().toLowerCase();
        inputField.setText("");
        feedbackLabel.setText("");

        if (userInput.length() != 1 || !Character.isLetter(userInput.charAt(0))) {
            feedbackLabel.setText("error (Please enter exactly one letter)");
            return;
        }

        char guessedChar = userInput.charAt(0);

        if (gameLogic.guessedLetters.contains(guessedChar)) {
            feedbackLabel.setText("You already guessed that letter!");
            return;
        }

        gameLogic.guessedLetters.add(guessedChar);

        if (gameLogic.checkLetter(gameLogic.randomWord, guessedChar)) {
            updateDisplay();
        } else {
            gameLogic.lives--;
            updateDisplay();
        }

        checkWinLose();
    }

    private void resetGame() {
        gameLogic.randomWord = gameLogic.generateRandomWord();
        gameLogic.guessedLetters.clear();
        gameLogic.lives = 9;
        gameLogic.points = 0;
        feedbackLabel.setText("");
        inputField.setEnabled(true);
        submitButton.setEnabled(true);
        updateDisplay();
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            processGuess();
        } else if (e.getSource() == newGameButton) {
            resetGame();
        }
    }

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.setVisible(true);
    }
}
