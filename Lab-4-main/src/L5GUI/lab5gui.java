package L5GUI;

import javax.swing.SwingUtilities;

public class lab5gui {
    public static void main(String[] args) {
        // Запуск GUI в потоке EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> new WeaponAppGUI());
    }
}
