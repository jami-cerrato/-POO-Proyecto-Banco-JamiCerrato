/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poobanco;

/**
 *
 * @author JAMI
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("prueba 1 encapsulamiento");
        CuentaBancaria miCuenta = new CuentaBancaria("202142001155", "Jami Cerrato", 10000);
        
        System.out.println("prueba 2: atributos publicos");
        System.out.println("Titular: " + miCuenta.titular);
        System.out.println("Numero de cuenta: " + miCuenta.numeroCuenta);
        miCuenta.depositar(500);
        miCuenta.retirar(200);
        miCuenta.mostrarDatos();
        
        System.out.println("prueba 3 cuenta de ahorro");
        CuentaAhorro ahorro = new CuentaAhorro("002907456", "Jeferson Perdomo", 3000, 5);
        ahorro.retirarConComision(500);   
        ahorro.retirarConComision(500);   
        ahorro.retirarConComision(500);   
        ahorro.retirarConComision(500);   
        ahorro.mostrarDatos();
        
        System.out.println("prueba 4 ahorro");
    System.out.println("Saldo antes del interes: L. " + ahorro.getSaldo());
    ahorro.aplicarInteresMensual();
    System.out.println("Saldo despues del interes: L. " + ahorro.getSaldo());

    System.out.println("prueba 5 corriente");
    CuentaCorriente corriente = new CuentaCorriente("003728789", "Maria Jose", 1000,
            "Artisur", 5000);
    corriente.retirarConSobregiro(3500);
    System.out.println("Saldo: L. " + corriente.getSaldo());
    System.out.println("Sobregiro utilizado: L. " + corriente.getSobregiroUtilizado());

    System.out.println("prueba 6 deuda");
    corriente.pagarSobregiro(1000);
    System.out.println("Sobregiro pendiente: L. " + corriente.getSobregiroUtilizado());
    System.out.println("Saldo final: L. " + corriente.getSaldo());
    }   
    
}
