# Arkanoid Game Screen Assignment

This project is a graphical representation of a screen from the classic game *Arkanoid*, implemented using JavaFX. It demonstrates proficiency in using variables, data types, loops, and conditional statements, as well as basic graphics programming with FX Graphics. The screen is divided into two distinct regions for game elements and display information, with user-defined parameters for customization.

## Project Structure

- `ArkanoidScreen.java.txt`: The main source file containing the JavaFX implementation of the Arkanoid screen.
- `design.pdf` or `design.docx`: Design document outlining the structure of the game screen, including the layout of the game and display regions.
- `README.md`: Project description and instructions.

## Assignment Requirements

The screen is divided into two main regions:
1. **Game Region**: Contains the grid of bricks, a ball, and a paddle.
2. **Display Region**: Displays the player's score, high score, and current level.

### User Inputs

Before the game screen is drawn, the program interacts with the user through a series of input prompts to gather the following information:
- Number of rows and columns for the brick grid.
- Current score, high score, and level.
- Ball position within the game region.
- Paddle's x-position within the game region.

The program validates user inputs to ensure they fall within acceptable ranges, and it adjusts the high score if the current score exceeds it.

### Output

After gathering user input, the program creates the Arkanoid screen:
- Draws a grid of bricks based on the specified rows and columns.
- Positions the ball and paddle as per user inputs.
- Displays the score, high score, and level in the display region.
- Separates the game and display regions with a visual boundary.

### Extra Challenges

1. **Use Images**: Replace simple shapes (e.g., rectangles, circles) with image files to create a more authentic game screen.
2. **Add Animation**: Implement movement for the paddle and ball using the FXAnimationTemplate.

## How to Run

1. Download or clone the repository.
2. Open `ArkanoidScreen.java.txt` in an IDE that supports JavaFX development.
3. Remove the `.txt` extension from the file.
4. Run the program and follow the input prompts to customize the game screen.
