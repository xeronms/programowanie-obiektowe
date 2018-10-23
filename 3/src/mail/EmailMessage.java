package mail;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.Properties;
import java.util.regex.Pattern;


public class EmailMessage{

    private String from;
    private LinkedList<String> to;
    private String subject;
    private String content;


    private EmailMessage(){}

    private EmailMessage( EmailMessage m){
        from = m.from;
        to = m.to;
        subject = m.subject;
        content = m.content;
    }

    public static Builder builder(){
        return new EmailMessage.Builder();
    }

    public String get(){
        return from;
    }


    //
    //Builder class
    public static class Builder{

        static EmailMessage m;

        private Builder(){
            m = new EmailMessage();
        }

        public Builder addFrom( String from ){
            try {
                Checker.checkMail(from);
            } catch (Exception e){ System.out.print("EMAIL INVALID");}
            finally {
                m.from = from;
            }
            return this;
        }

        public Builder addTo( LinkedList<String> to ){
            try {
                for (int i=0; i<to.size(); ++i)
                    Checker.checkMail(to.get(i));
            } catch (Exception e){ System.out.print("EMAIL INVALID");}
            finally {
                m.to = to;
            }
            return this;
        }

        public Builder addTo ( String to ){
            try {
                Checker.checkMail(to);
            } catch (Exception e){ System.out.print("EMAIL INVALID");}
            finally {
                m.to = new LinkedList<String>();
                m.to.push(to);
            }
            return this;
        }

        public Builder addSubject( String subject){
            m.subject = subject;
            return this;
        }

        public Builder addContent( String content){
            m.content = content;
            return this;
        }

        public EmailMessage build(){
            return new EmailMessage( m );
        }

    }

    //
    //Email address check
    private static class Checker{

        private static void checkMail (String mail ) throws Exception{
            Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

            // Throwing exception in case email is not valid
            if (  ! p.matcher( mail ).matches() )
                throw new Exception("WRONG EMAIL GIVEN");

        }
    }


    public void send(){
        String host="smtp.gmail.com";      //change accordingly
        final String user = from;
        final String password="xxxxxx";      //change accordingly


        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress( to.get(0) ));

            message.setSubject(subject );
            message.setText( content );

            //send the message
            Transport.send(message);

            System.out.println("message sent successfully...");

        }catch (MessagingException mex) { mex.printStackTrace(); }
    }

}