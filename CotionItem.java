import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CotionItem extends JFrame implements ActionListener{
    
    static Stack <Integer> stk = new Stack <Integer>();
    static Queue <Integer> que = new LinkedList <Integer>();
    static ArrayList <Integer> list = new ArrayList <Integer>();
    static Vector <Integer> vectr = new Vector <Integer>();
    static Map <Integer, Integer> map = new HashMap <Integer, Integer>();
    
    static JButton generateButton, queueButton, listButton, vectorButton, mapButton;
    static JTextArea outputArea;
    
    public CotionItem(){
      
        setButtons();
        setTextArea();
        setAction();
        setLocation(550, 180);
        setSize(500, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setButtons(){
        
        JPanel panel = new JPanel();
        
        FlowLayout textlayout = new FlowLayout();
        setLayout(textlayout);

        generateButton = new JButton("Generate");
        generateButton.setForeground(Color.red);
        
        queueButton = new JButton("Queue");
        queueButton.setForeground(Color.green);
        
        listButton = new JButton("List");
        listButton.setForeground(Color.blue);
        
        vectorButton = new JButton("Vector");
        vectorButton.setForeground(Color.black);
        
        mapButton = new JButton("Map");
        mapButton.setForeground(Color.orange);
        
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.BLACK));
        
        add(panel, BorderLayout.NORTH);
        panel.add(generateButton);
        panel.add(queueButton);
        panel.add(listButton);
        panel.add(vectorButton);
        panel.add(mapButton);
        
    }
    
    public void setTextArea(){

        outputArea = new JTextArea(2, 40);
        add(outputArea, BorderLayout.SOUTH);  
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.LIGHT_GRAY));
    }
    
    public void setAction(){

        generateButton.addActionListener(this);
        queueButton.addActionListener(this);
        listButton.addActionListener(this);
        vectorButton.addActionListener(this);
        mapButton.addActionListener(this);
        
    }
    
    public int setStack(){
    
        int randNum = 0;
        Random x = new Random();
        
        for(int i=0; i<5; i++){
            
            randNum = x.nextInt(100) + 1;
            stk.push(randNum); //add to stack
            
        }
        
        return randNum;
    }
    
    public void setQueue(){
    
        while(!stk.isEmpty()){
            que.add(stk.pop()); //add stk to que 
        }
    }
    
    public void setList(){
        while(!que.isEmpty()){
            list.add(que.remove()); // add que to list
        }
    }
    
    public void setVector(){
    
        while(!list.isEmpty()){
            for(int i=0; i<list.size(); i++){
                 vectr.add(list.remove(i)); // add list to vectr
            }
        }
        
        System.out.println("vector: " + vectr.size());
    }
    
    public String setMap(){
        
        int randKey = 0;
        Random rand = new Random();
        
        Set <Integer> setkey = map.keySet();
        Collection <Integer> setvalue = map.values();
        
        Iterator <Integer> keys;
        Iterator <Integer> values;
        
        for(int i=0; i<vectr.size(); i++){
            randKey = rand.nextInt(100) + 1;
            map.put(randKey, vectr.get(i));
        }
        
       
        System.out.println(map); // print
        
        keys = setkey.iterator();
        values = setvalue.iterator();
        
        /*System.out.println("Keys: ");
        while(keys.hasNext()){
             System.out.print(keys.next() + " ");             
        }
        
        System.out.println();
        System.out.println("Values: ");
        while(values.hasNext()){
              System.out.print(values.next() + " ");
        }*/
        
        //int a = Integer.parseInt(values);
        return (keys + " " + values);
    }

    public static void main(String args[]){

        CotionItem obj = new  CotionItem();
    }
    
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == generateButton){
             String a = String.valueOf(setStack());
             //String a = Integer.toString(setStack());

             outputArea.setText(a);

             System.out.println("stack");
        }
        
        else if(e.getSource() == queueButton){
             setQueue();
             System.out.println("que");
        }
        
        else if(e.getSource() == listButton){
             setList();
             System.out.println("list");
        }
        
        else if(e.getSource() == vectorButton){
             setVector();
             System.out.println("vector");
        }
        
        else if(e.getSource() == mapButton){
              //setMap();
             //String result=String.valueOf(m);  
             outputArea.setText(setMap());
             System.out.println("map");
        }
        
        else{
             System.out.println("Invalide Command");
        }
    }
}