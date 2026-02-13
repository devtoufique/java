import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MatrixRainInterface extends JPanel {
    private int[] yPositions;
    private Random rand = new Random();
    private int columnCount = 0;

    public MatrixRainInterface() {
        setBackground(Color.BLACK);

        Timer timer = new Timer(50, e -> repaint());
        timer.start();
    }

    private void updateColumns() {
        int width = getWidth();
        int colWidth = 20;
        int requiredColumns = (width / colWidth) + 1;

        if (requiredColumns != columnCount) {
            int[] newPositions = new int[requiredColumns];
            if (yPositions != null) {
                System.arraycopy(yPositions, 0, newPositions, 0, Math.min(yPositions.length, newPositions.length));
            }
            for (int i = columnCount; i < requiredColumns; i++) {
                newPositions[i] = rand.nextInt(Math.max(1, getHeight()));
            }
            yPositions = newPositions;
            columnCount = requiredColumns;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        updateColumns();

        g.setColor(new Color(0, 0, 0, 25));
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.GREEN);
        g.setFont(new Font("Monospaced", Font.BOLD, 18));

        if (yPositions != null) {
            for (int i = 0; i < columnCount; i++) {
                char c = (char) (rand.nextInt(93) + 33);
                g.drawString(String.valueOf(c), i * 20, yPositions[i]);

                if (yPositions[i] > getHeight() || rand.nextFloat() > 0.97) {
                    yPositions[i] = 0;
                } else {
                    yPositions[i] += 20;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Matrix Rain");
            MatrixRainInterface matrix = new MatrixRainInterface();

            frame.add(matrix);
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}