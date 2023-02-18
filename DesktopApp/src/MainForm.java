import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainPanel;
    private JButton button;
    private JPanel buttonPanel;
    private JTextField name;
    private JTextField surname;
    private JTextField patronymic;
    private JPanel jPanel;
    private JTextField newName;
    private JTextField newPatronymic;

    public MainForm() {
        button.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.getLabel().equals("Collapse")) {
                    collapseAction();
                } else {
                    expandAction();
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void collapseAction() {
        if (name.getText().isEmpty() || surname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Введите фамилию и имя",
                    "Недостаточно данных",
                    JOptionPane.PLAIN_MESSAGE
            );
        } else {
            button.setLabel("Expand");
            surname.setText(surname.getText() + " " +
                    name.getText() + " " + patronymic.getText());
            jPanel.remove(name);
            jPanel.remove(patronymic);
        }
    }

    public void expandAction() {
        String data = surname.getText();
        String[] words = data.split(" ");
        int dataLength = words.length;
        if (dataLength < 2 || dataLength > 3) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Введите фамилию и имя",
                    "Недостаточно данных",
                    JOptionPane.PLAIN_MESSAGE
            );
        } else {
            button.setLabel("Collapse");
            name = new JTextField(words[1]);
            if (dataLength == 3) {
                patronymic = new JTextField(words[2]);
            } else {
                patronymic = new JTextField(7);
            }
            jPanel.add(name);
            jPanel.add(patronymic);
            surname.setText(words[0]);
        }
    }
}