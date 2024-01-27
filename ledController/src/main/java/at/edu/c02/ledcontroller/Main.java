package at.edu.c02.ledcontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * This is the main program entry point. TODO: add new commands when implementing additional features.
     */
    public static void main(String[] args) throws IOException {
        LedController ledController = new LedControllerImpl(new ApiServiceImpl());

        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(!input.equalsIgnoreCase("exit"))
        {
            System.out.println("=== LED Controller ===");
            System.out.println("Enter 'demo' to send a demo request");
            System.out.println("Enter 'getLights' to send a request to get all information about all lights");
            System.out.println("Enter 'exit' to exit the program");
            input = reader.readLine();
            if(input.equalsIgnoreCase("demo"))
            {
                ledController.demo();
            } else if (input.equalsIgnoreCase("getLights")){
                ledController.getLights();
            } else if (input.equalsIgnoreCase("getLight")) {
                System.out.println("Please specify LED ID:");
                String newInput = reader.readLine();
                ledController.getLight((Integer.parseInt(newInput)));
            } else if (input.equalsIgnoreCase("getGroupLeds")){
                String[] result = ledController.getGroupLeds();
                for (int i = 0; i < result.length; i++) {
                    System.out.println(result[i]);
                }
            } else if(input.equalsIgnoreCase("groupStatus")) {
                String[] result = ledController.getGroupLeds();
                for (int i = 0; i < result.length; i++) {
                    if (result[i] != null){
                        String[] split = result[i].split(";");
                        System.out.println("LED " + split[0] + " is currently " + split[1] + ". Color: " + split[2]);
                    }
                }
            } else if (input.equalsIgnoreCase("status")){
                System.out.println("Please specify LED ID:");
                String newInput = reader.readLine();
                String[] result = ledController.getGroupLeds();
                for (int i = 0; i < result.length; i++) {
                    if (result[i] != null){
                        String[] split = result[i].split(";");
                        if (split[0].equals(newInput))
                            System.out.println("LED " + split[0] + " is currently " + split[1] + ". Color: " + split[2]);
                    }
                }
            } else if (input.equalsIgnoreCase("setLight")) {
                System.out.println("Welche LED?");
                String led = reader.readLine();
                System.out.println("Welche Farbe in Hex Code?");
                String color = reader.readLine();
                ledController.setLight(Integer.parseInt(led), color, true);
                System.out.println("LED erfolgreich gesetzt!");
            } else if (input.equalsIgnoreCase("turnOffAllLights")){
                ledController.turnOffAllLeds();
            }
        }
    }
}
