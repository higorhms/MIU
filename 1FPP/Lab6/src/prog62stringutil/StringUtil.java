package prog62stringutil;

import javax.swing.*;
import java.awt.*;

public class StringUtil extends JFrame {
    private JTextField input = new JTextField(12), output = new JTextField(12);

    public  StringUtil(){
        JPanel mainPanel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Lab 6 - String Util");
        setSize(430, 150);
        setResizable(false);

        mainPanel.add(createLeftBlock());
        mainPanel.add(createRightBlock());
        getContentPane().add(mainPanel);
        setVisible(true);
    }

    private JPanel createRightBlock(){
        JPanel rightBlock = new JPanel(new BorderLayout());
        rightBlock.add(createBlock("Input", this.input), BorderLayout.NORTH);
        rightBlock.add(createBlock("Output", this.output), BorderLayout.SOUTH);
        return rightBlock;
    }

    private JPanel createLeftBlock(){
        JPanel leftBlock = new JPanel(new BorderLayout());

        JButton countLettersButton = new JButton("Count letters");
        countLettersButton.addActionListener((e) -> countLettersListener());
        leftBlock.add(countLettersButton, BorderLayout.NORTH);

        JButton reverseLettersButton = new JButton("Reverse letters");
        reverseLettersButton.addActionListener((e) -> reverseLettersListener());
        leftBlock.add(reverseLettersButton, BorderLayout.CENTER);


        JButton removeDuplicatesButton = new JButton("Remove Duplicates");
        removeDuplicatesButton.addActionListener((e) -> removeDuplicatesListener());
        leftBlock.add(removeDuplicatesButton, BorderLayout.SOUTH);

        return leftBlock;
    }

    private JPanel createBlock(String name, JTextField field){
      JPanel blockPanel = new JPanel(new BorderLayout());
      JLabel blockLabel = new JLabel(name);
      blockPanel.add(blockLabel, BorderLayout.NORTH);
      blockPanel.add(field, BorderLayout.CENTER);
      return blockPanel;
    }

    private void countLettersListener(){
        this.output.setText(String.valueOf(this.input.getText().length()));
    }

    private void reverseLettersListener(){
        String aux = "";
        String inputText = this.input.getText();

        for(int index = inputText.length() - 1; index >=0; index-- ){
            aux += inputText.charAt(index);
        }

        this.output.setText(aux);
    }

    private void removeDuplicatesListener(){
        String aux = "";
        String inputText = this.input.getText();

        for(int index = 0; index < inputText.length(); index++){
            if(!aux.contains(String.valueOf(inputText.charAt(index)))){
                aux += inputText.charAt(index);
            }
        }

        this.output.setText(aux);
    }

    public static void main(String[] args) {
        new StringUtil();
    }
}
