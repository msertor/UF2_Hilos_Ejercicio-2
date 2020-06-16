 
package uf2_hilos_ejercicio.pkg2;

import java.util.logging.Level;
import java.util.logging.Logger;


public class CuentaBancaria{
    private static int saldoActual;
    
    
    public CuentaBancaria(int saldoActual){
        this.saldoActual = saldoActual;
    }
    
    public int getSaldoActual(){
        return saldoActual;
    }
    
    //Método sincronizado de ingreso para que si dos hilos lo invocan, uno se quede suspendido hasta que el otro acabe.
    public synchronized int ingreso(int tarjeta, int valor){
       saldoActual += valor;
       System.out.println("Tarjeta: " + tarjeta + " - Cantidad ingresada: " + valor + " - Saldo actual: " + saldoActual);
       return saldoActual;
    }
    
    //Método sincronizado de retirada de dinero.
    public synchronized int retirada(int tarjeta, int valor)
        //Error si se intenta sarcar más dinero del que hay en la cuenta.
        throws RuntimeException{
         if (valor > saldoActual) {
             throw new RuntimeException("No hay suficiente cantidad en esta cuenta.");
            } else{
        saldoActual -= valor;
        System.out.println("Tarjeta: " + tarjeta + " - Cantidad retirada: " + valor + " - Saldo actual: " + saldoActual);
        return saldoActual;
       }
    }

}
