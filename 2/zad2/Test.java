import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Test{


	private static LinkedList < Rectangle > shapes ;


	private static void loadRect(){

	    System.out.print("enter rectangle's sides' length");

        try {

            BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) );

            double a = Double.parseDouble(reader.readLine());

            double b = Double.parseDouble(reader.readLine());

            shapes.add( new Rectangle( a , b ));


        }catch (IOException e){}

	}


	public static void main( String [] args ){
	
	
		int i = 1;

		while (i != 0) {

			try {

				InputStreamReader reader = new InputStreamReader(System.in);

				BufferedReader buffer = new BufferedReader(reader);

				i = Integer.parseInt(buffer.readLine());


				System.out.print(i);

				switch (i){
					case 1:
						//
                        loadRect();
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

			}catch (IOException e){}

		}
	
	}


}
