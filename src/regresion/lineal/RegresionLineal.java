/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regresion.lineal;

import Interfaces.InterfasPrincipal;
import jade.core.Agent;

public class RegresionLineal extends Agent{

   public void setup(){
       InterfasPrincipal inter = new InterfasPrincipal();
       inter.setVisible(true);
       System.out.println("Agente iniciado");
   }
    
    
    
}
