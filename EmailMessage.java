import java.util.LinkedList;




public class EmailMessage{

	private String from;
	private LinkedList<String> to;
	private String subject;
	private String content;
	
	
	private EmailMessage(){}
	
	
	
	public static class Builder{
	
		static EmailMessage m;
	
		
		public Builder addFrom( String from ){
			m.from = from;
			return this;
		}
		
		
		public static EmailMessage build(){
			return m;
		}
	
	}
	
	
	public static Builder builder(){
			return new EmailMessage.Builder();
	}
	

	 public static void main(String[] args){
	 
	 	EmailMessage a = new EmailMessage.builder().addFrom("").build();
	 }

	
}
