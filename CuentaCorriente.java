/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poobanco;

/**
 *
 * @author JAMI
 */
public class CuentaCorriente extends CuentaBancaria {
    public String nombreEmpresa;
    private double limiteSobregiro;
    private double sobregiroUtilizado = 0.0;
    
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
                           String nombreEmpresa, double limiteSobregiro){
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroUtilizado = sobregiroUtilizado; 
    }
    public double getlimiteSobregiro(){
         return limiteSobregiro;
    }
    public double getSobregiroUtilizado(){
        return sobregiroUtilizado;
    }
    public boolean retirarConSobregiro(double monto){
        if (monto <= 0){
            System.out.println("Monto insuficiente");
            return false;
        }
        if(getSaldo() >= monto){
          return retirar(monto);  
        }
        double saldoDisponible = getSaldo();
        double cupoDisponible = limiteSobregiro - sobregiroUtilizado;
if (monto <= saldoDisponible + cupoDisponible) {
            double diferencia = monto - saldoDisponible;   
            double recargo = diferencia * 0.03;            

            if (saldoDisponible > 0) {
                retirar(saldoDisponible);                
            }
            sobregiroUtilizado += diferencia + recargo;

            System.out.println("Retiro de L. " + monto + " con sobregiro.");
System.out.println("Saldo usado: L. " + saldoDisponible + " | Sobregiro usado: L. " + diferencia + " | Recargo 3%: L. " + recargo);
            return true;
        } else {
            System.out.println("Operacion rechazada: excede el limite de sobregiro.");
            return false;
}
    }
        public void pagarSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Error: monto invalido.");
            return;
        }
        if (sobregiroUtilizado <= 0) {
            System.out.println("No hay sobregiro pendiente. Se abona al saldo.");
            depositar(monto);
            return;
        }

        if (monto <= sobregiroUtilizado) {
            sobregiroUtilizado -= monto;
            System.out.printf("Abono al sobregiro: L" + monto);
        } else {
            double sobrante = monto - sobregiroUtilizado;
            System.out.printf("Sobregiro pagado completamente: L." + sobregiroUtilizado);
            sobregiroUtilizado = 0.0;
            depositar(sobrante);   
        }
    }
    
}
