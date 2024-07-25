package org.example;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println();
        System.out.println("Pirma užduotis:");
        System.out.println();

        File file = new File("C:\\Users\\Sergejus\\IdeaProjects\\Paskaita_2024_07_24\\src\\main\\java\\org\\example\\array.txt");

        String line = "";

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("Nepavyko nuskaityti failą! Klaida: " + e.getMessage());
        }

        String[] stringNumbers = line.split(",");



        HashMap<String, Integer> numberMap = new HashMap<>();

        for(int i = 0 ; i < stringNumbers.length; i++){

            if(numberMap.containsKey(stringNumbers[i])) numberMap.put(stringNumbers[i], numberMap.get(stringNumbers[i]) + 1);
            else numberMap.put(stringNumbers[i], 1);

        }

        int repetitions = 0;
        for(Map.Entry<String, Integer> item : numberMap.entrySet()){

            if(item.getValue() >= repetitions){
                repetitions = item.getValue();
            }
        }

        List<String> maxValues = new ArrayList<>();
        for(Map.Entry<String, Integer> item : numberMap.entrySet()){
           if(item.getValue() == repetitions) maxValues.add(item.getKey());
        }

        System.out.println("Daugiausiai pasikartojantis skaičius:");

        boolean stop = false;
        if(maxValues.size() == 1) System.out.println(maxValues.getFirst());
        else{
            for(int i = 0; i < stringNumbers.length; i++ ){
                for(String s: maxValues){
                    if(s.equals(stringNumbers[i])){
                        System.out.println(s);
                        stop = true;
                        break;
                    }
                }
                if(stop) break;
            }
        }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println();
        System.out.println("Trečia užduotis:");
        System.out.println();
        int n  = 11;
        int[][] magicCube = new int[n][n];

        int positionX = n/2;
        int positionY = 0;
        int oldX = 0;
        int oldY = 0;
        for(int x= 1; x <= n*n; x++){
            magicCube[positionY][positionX] = x;// (int) Math.pow(x,2);

            if(positionY > 0)  positionY -= 1;
            else positionY = n - 1;

            if(positionX == n - 1 ) positionX = 0;
            else positionX += 1;

            if(magicCube[positionY][positionX] != 0) {
                positionX = oldX;
                positionY = oldY + 1;
            }

            oldX = positionX;
            oldY = positionY;

        }

        System.out.println("-----------------------------------------");
        System.out.println("(n + 1) down (n+2) right");
        System.out.println("n yra: " + n);

        for (int i = 0 ; i < magicCube.length; i++){
            for(int j = 0 ; j < magicCube[i].length; j++){
                System.out.print(magicCube[i][j] + "    ");
            }
            System.out.println();

        }
        System.out.println("-----------------------------------------");









    }
}