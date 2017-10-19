package lab4;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.lang.String;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.Color;

public class GuiApp1 {

    public static void main(String[] args) {
        new GuiApp1();
    }

    public GuiApp1()
    {
        JFrame guiFrame = new JFrame();

        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Country directory");
        guiFrame.setSize(600,400);

        CSVReader newReader = new CSVReader();     // initialize new CSV reader to connect to simple DB
        guiFrame.setLocationRelativeTo(null);

        String[] countryBase = {"Angola", "Azerbaijan", "Albania", "Equatorial Guinea"};

        final JPanel comboPanel = new JPanel();
        comboPanel.setLayout(new GridLayout(3,1));
        JLabel comboLbl = new JLabel("Выберите страну");
        JComboBox countryList = new JComboBox(countryBase);

        comboPanel.add(comboLbl);
        comboPanel.add(countryList);

        final JTextArea resultText = new JTextArea();
        resultText.setEnabled(true);
        resultText.setFocusable(true);
        resultText.setLineWrap(true);
        resultText.setForeground(Color.BLACK);
        comboPanel.add(resultText);


        countryList.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox countryList = (JComboBox)e.getSource();
                        String selection;
                        selection = (String)countryList.getSelectedItem();
                        String str = newReader.getInfo(selection);
                        resultText.setText(str);
                    }
                }
        );

        guiFrame.add(comboPanel);
        guiFrame.setVisible(true);
    }
}