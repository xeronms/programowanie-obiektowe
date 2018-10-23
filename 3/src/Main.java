import mail.*;



public class Main {

    public static void main( String [] args ){

        EmailMessage mail = EmailMessage.builder()
                .addFrom("sbobek@edu.pl")
                .addTo("student@agh.edu.pl")
                .addSubject("Mail testowy")
                .addContent("Brak tresci")
                .build();

        System.out.print(mail.get( ));
    }

}
