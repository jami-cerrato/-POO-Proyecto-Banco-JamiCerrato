/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poobanco;

/**
 *
 * @author JAMI
 */
public class CuentaAhorro extends CuentaBancaria {
    public double tasaInteresAnual;
    private int retirosRealizadosMes = 0;
    private double comisionPorExceso = 20.0;
    
    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual){
        super(numeroCuenta, titular, saldoInicial);  
        this.tasaInteresAnual = tasaInteresAnual;
    }
    
    public boolean retirarConComision(double monto){
    double montoTotal = monto;
    boolean cobraComision = retirosRealizadosMes >=3;
    
    if (cobraComision) {
            montoTotal = monto + comisionPorExceso;
        }

        boolean exito = retirar(montoTotal);

        if (exito) {
            retirosRealizadosMes++;
            if (cobraComision) {
                System.out.println("Retiro de L. " + monto + " realizado. Se cobro comision por exceso de L. " + comisionPorExceso);
            } else {
                System.out.println("Retiro de L. " + monto + " realizado sin comision.");
            }
        }
        return exito;
    }
    
    public void aplicarInteresMensual(){
        double interes = (getSaldo() * (tasaInteresAnual / 100)) / 12;
        System.out.println("Su interes mensual es:" + interes);
        depositar(interes);        
    }

}
    



    




