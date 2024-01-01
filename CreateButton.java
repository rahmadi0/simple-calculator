import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CreateButton extends JFrame{
    
     Button a, b, c, d, e;
     JLabel l;
     JPanel p, p1;
     CreateButton(){
     
          
          p = new JPanel();
          
          add(p, BorderLayout.NORTH);
          
          a = new Button("Generate");
          b = new Button("Quene");
          c = new Button("List");
          d = new Button("Vector");
          e = new Button("Map");
          
          
          p.add(a);
          
          add(b);
          
          add(c);
          add(d);
          
          add(e);
          
          l = new JLabel();
          
          p1 = new JPanel();
          add(p1, BorderLayout.SOUTH);
          l = new JLabel("LABEL", JLabel.CENTER);
          l.setForeground(Color.red);
          
          p1.add(l, BorderLayout.CENTER);
          
          //add(l);
          
          
          setSize(400, 200);
          setVisible(true);
          
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
     }
     
     
     public static void main(String[] args){
         CreateButton a = new CreateButton();
     }

}