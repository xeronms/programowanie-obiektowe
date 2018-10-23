package mail;
import java.util.LinkedList;
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
            if ( ! p.matcher( mail ).matches() )
                throw new Exception("WRONG EMAIL GIVEN");

        }
    }




}