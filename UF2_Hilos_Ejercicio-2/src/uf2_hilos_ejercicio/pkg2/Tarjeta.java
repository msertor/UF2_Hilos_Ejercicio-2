
package uf2_hilos_ejercicio.pkg2;

public class Tarjeta implements Runnable{ //implements Runnable, para crear los hilos
    private int id;
    private CuentaBancaria cuenta; //Instancia del objeto cuenta al que estarán vinculadas las tarjetas
    
    
    public Tarjeta(int id, CuentaBancaria cuenta){
        this.cuenta = cuenta;
        this.id = id;
    
}
    
   @Override
   public void run() {
        double ingresoTotal = 0;
        double retiradaTotal = 0;
        for (int i = 0; i < 5; i++) {//cada tarjeta dará 5 vueltas
            if (Math.random() > 0.5) { //aleatorización de ingreso o retirada
                int ingreso = (int) (Math.random() * 10); //aleatorización de la cantidad de ingreso
                ingresoTotal = ingresoTotal + ingreso;
                cuenta.ingreso(id, ingreso);
            } else {
                int retirada = (int) (Math.random() * 10); //aleatorización de la cantidad de retirada
                retiradaTotal = retiradaTotal + retirada;
                cuenta.retirada(id, retirada);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Tarjeta: " + id + " - Retirada total: " + retiradaTotal);
        System.out.println("Tarjeta: " + id + " - Ingreso total: " + ingresoTotal);
    }
}
