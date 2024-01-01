import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// with return item;

class Coll extends JFrame implements ActionListener{
    
    static Stack <Integer> stk = new Stack <Integer>();
    static Queue <Integer> que = new LinkedList <Integer>();
    static ArrayList <Integer> list = new ArrayList <Integer>();
    static Vector <Integer> vectr = new Vector <Integer>();
    static Map <Integer, Integer> map = new HashMap <Integer, Integer>();
    
    static JButton generateButton, queueButton, listButton, vectorButton, mapButton;
    static JTextArea outputArea;
    static int counter = 0;
    public Coll(){
      
        setButtons();
        setTextArea();
        setAction();
        setLocation(550, 180);
        setSize(600, 200);
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
    
    /*int randNum = 0;
        Random x = new Random();
        String s=" ";
        
        for(int i=0; i<5; i++){
            
            randNum = x.nextInt(100) + 1;
            stk.push(randNum); //add to stack
            System.out.print(randNum + " ");
            
            s=s+" "+randNum;
        } */ 
    
    public String setQueue(){
        
        String q= " ";

        while(!stk.isEmpty()){
            que.add(stk.pop()); //add stk to que
            q=q +" "+ que;
        }
        
        return q;
        
    }
    
    public String setList(){
    
        String l= " ";
        
        while(!que.isEmpty()){
            list.add(que.remove()); // add que to list
        }
        
        for(int i=0; i<list.size(); i++){
            l=l + " " + list.get(i);
        }
        
        return l;
    }
    
    public String setVector(){
       String v= " ";
               
       while(!list.isEmpty()){
            for(int i=0; i<list.size(); i++){
                 vectr.add(list.remove(i)); // add list to vectr
            }
        }
        
        for(int i=0; i<vectr.size(); i++){
            v=v +" "+ vectr.get(i);
        }

       System.out.println("vector: " + vectr.size());
       return v;
    }
    
    public String setMap(){
        
        int randKey = 0;
        String kv = " ";
        Random rand = new Random();
        
        Set <Integer> setkey = map.keySet();
        Collection <Integer> setvalue = map.values();

        for(int i=0; i<vectr.size(); i++){
            randKey = rand.nextInt(100) + 1;
            map.put(randKey, vectr.remove(i));
            
            //kv=kv+" "+ randKey +"=" + map.get(randKey);
        }
        
        for(int i=0; i<vectr.size(); i++){
            kv=kv+" "+ randKey +"=" + map.get(randKey);
        }
        
        
        System.out.println(map); // print
        return kv;
    }

    public static void main(String args[]){

        Coll obj = new  Coll();
    }
    
    public void actionPerformed(ActionEvent e){
    
        int randNum = 0;
        Random x = new Random();
        String s=" ";
        
        for(int i=0; i<5; i++){
            
            randNum = x.nextInt(100) + 1;
            stk.push(randNum); //add to stack
            System.out.print(randNum + " ");
            
            s=s+" "+randNum;
        }
        
        inner:
        if(counter < 3){
            if(e.getSource() == generateButton){
                  outputArea.setText(s);
             }
             
             else if(counter == 3){
                   break inner;
             }
            
            counter += 1;
        }

        else if(e.getSource() == queueButton){
             
             outputArea.setText(setQueue().toString());
             if(que.isEmpty())
                  outputArea.setText("Queue Is Empty ");
                  
             System.out.println("que");
        }
        
        else if(e.getSource() == listButton){
             outputArea.setText(setList());
             if(list.isEmpty())
                  outputArea.setText("List Is Empty ");
             
             System.out.println("list");
        }
        
        else if(e.getSource() == vectorButton){
             outputArea.setText(setVector());
             if(vectr.isEmpty())
                  outputArea.setText("Vector Is Empty ");
             
             System.out.println("vector");
             //setVector();
        }
        
        else if(e.getSource() == mapButton){  
             outputArea.setText(setMap());
             if(map.isEmpty())
                  outputArea.setText("Map Is Empty ");
             
             System.out.println("map");
        }
        
        else{
             outputArea.setText("Stack Is Full...\nCan't Generate Select Numbers.\nPlease Move to Other Options");
        }
    }
}