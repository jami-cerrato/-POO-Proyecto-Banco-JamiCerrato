/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poobanco;

/**
 *
 * @author JAMI
 */
public class CuentaBancaria {
     public String numeroCuenta;
     public String titular;
     private double saldo;
    private int TotalTransacciones;
      
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        if(saldoInicial < 0){
            this.saldo = 0.0;
        } else {
            this.saldo = saldoInicial;
        }
        this.TotalTransacciones = 0;
        }
    public double getSaldo(){
        return saldo;
    }
    public int getTotalTransacciones() {
        return TotalTransacciones;
    }
    public void depositar (double monto){
        if(monto >0){
           saldo += monto;
           TotalTransacciones++;
           System.out.println("Deposito exitoso: L." + monto);
        }
        else{
            System.out.println("Error: el monto a depositar debe ser mayor que 0.");
        }
    }
        
        public boolean retirar(double monto){
            if(monto >0 && saldo>= monto){
                saldo -= monto;
                TotalTransacciones++;
                return true;
            } else{
                System.out.println("Error. Saldo insuficiente");
                return false;
            }
        }
        
        public void mostrarDatos(){
            System.out.println("Titular:" + titular);
            System.out.println("Numero de cuenta:" + numeroCuenta);
            System.out.println("Saldo actual:" + saldo);
            System.out.println("Total de transacciones:" + TotalTransacciones);
        }
    }        

    
    
    
            
     

