package pkg1;



public class A{


	protected int number;
	
	String name;
	
	
	////////////////////////


	public A ( int number, String name){
		
		number = number;
		name = name;
	}	
	
	
	
	
	private void increment(){
	
		++number;

	}
	
	
	
	
	protected void decrement(){
	
		--number;

	}
	
	
	
	void changeName( String str ){
	
			
		name = str;
		
				
	}
	
	
	
	////////////////////////
	
	
	public void callDecrement(){
	
		decrement();

	}
	
	
	
	
	public void callIncrement(){
	
		increment();

	}
	
	
	
	public void callChangeName( String str ){
	
		changeName( str );

	}

}









