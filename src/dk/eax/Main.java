package dk.eax;

import dk.eax.graphics.*;
import javafx.scene.shape.Circle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Boolean gameOver = false;
        Board board = new Board();
        Scanner keyboard = new Scanner(System.in);
        int turn = 1;

        boxDrawer(board);

        while(!gameOver){
            // First cross
            System.out.printf("Crossed Player, where do you wish to plant your mighty flag? > ");
            int input = keyboard.nextInt();
            Field tempField = board.getBoard().get(input);
            Cross tempCross = new Cross();

            while(!tempCross.draw(tempField)){
                System.out.printf("How stupid are you? That field is taken! Enter a new one! > ");

                input = keyboard.nextInt();
                tempField = board.getBoard().get(input);
            }

            // Check for gameOver
            if(checkForGameOver(board)) {
                gameOver = true;
                break;
            }

            // Second circle
            System.out.printf("Circle Player, where do you wish to plant your puny ring? > ");
            input = keyboard.nextInt();
            tempField = board.getBoard().get(input);
            dk.eax.Circle tempCircle = new dk.eax.Circle();

            while(!tempCircle.draw(tempField)){
                System.out.printf("How stupid are you? That field is taken! Enter a new one! > ");

                input = keyboard.nextInt();
                tempField = board.getBoard().get(input);
            }

            // Check for gameOver
            if(checkForGameOver(board)) {
                gameOver = true;
                break;
            }

            turn++;
        }

        if(gameOver){
            System.out.println("GAME OVER MOTHERFUCKER, YOU DID THAT IN "+turn+" FUCKING TURNS");
        }
    }

    public static Boolean checkForGameOver(Board board){
        // Check 012
        if(sameToken(board.getBoard().get(0), board.getBoard().get(1), board.getBoard().get(2))){
            return true;
        }

        // Check 345
        if(sameToken(board.getBoard().get(3), board.getBoard().get(4), board.getBoard().get(5))){
            return true;
        }

        // Check 678
        if(sameToken(board.getBoard().get(6), board.getBoard().get(7), board.getBoard().get(8))){
            return true;
        }


        // Check 036
        if(sameToken(board.getBoard().get(0), board.getBoard().get(3), board.getBoard().get(6))){
            return true;
        }

        // Check 147
        if(sameToken(board.getBoard().get(1), board.getBoard().get(4), board.getBoard().get(7))){
            return true;
        }


        // Check 258
        if(sameToken(board.getBoard().get(2), board.getBoard().get(5), board.getBoard().get(8))){
            return true;
        }

        // Check 048
        if(sameToken(board.getBoard().get(0), board.getBoard().get(4), board.getBoard().get(8))){
            return true;
        }

        // Check 246
        if(sameToken(board.getBoard().get(2), board.getBoard().get(4), board.getBoard().get(6))){
            return true;
        }

        if(
            board.getBoard().get(0).getToken() != null &&
            board.getBoard().get(1).getToken() != null &&
            board.getBoard().get(2).getToken() != null &&
            board.getBoard().get(3).getToken() != null &&
            board.getBoard().get(4).getToken() != null &&
            board.getBoard().get(5).getToken() != null &&
            board.getBoard().get(6).getToken() != null &&
            board.getBoard().get(7).getToken() != null &&
            board.getBoard().get(8).getToken() != null
        ) {
            System.out.println("FUCKING DRAW! HOW FUCKING STUPID ARE YOU!?");
            return true;
        }

        return false;
    }

    // Methods checks 3 numbers and if they are the same on the board.
    private static Boolean sameToken(Field one, Field two, Field three){
        if(one.getToken() != null && two.getToken() != null && three.getToken() != null) {
            if (one.getToken().getClass() == two.getToken().getClass() && one.getToken().getClass() == three.getToken().getClass()) {
                System.out.println("WINNER IS: "+one.getToken().getClass());
                return true;
            }
        }

        return false;
    }

    public static void boxDrawer(Board board){
        int i = 0;

        for(int y = 0; y <= 2; y++){
            for(int x = 0; x <= 2; x++){
                Field temp = new Field(200, 200,  "i: " + i, 200 * y, 200 * x);
                ArrayList<Field> tempBoard = board.getBoard();
                tempBoard.add(i, temp);

                Rectangle box = new Rectangle(200 * y, 200 * x, 200, 200);
                Text t = new Text(200 * y + 10, 200 * x + 10, "i: " + i);
                box.draw();
                t.draw();
                i++;
            }
        }
    }

}
