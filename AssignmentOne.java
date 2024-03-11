package assignmentOne;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * My program creates a Canvas using JavaFX and uses user inputs, methods, constants, data conversion,
 * if statements/loops, and different variable types to replicate a game screen similar to Arkanoid on the NES.
 * The program prints a custom image as the ball, a custom image as the paddle, text, and shapes.
 * @author BRENDAN DILEO, 000879513
 **/

@SuppressWarnings("ALL")
public class AssignmentOne extends Application {

    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(600, 600); // Set canvas Size in Pixels (600 x 600)
        stage.setTitle("Brendan's Game"); // Name of my game
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Creates Scanner class/object and variable name 'sc' which takes user input from keyboard
        Scanner sc = new Scanner(System.in);


        // *** Input and Data Validation


        // Rows are set to 0 as default expecting user input
        // Enters a 'while' loop to keep prompting the user if they enter values less than 1, or greater than 10
        // Correct value is assigned to 'rows'
        // The nested 'if' statement will tell the user if the values entered are within the given range
        int rows = 0;
        while (rows < 1 || rows > 10) {
            System.out.println("How many rows? (Between 1 and 10): ");
            rows = sc.nextInt();

            if (rows < 1 || rows > 10) {
                System.out.println("Invalid input. Needs to be between 1 and 10!");
            }
        }

        // Columns are set to 0 as default expecting user input
        // Enters a 'while' loop to keep prompting the user if they enter values less than 1, or greater than 10
        // Correct value is assigned to 'columns'
        // The nested 'if' statement will tell the user if the values entered are within the given range
        int columns = 0;
        while (columns < 1 || columns > 10) {
            System.out.println("How many columns? (Between 1 and 10): ");
            columns = sc.nextInt();

            if (columns < 1 || columns > 10) {
                System.out.println("Invalid input. Needs to be between 1 and 10!");
            }
        }

        // Asks user what the current score is and what the high score is
        // Assigns the current score to 'currentScore' and high score to 'highScore'
        System.out.println("What is the current score, and what is the high score? " +
                "(Please use a space to separate values)");
        int currentScore = sc.nextInt();
        int highScore = sc.nextInt();

        // Uses an 'if' statement to determine if the current score is higher than the high score
        // If the current score is higher than the high score, current score is assigned to high score
        // Congratulates user if they got a high score
        if (currentScore > highScore) {
            highScore = currentScore;
            System.out.println("Congratulations! That's a new record!");
        }

        // Asks user what wave they are on
        // Assigns value to 'wave' var as type integer
        System.out.println("What wave are you currently on?");
        int wave = sc.nextInt();

        // Ball position on 'x' axis is set to 0 as default
        // Enters a 'while' loop to keep prompting the user if they enter a value less than 1 or greater than 380
        // Values less than 1 or greater than 380 will appear off the screen or in the display region
        // Valid 'x' position will be assigned to 'ball_x_pos'
        double ball_x_pos = 0;
        while (ball_x_pos < 1 || ball_x_pos > 380) {
            System.out.println("Please enter the 'x' position the ball is at: ");
            ball_x_pos = sc.nextDouble();

            // The nested 'if' statement will tell the user if the value is within the correct range (1 - 380)
            if (ball_x_pos < 1 || ball_x_pos > 380) {
                System.out.println("The ball is outside the game region. Must be between 1 - 380 on the 'x' axis!");
            }
        }

        // Ball positsion on 'y' axis is set to 0 as default
        // Enters a 'while' loop to keep prompting the user if they enter a values less than 330, or greater than 550
        // Values less than 330 or greater than 550 will appear touching the bricks, or beneath the paddle
        // Valid 'y' axis postision will be assigned to 'ball_y_pos'
        double ball_y_pos = 0;
        while (ball_y_pos < 330 || ball_y_pos > 550) {
            System.out.println("Enter the 'y' position the ball is at: (Enter 550 for the ball to be at paddle)  ");
            ball_y_pos = sc.nextDouble();

            // The nested 'if' statement will tell the user if the value is within the correct range (330 - 550)
            if (ball_y_pos < 330 || ball_y_pos > 550) {
                System.out.println("The ball is already touching the bricks. Needs to start lower!");
            }
        }

        // Paddle position is set to 0 as default
        // Enters a 'while' loop to keep prompting the user if they enter a value less than 1 or greater than 320
        // Values less than 1 or greater than 320 will appear off the screen or in the display region
        // Valid position will be assigned to 'paddle_x_pos', 'y' postision is preset as a constant
        double paddle_x_pos = 0;
        while (paddle_x_pos < 1 || paddle_x_pos > 320) {
            System.out.println("Enter the 'x' position the paddle is at: ");
            paddle_x_pos = sc.nextDouble();

            // The nested 'if' statement will tell the user if the value is within the correct range (1 - 320)
            if (paddle_x_pos < 1 || paddle_x_pos > 320) {
                System.out.println("The paddle is outside the game region. Must be between 1 - 320!");
            }
        }

        // *** PROCCESSING

