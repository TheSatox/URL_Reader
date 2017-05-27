/**
 * Created by magnus on 2017-01-27.
 */
// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it.

import javax.swing.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField typeUrl = new JTextField(10);
    private JButton viewLinks = new JButton("Hitta länkar");
    private JTextArea linkList = new JTextArea(10, 4);

    CalculatorView() {
        // Sets up the view and adds the components
        JPanel calcPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        calcPanel.add(typeUrl);
        calcPanel.add(viewLinks);
        calcPanel.add(linkList);
        this.add(calcPanel);
        // End of setting up the components --------
    }

    public int getFirstNumber() {
        return Integer.parseInt(typeUrl.getText());
    }


    public int getCalcSolution() {
        return Integer.parseInt(linkList.getText());
    }

    public void setCalcSolution(int solution) {
        linkList.setText(Integer.toString(solution));
    }

    // If the calculateButton is clicked execute a method
    // in the Controller named actionPerformed
    void addCalculateListener(ActionListener listenForCalcButton) {
        viewLinks.addActionListener(listenForCalcButton);
    }

    // Open a popup that contains the error message passed
    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}