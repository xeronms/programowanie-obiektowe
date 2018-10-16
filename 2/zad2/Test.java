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


	private static void loadRect( Scanner reader ){

	    System.out.print("enter rectangle's sides' length ");


        double a = reader.nextDouble();

        double b = reader.nextDouble();

        shapes.push( new Rectangle( a, b ) );

	}


	private static void dispRect( Scanner reader ){

	    for ( int i = 0 ; i < shapes.size() ; ++i){

	        System.out.print( shapes.get(i).getA() +  " " + shapes.get(i).getB() + "\n" );

        }
    }






	public static void main( String [] args ){
	

	    shapes = new LinkedList<Rectangle>();

		int i = 1;



        Scanner reader = new Scanner( System.in );




        while (i != 0) {

            menu();

            i = reader.nextInt();


            switch (i){
                case 1:
                    //
                    loadRect( reader );
                    break;

                case 2:
                    //
                    dispRect( reader );
                    break;

                case 3:
                    //
                    dispRect( reader );
                    break;

                case 0:
                    break;

                default:
                    //
                    System.out.print("WRONG NUMBER");
                    break;

            }


        }

        reader.close();

	}


}
