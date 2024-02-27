import java.awt.*;
import javax.swing.*;

public class swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello world!");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);
        JButton button = new JButton("Hello world!", null);
        button.setLocation(30, 30);
        button.setAction(null);
    }
}
