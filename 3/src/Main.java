import mail.*;



public class Main {

    public static void main( String [] args ){

        EmailMessage mail = EmailMessage.builder()
                .addFrom("asdasdms@o2.pl")
                .addTo("xqweqwems@o2.pl")
                .addSubject("Mail testowy")
                .addContent("Brak tresci")
                .build();

        mail.send();
    }

}
