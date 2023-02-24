import java.awt.*;

public class CheckerBoardRow extends Canvas {

    public static void main(String[] args) {
        Frame frame = new Frame("Checkerboard Row");
        CheckerBoardRow canvas = new CheckerBoardRow();
        frame.add(canvas);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        int boxX = 12;
        int boxY = 50;
        int boxWidth = 60;
        int boxHeight = 53;
        int checkerX = 20;
        int checkerY = 55;
        int firstCheckerCol = 1;
        Color firstColor = Color.BLACK;
        Color secondColor = Color.RED;

        setBackground(Color.LIGHT_GRAY);

        // Draw the checkerboard boxes 
        for (int row = 1; row <= 8; row++) {
            for (int col = 1; col <= 8; col++) {
                g.setColor(firstColor);
                if (col % 2 == 0) {
                    g.setColor(secondColor);
                }
                g.fillRect(boxX, boxY, boxWidth, boxHeight);
                boxX += boxWidth;
            }
            boxY += boxHeight;
            boxX = 12;
            Color temp = firstColor;
            firstColor = secondColor;
            secondColor = temp;
        }

        // Draw the red checkers 
        checkerX = 20;
        checkerY = 55;
        for (int row = 1; row <= 3; row++) {
            if (row % 2 == 0) {
                checkerX = 20 + boxWidth;
            } else {
                checkerX = 20;
            }
            g.setColor(Color.RED);
            for (int col = firstCheckerCol; col <= 8; col += 2) {
                g.fillOval(checkerX, checkerY, 40, 40);
                checkerX += boxWidth * 2;
            }
            checkerY += boxHeight;
        }

        // Draw the black checkers
        checkerX = 20;
        checkerY = 55 + boxHeight * 5;
        for (int row = 5; row <= 8; row++) {
            if (row % 2 != 0) {
                checkerX = 20 + boxWidth;
            } else {
                checkerX = 20;
            }
            g.setColor(Color.BLACK);
            for (int col = firstCheckerCol; col <= 8; col += 2) {
                g.fillOval(checkerX, checkerY, 40, 40);
                checkerX += boxWidth * 2;
            }
            checkerY += boxHeight;
        }
    }
}