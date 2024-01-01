import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class MyCalculater extends JFrame implements ActionListener{
    
     static Operatorr operatorObj = new Operatorr();
     
     static Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
     static JButton button0, equalButton, plusButton, minusButton, multiButton, divideButton, decimalButton;
     static JButton clearButton;
     static JPanel textPanel, buttonPanel;
     static JTextField textfield;
     static JLabel label;
     static String operand0, operand1, operand2;
     static int countDecimal = 0;
     /*
     static Panel //declare 2 panels
     static Button /declare all your buttons
     static JTextField //declare your button;
    
     static JLabel //declare your label;
     */
     
         
     public static void main(String[] args){
         MyCalculater obj = new MyCalculater("Java.Calculator");
     }
     
     public void createGUI(){
    	
      /****************create first panel*******************/
      textPanel = new JPanel();
      textPanel.setLayout(new FlowLayout()); // by default a panel is flowlayout
      textPanel.setBackground(Color.BLACK);
      textPanel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.WHITE));
      
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
      
      /******************create label and add to panel************************/
        
      label = new JLabel("            Functions On", Label.LEFT); //" Can't choose and operator again!"
      label.setForeground(Color.green);
      textPanel.add(label);
      
      /*****************create a new panel with gridlayout******************/
      
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(5,4));
      buttonPanel.setBackground(Color.LIGHT_GRAY);
      buttonPanel.setBorder(BorderFactory.createMatteBorder(10,5,5,5,Color.BLACK));
      
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
      
      /*****************add all buttons to the buttonPanel*****************/
        
      buttonPanel.add(button7);
      buttonPanel.add(button8);
      buttonPanel.add(button9);
      buttonPanel.add(plusButton);
      
      buttonPanel.add(button4);
      buttonPanel.add(button5);
      buttonPanel.add(button6);
      buttonPanel.add(minusButton);
      
      buttonPanel.add(button1);
      buttonPanel.add(button2);
      buttonPanel.add(button3);
      buttonPanel.add(multiButton);

      buttonPanel.add(button0);
      buttonPanel.add(decimalButton);
      buttonPanel.add(equalButton);
      buttonPanel.add(divideButton);
      
      /****************add both panels to frame*******************/
      
      add(textPanel, BorderLayout.NORTH);
      add(buttonPanel, BorderLayout.CENTER);
      
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
        decimalButton.addActionListener(this);
        
        plusButton.addActionListener(operatorObj);
        minusButton.addActionListener(operatorObj);
        divideButton.addActionListener(operatorObj);
        multiButton.addActionListener(operatorObj);
        clearButton.addActionListener(operatorObj);  
        equalButton.addActionListener(operatorObj); 
            
    }
     
     public MyCalculater(String title){
          super(title);
          
          operand0 = operand1 = operand2 = "";
          
          createGUI();
          addListeners();
          setSize(500, 300);
          setLocation(500, 100);
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
     }

     public void actionPerformed(ActionEvent e){
     			//You enter this method if a number was chosen
			//clear the label	
         label.setText("");
         		
			//Check a boolean flag to see if a number or an operator was chosen before
                //if operator then clear text otherwise append old number to new number
			//update the textbox and set the boolean flag for operator to false

        String input = e.getActionCommand(); // getCommand
  
        if(input.charAt(0) >= '0' && input.charAt(0) <= '9') { 

            if (!operand1.equals("")) 
                operand2 = operand2 + input; 
            else
                operand0 = operand0 + input; 
  
            // set the value of text 
            textfield.setText(operand0 + operand1 + operand2); 
            label.setText("            Functions On");
            label.setForeground(Color.green);;
        }
        
        else if(input.charAt(0) == '.' ){
        
            if(countDecimal >= 0 & countDecimal <= 1){
                 if (!operand1.equals("")) 
                      operand2 = operand2 + input; 
                 else
                      operand0 = operand0 + input;
            }
            
            else{
                  label.setText("Can't choose an operator again!");
                  label.setForeground(Color.red);
            }
            
            countDecimal++;
        }
        
        else{
             label.setText("");
        }

     }          
}

class Operatorr extends Frame implements ActionListener{

    static MyCalculater obj;
    
    public void actionPerformed(ActionEvent e){
		//if clear was chosen then reset the calculator, the labels, textfield and flags (init function)
           //if operator is chosen, make sure it wasn't chosen before (check boolean flag)
			//based on the operator that was chosen before, do the proper calculations 
			//and update total
			//set the flag for operator having been chosen to true
			//point to operator to be processed next time to the operator chosen
           //otherwise
            	//two operators were chosen back to back and it is illegal
			//come up with an error message in the label section

        String input = e.getActionCommand();
         
        if (input.charAt(0) == 'C') { 

            obj.operand0 = obj.operand1 = obj.operand2 = ""; 
  
            obj.textfield.setText(obj.operand0 + obj.operand1 + obj.operand2); 
            obj.label.setText("            Functions On");
            obj.label.setForeground(Color.green);
            obj.countDecimal = 0;
        }   
        else if (input.charAt(0) == '='){ 
            if(obj.operand1 == "")
                obj.label.setText("Can't choose an operator again!");
                obj.label.setForeground(Color.red);
                
            double total; 
  
            // store the value in 1st 
            if (obj.operand1.equals("+")) {
                    obj.countDecimal = 0;
                    total = (Double.parseDouble(obj.operand0) + Double.parseDouble(obj.operand2));
            }
             
            else if (obj.operand1.equals("-")){
                    obj.countDecimal = 0;
                    total = (Double.parseDouble(obj.operand0) - Double.parseDouble(obj.operand2));
            }
             
            else if (obj.operand1.equals("/")){ 
                     obj.countDecimal = 0;
                     total = (Double.parseDouble(obj.operand0) / Double.parseDouble(obj.operand2));
            }
            
            else{
                total = (Double.parseDouble(obj.operand0) * Double.parseDouble(obj.operand2)); 
            }
            
            obj.textfield.setText(obj.operand0 + obj.operand1 + obj.operand2 + " = " + total); 
  
            obj.operand0 = Double.toString(total); 
  
            obj.operand1 = obj.operand2 = ""; 
        } 
        else { 
            if (obj.operand1.equals("") || obj.operand2.equals("")) 
                obj.operand1 = input; 
            else { 
                double total; 
  
                if (obj.operand1.equals("+")) 
                    total = (Double.parseDouble(obj.operand0) + Double.parseDouble(obj.operand2)); 
                else if (obj.operand1.equals("-")) 
                    total = (Double.parseDouble(obj.operand0) - Double.parseDouble(obj.operand2)); 
                else if (obj.operand1.equals("/")) 
                    total = (Double.parseDouble(obj.operand0) / Double.parseDouble(obj.operand2)); 
                else
                    total = (Double.parseDouble(obj.operand0) * Double.parseDouble(obj.operand2)); 
  
                obj.operand0 = Double.toString(total); 
  
                obj.operand1 = input; 
  
                obj.operand2 = ""; 
            } 
  
            obj.textfield.setText(obj.operand0 + obj.operand1 + obj.operand2); 
        } 
    }

}





