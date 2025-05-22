import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BiodataForm  {
    public static void main(String[] args) {
        JFrame frame = new JFrame(" Biodata Form");

        JPanel panel = new JPanel() {
            private Image backgroundImage = new ImageIcon("BIODATA.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        JLabel heading = new JLabel("Enter Your Biodata");
        heading.setFont(new Font("Georgia", Font.BOLD, 28));
        heading.setBounds(130, 20, 300, 40);
        panel.add(heading);

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        nameLabel.setBounds(50, 80, 120, 30);
        nameField.setBounds(180, 80, 200, 30);
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        ageLabel.setBounds(50, 120, 120, 30);
        ageField.setBounds(180, 120, 200, 30);
        panel.add(ageLabel);
        panel.add(ageField);

        JLabel regdLabel = new JLabel("Regd No:");
        JTextField regdField = new JTextField();
        regdLabel.setBounds(50, 160, 120, 30);
        regdField.setBounds(180, 160, 200, 30);
        panel.add(regdLabel);
        panel.add(regdField);

        JLabel branchLabel = new JLabel("Branch:");
        String[] branches = { "CSE", "CSE-AIML", "IT" };
        JComboBox<String> branchBox = new JComboBox<>(branches);
        branchLabel.setBounds(50, 200, 120, 30);
        branchBox.setBounds(180, 200, 200, 30);
        panel.add(branchLabel);
        panel.add(branchBox);

        JLabel semLabel = new JLabel("Semester:");
        JTextField semField = new JTextField();
        semLabel.setBounds(50, 240, 120, 30);
        semField.setBounds(180, 240, 200, 30);
        panel.add(semLabel);
        panel.add(semField);

        JLabel mobileLabel = new JLabel("Mobile No:");
        JTextField mobileField = new JTextField();
        mobileLabel.setBounds(50, 280, 120, 30);
        mobileField.setBounds(180, 280, 200, 30);
        panel.add(mobileLabel);
        panel.add(mobileField);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        emailLabel.setBounds(50, 320, 120, 30);
        emailField.setBounds(180, 320, 200, 30);
        panel.add(emailLabel);
        panel.add(emailField);

        JLabel addressLabel = new JLabel("Home Address:");
        JTextField addressField = new JTextField();
        addressLabel.setBounds(50, 360, 120, 30);
        addressField.setBounds(180, 360, 200, 30);
        panel.add(addressLabel);
        panel.add(addressField);

        JLabel hobbiesLabel = new JLabel("Hobbies:");
        JCheckBox coding = new JCheckBox("CODING");
        JCheckBox games = new JCheckBox("PLAYING GAMES");
        JCheckBox reading = new JCheckBox("READING BOOKS");
        JCheckBox painting = new JCheckBox("PAINTING");
        JCheckBox dancing = new JCheckBox("DANCING");
        JCheckBox singing = new JCheckBox("SINGING");

        hobbiesLabel.setBounds(50, 400, 120, 30);
        coding.setBounds(180, 400, 150, 25);
        games.setBounds(180, 430, 150, 25);
        reading.setBounds(180, 460, 150, 25);
        painting.setBounds(180, 490, 150, 25);
        dancing.setBounds(180, 520, 150, 25);
        singing.setBounds(180, 550, 150, 25);

        coding.setOpaque(false);
        games.setOpaque(false);
        reading.setOpaque(false);
        painting.setOpaque(false);
        dancing.setOpaque(false);
        singing.setOpaque(false);

        panel.add(hobbiesLabel);
        panel.add(coding);
        panel.add(games);
        panel.add(reading);
        panel.add(painting);
        panel.add(dancing);
        panel.add(singing);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(180, 600, 120, 40);
        submitButton.setFont(new Font("Cambria", Font.BOLD, 16));
        panel.add(submitButton);

        frame.add(panel);
        frame.setSize(500, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        submitButton.addActionListener(e -> {
            JFrame outputFrame = new JFrame("Your Biodata");
        
            JPanel outputPanel = new JPanel() {
                private Image backgroundImage = new ImageIcon("biodata1.jpg").getImage();
        
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            };
            outputPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(8, 10, 8, 10);
            gbc.anchor = GridBagConstraints.WEST;
        
            Font headingFont = new Font("Georgia", Font.BOLD, 30);
            Font labelFont = new Font("Segoe UI", Font.PLAIN, 20);
            Color textColor = Color.WHITE;
        
            JLabel title = new JLabel("Biodata Details");
            title.setFont(headingFont);
            title.setForeground(textColor);
            gbc.gridwidth = 2;
            gbc.gridx = 0;
            gbc.gridy = 0;
            outputPanel.add(title, gbc);
        
            gbc.gridwidth = 1;
        
            String[][] info = {
                {"Name:", nameField.getText()},
                {"Age:", ageField.getText()},
                {"Regd No.:", regdField.getText()},
                {"Branch:", (String) branchBox.getSelectedItem()},
                {"Semester:", semField.getText()},
                {"Mobile No.:", mobileField.getText()},
                {"Email:", emailField.getText()},
                {"Home Address:", addressField.getText()}
            };
        
            int y = 1;
            for (String[] pair : info) {
                JLabel label = new JLabel(pair[0]);
                label.setFont(labelFont);
                label.setForeground(textColor);
                gbc.gridx = 0;
                gbc.gridy = y;
                outputPanel.add(label, gbc);
        
                JLabel value = new JLabel(pair[1]);
                value.setFont(new Font("Segoe UI", Font.BOLD, 20));
                value.setForeground(textColor);
                gbc.gridx = 1;
                outputPanel.add(value, gbc);
        
                y++;
            }
        
            StringBuilder hobbies = new StringBuilder();
            if (coding.isSelected()) hobbies.append("CODING, ");
            if (games.isSelected()) hobbies.append("PLAYING GAMES, ");
            if (reading.isSelected()) hobbies.append("READING BOOKS, ");
            if (painting.isSelected()) hobbies.append("PAINTING, ");
            if (dancing.isSelected()) hobbies.append("DANCING, ");
            if (singing.isSelected()) hobbies.append("SINGING, ");
            if (hobbies.length() > 0) hobbies.setLength(hobbies.length() - 2);
        
            JLabel hobbyLabel = new JLabel("Hobbies:");
            hobbyLabel.setFont(labelFont);
            hobbyLabel.setForeground(textColor);
            gbc.gridx = 0;
            gbc.gridy = y;
            outputPanel.add(hobbyLabel, gbc);
        
            JLabel hobbyValue = new JLabel(hobbies.toString());
            hobbyValue.setFont(new Font("Segoe UI", Font.BOLD, 20));
            hobbyValue.setForeground(textColor);
            gbc.gridx = 1;
            outputPanel.add(hobbyValue, gbc);
        
            outputFrame.add(outputPanel);
            outputFrame.setSize(800, 800);
            outputFrame.setLocationRelativeTo(null);
            outputFrame.setVisible(true);
        });
    }
}
