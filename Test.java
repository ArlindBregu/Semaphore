/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

import semaphore.ProdConsSem.Consumatore;
import semaphore.ProdConsSem.Produttore;

/**
 *
 * @author arlin
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        new Produttore().start();
        new Consumatore().start();
    }
    
}
