// Controller for the Game of Life. 
// Initializes the grid, updates generations, and draws the grid on a canvas.

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.Random;

public class GameOfLifeController {
    
    @FXML
    private Canvas canvas;
    
    private boolean[][] lifeGrid = new boolean[10][10];

    public void initialize() {
        Random random = new Random();
        
        // Initialize the grid with random values
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                lifeGrid[i][j] = random.nextBoolean();
            }
        }
        drawLifeGrid();
    }
    
    // Draw the life grid on the Canvas
    private void drawLifeGrid() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        double cellWidth = canvas.getWidth() / 10;
        double cellHeight = canvas.getHeight() / 10;
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	
                // Draw filled square if alive, empty square if dead
                if (lifeGrid[i][j]) {
                    gc.fillRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
                } else {
                    gc.strokeRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }
    
    // Handle the next generation logic
    @FXML
    private void handleNextGeneration() {
        boolean[][] newLifeGrid = new boolean[10][10];
        
        // Calculate next generation
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int neighbors = countNeighbors(i, j);
                
                if (lifeGrid[i][j]) {
                    newLifeGrid[i][j] = neighbors == 2 || neighbors == 3;
                } else {
                    newLifeGrid[i][j] = neighbors == 3;
                }
            }
        }
        
        lifeGrid = newLifeGrid;  // Update the grid
        drawLifeGrid();  // Redraw the updated grid
    }

    // Count live neighbors of a cell
    private int countNeighbors(int row, int col) {
        int count = 0;
        
        // Check all 8 neighbors
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                
                int neighborRow = row + i;
                int neighborCol = col + j;
                
                if (neighborRow >= 0 && neighborRow < 10 && neighborCol >= 0 && neighborCol < 10) {
                    if (lifeGrid[neighborRow][neighborCol]) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
