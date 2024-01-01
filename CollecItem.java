import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CollecItem{

    Stack <Integer> stk = new Stack <Integer>();
    Queue <Integer> que = new LinkedList <Integer>();
    ArrayList <Integer> list = new ArrayList <Integer>();
    Vector <Integer> vectr = new Vector <Integer>();
    Map <Integer, Integer> map = new HashMap <Integer, Integer>();
    
    
    public CollecItem(){
        setStack();
        setQueue();
        setList();
        setVector();
        setMap();
    }
    public void setStack(){
    
        int randNum = 0;
        Random x = new Random();
        
        for(int i=0; i<5; i++){
            
            randNum = x.nextInt(100) + 1;
            stk.push(randNum); //add to stack
        }
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
            

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i)); // list output
            
        }
        
        System.out.println("list: " + list.size());
        
        System.out.println("\n");
        
        for(int i=0; i<list.size(); i++){
             System.out.println(vectr.get(i));  // vector output
             
        }
        
        System.out.println("vector: " + vectr.size());
    }
    
    public void setMap(){
        //vectr.addAll(list);

        
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
        
       
        System.out.println(map);
        
        keys = setkey.iterator();
        values = setvalue.iterator();
        
        System.out.println("Keys: ");
        while(keys.hasNext()){
             System.out.print(keys.next() + " ");             
        }
        
        System.out.println();
        System.out.println("Values: ");
        while(values.hasNext()){
              System.out.print(values.next() + " ");
        }
    }
    
    public static void main(String [] args){
        CollecItem obj = new CollecItem();
    }
}