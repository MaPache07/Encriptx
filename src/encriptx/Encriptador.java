/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Mauricio Pacheco
 */
public class Encriptador {
    
    ArrayList<String> keys = new ArrayList();
    
    public Encriptador(){
        keys.add("CAT");
        keys.add("DOG");
        keys.add("BIRD");
        keys.add("WOLF");
    }
    
    public ArrayList<Integer> orderKey(String key){
        int[] order = new int[key.length()];
        for(int i = 0; i < key.length(); i++){
            order[i] = key.codePointAt(i);
        }
        int aux = 0, i = 0, index = 0;
        ArrayList<Integer> result = new ArrayList();
        while(true){
            if(i == 0){
                if(result.contains(i)){
                    aux = 91;
                    index = 0;
                }
                else{
                    aux = order[i];
                    index = i;
                }
            }
            else if(aux > order[i] && !result.contains(i)){
                aux = order[i];
                index = i;
            }
            i++;
            if(i == order.length){
                result.add(index);
                if(result.size() == i) break;
                i = 0;
            }
        }
        return result;        
    }
    
    public void encriptar(String msg){
        //msg = msg.replace(" ", "");
        Random rand = new Random();
        int key = rand.nextInt(keys.size()),
            lenx = (int) Math.ceil(((double)msg.length())/((double)keys.get(key).length())),
            leny = keys.get(key).length();
        char[][] matriz = new char[lenx][leny];
        int x = 0, y = 0;
        for(char i : msg.toCharArray()){
            matriz[x][y] = i;
            if(y == leny-1){
                x++;
                y = 0;
            }
            else y++;
            
        }
        ArrayList<Integer> indexs = new ArrayList();
        indexs = orderKey(keys.get(key));
        x = 0;
        y = 0;
        String encrip = "";
        while(true){
            encrip = encrip + String.valueOf(matriz[x][indexs.get(y)]);
            x++;
            if(x == lenx){
                x = 0;
                y++;
                if(y == leny) break;
            }
        }
        System.out.println("El mensaje encriptado es: " + encrip);
        System.out.println("La clave es: " + keys.get(key));
    }
    
    public void desencriptar(String text, String key){
        int lenx = (int) Math.ceil(((double)text.length())/((double)key.length()));
        int resto = ((int) Math.ceil(((double)text.length())/((double)key.length())))*3 - text.length();
        int[] resCol = new int[key.length()];
        for(int i = 0; i < key.length(); i++){
            if(key.length()-i <= resto){
                resCol[i] = lenx-1;
            }
            else{
                resCol[i] = lenx;
            }
        }
        ArrayList<Integer> indexs = new ArrayList();
        indexs = orderKey(key);
        char[][] matriz = new char[lenx][key.length()];
        char[] textChar = text.toCharArray();
        int x = 0, y = 0, k = 0;
        while(true){
            matriz[x][indexs.get(y)] = textChar[k];
            x++;
            k++;
            if(x == resCol[indexs.get(y)]){
                x = 0;
                y++;
                if(y == key.length()) break;
            }
        }
        String msg = "";
        int i = 0, j = 0;
        while(true){
            msg = msg + String.valueOf(matriz[i][j]);
            j++;
            if(j == key.length()){
                i++;
                j = 0;
                if(i == lenx) break;
            }
        }
        System.out.println("El mensaje es: " + msg);
    }
}
