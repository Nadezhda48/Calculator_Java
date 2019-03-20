import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class CalculatorForm extends JFrame implements ActionListener, MouseListener {

    private JLabel label;
    private JButton button1, button4, button7, button0;
    private JButton button2, button5, button8, buttonDivide;
    private JButton button3, button6, button9, buttonC;
    private JButton buttonDot, buttonEquals, buttonPlus, buttonMinus;
    private JButton buttonMultiply, buttonBackSpace;
    private JPanel panel;

    CalculatorForm(){
        super("Calculator");
        this.setSize(450, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        label = new JLabel("");
        label.setBounds(100,20,400,25);
        panel.add(label);
        panel.setBackground(new Color(0xFFffdbfd));

        buttonC = new JButton("C");
        buttonC.setBounds(220,60,110,30);
        buttonC.addActionListener(this);
        buttonC.addMouseListener(this);
        panel.add(buttonC);

        buttonBackSpace = new JButton("BackSpace");
        buttonBackSpace.setBounds(100,60,110,30);
        buttonBackSpace.addActionListener(this);
        buttonBackSpace.addMouseListener(this);
        panel.add(buttonBackSpace);

        button7 = new JButton("7");
        button7.setBounds(100,100,50,50);
        button7.addActionListener(this);
        button7.addMouseListener(this);
        panel.add(button7);

        button8 = new JButton("8");
        button8.setBounds(160,100,50,50);
        button8.addActionListener(this);
        button8.addMouseListener(this);
        panel.add(button8);

        button9 = new JButton("9");
        button9.setBounds(220,100,50,50);
        button9.addActionListener(this);
        button9.addMouseListener(this);
        panel.add(button9);

        buttonMultiply = new JButton("*");
        buttonMultiply.setBounds(280,100,50,50);
        buttonMultiply.addActionListener(this);
        buttonMultiply.addMouseListener(this);
        panel.add(buttonMultiply);

        button4 = new JButton("4");
        button4.setBounds(100,160,50,50);
        button4.addActionListener(this);
        button4.addMouseListener(this);
        panel.add(button4);

        button5 = new JButton("5");
        button5.setBounds(160,160,50,50);
        button5.addActionListener(this);
        button5.addMouseListener(this);
        panel.add(button5);

        button6 = new JButton("6");
        button6.setBounds(220,160,50,50);
        button6.addActionListener(this);
        button6.addMouseListener(this);
        panel.add(button6);

        buttonDivide = new JButton("/");
        buttonDivide.setBounds(280,160,50,50);
        buttonDivide.addActionListener(this);
        buttonDivide.addMouseListener(this);
        panel.add(buttonDivide);

        button1 = new JButton("1");
        button1.setBounds(100,220,50,50);
        button1.addActionListener(this);
        button1.addMouseListener(this);
        panel.add(button1);

        button2 = new JButton("2");
        button2.setBounds(160,220,50,50);
        button2.addActionListener(this);
        button2.addMouseListener(this);
        panel.add(button2);

        button3 = new JButton("3");
        button3.setBounds(220,220,50,50);
        button3.addActionListener(this);
        button3.addMouseListener(this);
        panel.add(button3);

        buttonMinus = new JButton("-");
        buttonMinus.setBounds(280,220,50,50);
        buttonMinus.addActionListener(this);
        buttonMinus.addMouseListener(this);
        panel.add(buttonMinus);

        button0 = new JButton("0");
        button0.setBounds(100,280,50,50);
        button0.addActionListener(this);
        button0.addMouseListener(this);
        panel.add(button0);

        buttonDot = new JButton(".");
        buttonDot.setBounds(160,280,50,50);
        buttonDot.addActionListener(this);
        buttonDot.addMouseListener(this);
        panel.add(buttonDot);

        buttonEquals = new JButton("=");
        buttonEquals.setBounds(220,280,50,50);
        buttonEquals.addActionListener(this);
        buttonEquals.addMouseListener(this);
        panel.add(buttonEquals);

        buttonPlus = new JButton("+");
        buttonPlus.setBounds(280,280,50,50);
        buttonPlus.addActionListener(this);
        buttonPlus.addMouseListener(this);
        panel.add(buttonPlus);

        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
        switch (str){
            case "1":
                label.setText(label.getText()+button1.getText());
                break;
            case "2":
                label.setText(label.getText()+button2.getText());
                break;
            case "3":
                label.setText(label.getText()+button3.getText());
                break;
            case "4":
                label.setText(label.getText()+button4.getText());
                break;
            case "5":
                label.setText(label.getText()+button5.getText());
                break;
            case "6":
                label.setText(label.getText()+button6.getText());
                break;
            case "7":
                label.setText(label.getText()+button7.getText());
                break;
            case "8":
                label.setText(label.getText()+button8.getText());
                break;
            case "9":
                label.setText(label.getText()+button9.getText());
                break;
            case "0":
                label.setText(label.getText()+button0.getText());
                break;
            case ".":
                if (checkCorrectInput()){
                    label.setText(label.getText()+buttonDot.getText());
                }
                break;
            case "+":
                if (checkCorrectInput()){
                    label.setText(label.getText()+ buttonPlus.getText());
                }
                break;
            case "-":
                if (label.getText().length()==0){
                    label.setText(label.getText()+ buttonMinus.getText());
                    break;
                }
                if (checkCorrectInput()){
                    label.setText(label.getText()+ buttonMinus.getText());
                    break;
                }
                break;
            case "/":
                if (checkCorrectInput()){
                    label.setText(label.getText()+ buttonDivide.getText());
                }
                break;
            case "*":
                if (checkCorrectInput()){
                    label.setText(label.getText()+ buttonMultiply.getText());
                }
                break;
            case "=":
                Calculator Es = new Calculator(label.getText());
                label.setText(Es.getResult() + "");
                break;
            case "BackSpace":
                String temp = label.getText(); int len = temp.length();
                temp = temp.substring(0, len-1);
                label.setText(temp);
                break;
            case "C":
                label.setText("");
                break;
        }
    }

    private boolean checkCorrectInput(){
        if (label.getText().length() == 0){
            return false;
        }

        String labelText = label.getText();
        char a = labelText.charAt(labelText.length() - 1);
        switch (a){
            case '+':
                return false;
            case '-':
                if (labelText.length() == 0){
                    return true;
                }
                return false;
            case '*':
                return false;
            case '/':
                return false;
            case '.':
                return false;
        }

        return true;
    }

    @Override
    public void mouseEntered(MouseEvent me) {}
    @Override
    public void mouseExited(MouseEvent me) {}
    @Override
    public void mouseClicked(MouseEvent me){}
    @Override
    public void mousePressed(MouseEvent me){}
    @Override
    public void mouseReleased(MouseEvent me){}
}