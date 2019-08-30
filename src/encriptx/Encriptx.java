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
        Encriptador encript = new Encriptador();
        Boolean flag = true;
        Scanner input = new Scanner(System.in);
        String o = "", word = "", key = "";
        while(flag){
            System.out.println("-------------------------Bienvenido a Encriptx-------------------------");
            System.out.println("1. Encriptar");
            System.out.println("2. Desencriptar");
            System.out.println("3. Salir");
            o = input.nextLine();
            switch(o){
                case "1":
                    System.out.println("-------------------------Encriptar-------------------------");
                    System.out.println("Ingrese la palabra a encriptar.");
                    word = input.nextLine();
                    System.out.println();
                    encript.encriptar(word);
                    break;
                case "2":
                    System.out.println("-------------------------Encriptar-------------------------");
                    System.out.println("Ingrese el texto a desencriptar.");
                    word = input.nextLine();
                    System.out.println("Ingrese la llave para desencriptar.");
                    key = input.nextLine();
                    key = key.toUpperCase();
                    System.out.println();
                    encript.desencriptar(word, key);
                    break;
                case "3":
                    flag = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida.");
            }
        }
    }
}
