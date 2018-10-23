import mail.*;



public class Main {

    public static void main( String [] args ){

        EmailMessage mail = EmailMessage.builder().addFrom("SD").build();
        System.out.print(mail.get( ));
    }

}
