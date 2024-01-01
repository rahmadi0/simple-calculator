import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculater extends JFrame implements ActionListener{
    
     static Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
     static JButton button0, equalButton, plusButton, minusButton, multiButton, divideButton, decimalButton;
     static JButton clearButton, exitButton;
     static Panel textPanel, operandPanel;
     static JTextField textfield;
     static JLabel label;
     static String operand0, operand1, operand2;
     
          
     /*
     static Panel //declare 2 panels
     static Button /declare all your buttons
     static JTextField //declare your button;
    
     static JLabel //declare your label;
     */
     
     public void createGUI(){
    	
      /****************create first panel*******************/
      textPanel = new Panel();
      textPanel.setLayout(new FlowLayout());

      /*****************create new textfield and add it to the panel******************/
      textfield = new JTextField(20);
      textfield.setForeground(Color.red);
      textfield.setBackground(Color.white);
      textfield.setEditable(false);
      textPanel.add(textfield);
        
      /*****************create clear button and add to panel******************/
      
      clearButton = new JButton("Clear");
      textPanel.add(clearButton);
      clearButton.setForeground(Color.blue);

      /*****************create label and add to panel************************/
        
      label = new JLabel("", Label.LEFT); //" Can't choose and operator again!"
      label.setForeground(Color.red);
      textPanel.add(label);
      
      /*****************create a new panel with gridlayout******************/
      
      operandPanel = new Panel();
      operandPanel.setLayout(new GridLayout(5,4));
      
      button7 = new Button("7");
      button8 = new Button("8");
      button9 = new Button("9");
      plusButton = new JButton("+");
      
      button4 = new Button("4");
      button5 = new Button("5");
      button6 = new Button("6");
      minusButton = new JButton("-");
      
      button1 = new Button("1");
      button2 = new Button("2");
      button3 = new Button("3");
      multiButton = new JButton("*");
      
      
      button0 = new JButton("0");
      decimalButton = new JButton(".");
      equalButton = new JButton("=");      
      divideButton = new JButton("/");
      
      /*****************Buttons setForeground red*****************/
      
      plusButton.setForeground(Color.red);
      minusButton.setForeground(Color.red);
      multiButton.setForeground(Color.red);
      button0.setForeground(Color.red);
      decimalButton.setForeground(Color.red);
      equalButton.setForeground(Color.red);
      divideButton.setForeground(Color.red);
      
      /*****************add all buttons to the panel*****************/
        
      operandPanel.add(button7);
      operandPanel.add(button8);
      operandPanel.add(button9);
      operandPanel.add(plusButton);
      
      operandPanel.add(button4);
      operandPanel.add(button5);
      operandPanel.add(button6);
      operandPanel.add(minusButton);
      
      
      operandPanel.add(button1);
      operandPanel.add(button2);
      operandPanel.add(button3);
      operandPanel.add(multiButton);

      operandPanel.add(button0);
      operandPanel.add(decimalButton);
      operandPanel.add(equalButton);
      operandPanel.add(divideButton);
      
      
      /****************add both panels to frame*******************/
      
      add(textPanel, BorderLayout.NORTH);
      add(operandPanel, BorderLayout.CENTER);
      
    }
    
    public void addListeners(){
        //add actionlistener to all number buttons
		  //add a different actionlistener to the operators and clear button 
        
        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        
        plusButton.addActionListener(this);
        minusButton.addActionListener(this);
        divideButton.addActionListener(this);
        multiButton.addActionListener(this);
        decimalButton.addActionListener(this); 
        clearButton.addActionListener(this);  
        equalButton.addActionListener(this);         
    }
     
     public Calculater(String title){
          super(title);
          //call the above methods to setup your calculator
          operand0 = operand1 = operand2 = "";
          createGUI();
          addListeners();
          setSize(500, 300);
          setLocation(400, 100);
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
     }
     
     public static void main(String[] args){
         Calculater a = new Calculater("Java.Calculator");
     }
     
     public void actionPerformed(ActionEvent e){
        String input = e.getActionCommand(); 
  
        if ((input.charAt(0) >= '0' && input.charAt(0) <= '9') || input.charAt(0) == '.') { 

            if (!operand1.equals("")) 
                operand2 = operand2 + input; 
            else
                operand0 = operand0 + input; 
  
            // set the value of text 
            textfield.setText(operand0 + operand1 + operand2); 
        } 
        else if (input.charAt(0) == 'C') { 

            operand0 = operand1 = operand2 = ""; 
  
            textfield.setText(operand0 + operand1 + operand2); 
        } 
        else if (input.charAt(0) == '=') { 
  
            double total; 
  
            // store the value in 1st 
            if (operand1.equals("+")) 
                total = (Double.parseDouble(operand0) + Double.parseDouble(operand2)); 
            else if (operand1.equals("-")) 
                total = (Double.parseDouble(operand0) - Double.parseDouble(operand2)); 
            else if (operand1.equals("/")) 
                total = (Double.parseDouble(operand0) / Double.parseDouble(operand2)); 
            else 
                total = (Double.parseDouble(operand0) * Double.parseDouble(operand2)); 
            
            textfield.setText(operand0 + operand1 + operand2 + "=" + total); 
  
            operand0 = Double.toString(total); 
  
            operand1 = operand2 = ""; 
        } 
        else { 
            if (operand1.equals("") || operand2.equals("")) 
                operand1 = input; 
            else { 
                double total; 
  
                if (operand1.equals("+")) 
                    total = (Double.parseDouble(operand0) + Double.parseDouble(operand2)); 
                else if (operand1.equals("-")) 
                    total = (Double.parseDouble(operand0) - Double.parseDouble(operand2)); 
                else if (operand1.equals("/")) 
                    total = (Double.parseDouble(operand0) / Double.parseDouble(operand2)); 
                else
                    total = (Double.parseDouble(operand0) * Double.parseDouble(operand2)); 
  
                operand0 = Double.toString(total); 
  
                operand1 = input; 
  
                operand2 = ""; 
            } 
  
            textfield.setText(operand0 + operand1 + operand2); 
        } 
    }          

}




