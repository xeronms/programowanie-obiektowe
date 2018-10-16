


public class Square{



	protected double a;
	
	
	
	public Square ( double x){
	
		a = x;
	
	}
	
	
	public double getA(){
	
		return a;
	
	}
	
	
	public void setA( double b){
	
		a = b;
	
	}
	
	
	public double area(){
	
	 return a*a;
	
	}



	public boolean isBigger( Square S){
	
		return S.area() > this.area();	

	}

}
