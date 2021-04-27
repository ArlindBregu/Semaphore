/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author arlin
 */
public class ProdConsSem {
    
    private static Semaphore semVuoto = new Semaphore(1);
    private static Semaphore semPieno = new Semaphore(0);
    private static int buffer = 0;
    
    static class Produttore extends Thread{
        
        public void run(){
        
            while(true){
            
                try {
                    semVuoto.acquire();
                    buffer = (int)(Math.random() * 101);
                    System.out.println("Produce: " +buffer);
                    semPieno.release();
                    
                } catch (InterruptedException e) {
                }
                try{
                   TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                }
            }
        
        }
    
    }
    
    static class Consumatore extends Thread{
    
        int j = 0;
        
        public void run(){
        
            try {
                    semPieno.acquire();
                    j = buffer;
                    System.out.println("Consuma " +j);
                    semVuoto.release();
                    
                } catch (InterruptedException e) {
                }
        }
    }
    
}
