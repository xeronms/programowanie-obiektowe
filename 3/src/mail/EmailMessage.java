package mail;
import java.util.LinkedList;

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


    // Builder class
    public static class Builder{

        static EmailMessage m;

        private Builder(){
            m = new EmailMessage();
        }

        public Builder addFrom( String from ){
            m.from = from;
            return this;
        }

        public static EmailMessage build(){
            return new EmailMessage( m );
        }

    }







}