import mail.*;



public class Main {

    public static void main( String [] args ){

        EmailMessage mail = EmailMessage.builder().addFrom("SD.SD@asd.sd").build();
        System.out.print(mail.get( ));
    }

}
