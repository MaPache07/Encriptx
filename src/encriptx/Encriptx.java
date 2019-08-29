/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptx;

import java.util.Scanner;

/**
 *
 * @author Mauricio Pacheco
 */
public class Encriptx {
    
    public static void main(String[] args) {
        Boolean flag = true;
        Scanner input = new Scanner(System.in);
        String word = "";
        System.out.println("-------------------------Bienvenido a Encriptx-------------------------");
        System.out.println("Ingrese la palabra a encriptar.");
        word = input.nextLine();
        Encriptador encript = new Encriptador();
        System.out.println();
        encript.tran(word);
    }
}
