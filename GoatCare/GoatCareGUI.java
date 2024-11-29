
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class GoatCareGUI {

    private final GoatManager manager;

    public GoatCareGUI() {
        manager = new GoatManager();
        initUI();
    }

    private void initUI() {
        JFrame frame = new JFrame("GoatCare Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel addPanel = new JPanel(new GridLayout(4, 2));
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField breedField = new JTextField();
        JButton addButton = new JButton("Add Goat");

        addPanel.add(new JLabel("Name:"));
        addPanel.add(nameField);
        addPanel.add(new JLabel("Age:"));
        addPanel.add(ageField);
        addPanel.add(new JLabel("Breed:"));
        addPanel.add(breedField);
        addPanel.add(new JLabel());
        addPanel.add(addButton);

        DefaultListModel<String> goatListModel = new DefaultListModel<>();
        JList<String> goatList = new JList<>(goatListModel);
        JScrollPane scrollPane = new JScrollPane(goatList);

        addButton.addActionListener((ActionEvent e) -> {
            try {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String breed = breedField.getText();

                manager.addGoat(name, age, breed);
                goatListModel.addElement(name + " (" + breed + ")");
                nameField.setText("");
                ageField.setText("");
                breedField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Age must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(addPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GoatCareGUI::new);
    }
}
