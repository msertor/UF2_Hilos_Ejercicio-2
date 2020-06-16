
package uf2_hilos_ejercicio.pkg2;
import java.util.logging.*;

public class UF2_Hilos_Ejercicio2 {
    
    public static void main(String[] args) throws InterruptedException {
         
        int numTarjetas = 2;
        CuentaBancaria cuenta = new CuentaBancaria(1000);//ponemos 1000 en la cuenta
        
        Thread[] threads = new Thread[numTarjetas];//array con el número de tarjetas
        
        for (int i=0; i<numTarjetas; i++){
            Thread thread = new Thread(new Tarjeta(i+1, cuenta));//crear thread
            thread.start();//iniciar thread
            threads[i] = thread;//añadir thread en la posición i del array         
        }
        
        for (int i = 0; i < threads.length; i++){
            threads[i].join();//pone el thread actual en espera hasta que el que está en proceso acabe
        }
        
        System.out.println("El balance final es: " + cuenta.getSaldoActual());

    }
    
}