        // Sets the background to BLACK using a RECT
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 600, 600);

        // Creates a divider between the game region and display region
        gc.setFill(Color.GREEN);
        gc.fillRect(400, 0, 10, 600); // Game region is between 0-350

        // Creates a rectangle around the game name using 'setStroke' and 'strokeRect' to create a border
        gc.setStroke(Color.WHITE);
        gc.strokeRect(420, 5, 150, 30);

        // Creates text and initializes font as 'gameFont'
        gc.setFill(Color.RED);
        Font gameFont = (new Font("Franklin Gothic Medium", 20));
        gc.setFont(gameFont);
        gc.fillText("Brendan's Game", 425, 25);

        // Creates a rectangle around the Score using 'setStroke' and 'strokeRect' to create a border
        gc.setStroke(Color.WHITE);
        gc.strokeRect(420, 55, 60, 25);

        // Creates text for the Score
        gc.setFill(Color.RED);
        gc.setFont(gameFont);
        gc.fillText("Score", 425, 75);

        // Creates text for Score converting user entered Input from an int to a String
        gc.setFill(Color.YELLOW);
        gc.fillText(Integer.toString(currentScore), 425, 100);

        // Creates a rectangle around the High Score using 'setStroke' and 'strokeRect' to create a border
        gc.setStroke(Color.WHITE);
        gc.strokeRect(420, 130, 100, 25);

        // Creates text for High Score
        gc.setFill(Color.RED);
        gc.setFont(gameFont);
        gc.fillText("High Score", 425, 150);

        // Creates text for High Score converting user input from an int to a String
        gc.setFill(Color.YELLOW);
        gc.fillText(Integer.toString(highScore), 425, 175);

        // Creates a rectangle around the Wave using 'setStroke' and 'strokeRect' to create a border
        gc.setStroke(Color.WHITE);
        gc.strokeRect(420, 205, 60, 25);

        // Creates text for Wave
        gc.setFill(Color.RED);
        gc.setFont(gameFont);
        gc.fillText("Wave", 425, 225);

        // Creates text for Wave converting user input from an int to a String
        gc.setFill(Color.YELLOW);
        gc.fillText(Integer.toString(wave), 425, 250);

        // Creates Image class/object and variable name 'ballImage' to display a pokeball as the ball
        Image ballImage = new Image("images/pokeball.png");

        // Creates the ball using 'drawImage' with predefined image
        // and places it at user entered 'x' and 'y' coordinate from 'ball_x_pos' and 'ball_y_pos' var
        gc.drawImage(ballImage, ball_x_pos, ball_y_pos, 20, 20);

        // Creates Image class/object and var name 'paddleImage' to display Pokemon themed paddle
        Image paddleImage = new Image("images/paddle.png");

        // Creates the paddle using 'drawImage' with predefined image
        // and places it at user entered 'x' coordinate from 'paddle_x_pos' var
        gc.drawImage(paddleImage, paddle_x_pos, 555, 60, 50);

        // 'topLayer' is a constant showing the 'y' coordinate where the bricks will start
        final int TOP_LAYERY = 50;

        // 'startingPointX' is a constant showing the 'x' coordinate where the bricks will start
        final int STARTING_POINTX = 15;

        // 'widthOfBrick' is a constant showing the width of each brick
        final int WIDTH_OF_BRICK = 30;

        // 'heightOfBrick' is a constant showing the height of each brick
        final int HEIGHT_OF_BRICK = 20;

        // 'brickSpacingX' is a constant showing the spacing between the bricks on the 'x' axis
        final int BRICK_SPACINGX = 8;

        // 'brickSpacingY' is a constant showing the spacing between the bricks on the 'y' axis
        final int BRICK_SPACINGY = 8;

        // Creates text to cite images found on web used as ball and paddle
        gc.setFill(Color.RED);
        gc.setFont(gameFont);
        gc.fillText("Sources:", 450, 570);

        // Creates new font as 'smallFont' to fit the sources of images on screen
        // Creates text for specific citation information using 'gc.fillText'
        Font smallFont = (new Font("Franklin Gothic Medium", 12));
        gc.setFont(smallFont);
        gc.fillText("pokemongohub.net - @avrip", 425, 580);
        gc.fillText("Dec.7.2021", 425, 590 );

        // *** PROCCESSING / OUTPUT

        // Uses a 'for' loop to place bricks into rows
        // 'i' is the control variable which is iterated through depending on the user input 'rows'
        // 'brickY' is a variable for the 'y' coordinate which is determined by where they start 'TOP_LAYERY' and
        // the number of iterations 'i' for the number of rows and determines the height as 'HEIGHT_OF_BRICK'
        for (int i = 0; i < rows; i++) {
            int brickY = TOP_LAYERY + i * (HEIGHT_OF_BRICK + BRICK_SPACINGY);

            // Uses an inner 'for' loop to place bricks into columns
            // 'count' is the control variable which is iterated through depending on user input 'columns'
            // 'brickX' is a variable for the 'x' coordinate which is determined by where the 'STARTING_POINTX' and
            // the number of iterations 'count' for the number of columns and determines the width as 'WIDTH_OF_BRICK'
            for (int count = 0; count < columns; count++) {
                int brickX = STARTING_POINTX + count * (WIDTH_OF_BRICK + BRICK_SPACINGX);

                // Creating random colors for each brick in the loop using 'Math.random()' * 100 which generates
                // random value and stores in variables 'myRandomColor' where 'Color' is replaced with Red, Green, or Blue
                int myRandomRed = (int) (Math.random() * 150);
                int myRandomBlue = (int) (Math.random() * 150);
                int myRandomGreen = (int) (Math.random() * 150);

                // Creates the bricks using 'fillRect' and takes 'brickX' and 'brickY' as coordinates
                // Uses random colors to assign brick color
                // WIDTH_OF_BRICK and HEIGHT_OF_BRICK as the height and width
                gc.setFill(Color.rgb(myRandomRed, myRandomBlue, myRandomGreen));
                gc.fillRect(brickX, brickY, WIDTH_OF_BRICK, HEIGHT_OF_BRICK);
            }
        }

        // My code ends here
        stage.show();
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
