package pkg1;




public class B extends A{

	
	public B ( int number, String name ){
	
		super ( number, name);
	
	}





	void changeName( String str ){
	
		name = "nowy" + str;
	
	}


	private void increment(){
	
		number = number + 2;
	
	}


}

