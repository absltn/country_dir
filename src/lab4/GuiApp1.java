package lab4;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.lang.String;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

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
        guiFrame.setSize(600,100);

        CSVReader newReader = new CSVReader();     // initialize new CSV reader to connect to simple DB
        guiFrame.setLocationRelativeTo(null);

        String[] countryBase = {"Belgium"};

        final JPanel comboPanel = new JPanel();
        JLabel comboLbl = new JLabel("Выберите страну");
        JComboBox countryList = new JComboBox(countryBase);

        comboPanel.add(comboLbl);
        comboPanel.add(countryList);

        comboPanel.setLayout(new GridLayout(2,1));
        final JTextField resultText = new JTextField();
        resultText.setEnabled(false);
        resultText.setSize(600,50);
        comboPanel.add(resultText);


        countryList.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox countryList = (JComboBox)e.getSource();
                        String selection = new String();
                        selection = (String)countryList.getSelectedItem();
                        String str = String.join(",",newReader.getInfo(selection));
                        resultText.setText(str);
                    }
                }
        );

        guiFrame.add(comboPanel);

        guiFrame.setVisible(true);
    }
}