



public class Rectangle extends Square{

	
	protected double b;



	public Rectangle( double a2, double b2){
	
		super(a2);
		
		this.b = b2;
		
	}



	public double getB(){

		return b;

	}


	public void setB( double b2){

		b= b2;

	}


	public double area(){

		return a*b;

	}



	public boolean isBigger( Rectangle R ){

		return R.area() > this.area();

	}

}
