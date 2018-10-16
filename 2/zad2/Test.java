import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Test{


	private static LinkedList < Rectangle > shapes ;


	private static void menu(){

        System.out.print("1. load a new rectangle\n"+
                "2. display all rectangles\n" +
                "3. display the sum of all rectangles' areas\n" +
                "0. end\n");

    }


	private static void loadRect(){

	    System.out.print("enter rectangle's sides' length ");

        Scanner reader = new Scanner( System.in );

        double a = reader.nextDouble();

        double b = reader.nextDouble();

        reader.close();


        shapes.push( new Rectangle( a, b ) );

	}






	public static void main( String [] args ){
	

	    shapes = new LinkedList<Rectangle>();

		int i = 1;



        Scanner reader = new Scanner( System.in );


        menu();

        while (i != 0) {


            i = reader.nextInt();



            switch (i){
                case 1:
                    //
                    loadRect();System.out.print(i);
                    break;

                case 2:
                    //
                    break;

                case 0:
                    break;

                default:
                    //
                    break;

            }

            menu();

        }

	}


}
