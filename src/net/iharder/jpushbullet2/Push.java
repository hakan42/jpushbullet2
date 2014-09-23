package net.iharder.jpushbullet2;

import java.lang.reflect.Field;


/**
 * Represents a Pushbullet push that has been converted from a json response
 * from the Pushbullet servers.
 * 
 * Push implements Java's Comparable interface and sort such that newer 
 * pushes will be at the beginning of a list. This is in keeping with 
 * Pushbullet.com's policy of sending pushes newest first.
 * @author Robert.Harder
 */
public class Push implements Comparable<Push> {
    
    
    private String iden;
    private String type;
    private boolean active;
    private boolean dismissed;
    private double created;
    private double modified;
    private String title;
    private String body;
    private String url;
    private String owner_iden;
    private String target_device_iden;
    private String sender_iden;
    private String sender_email;
    private String sender_email_normalized;
    private String receiver_iden;
    private String receiver_email;
    private String receiver_email_normalized;

    public String getIden() {
        return iden;
    }

    public String getType() {
        return type;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isDismissed() {
        return dismissed;
    }

    public double getCreated() {
        return created;
    }

    public double getModified() {
        return modified;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getUrl() {
        return url;
    }

    public String getOwner_iden() {
        return owner_iden;
    }

    public String getTarget_device_iden() {
        return target_device_iden;
    }

    public String getSender_iden() {
        return sender_iden;
    }

    public String getSender_email() {
        return sender_email;
    }

    public String getSender_email_normalized() {
        return sender_email_normalized;
    }

    public String getReceiver_iden() {
        return receiver_iden;
    }

    public String getReceiver_email() {
        return receiver_email;
    }

    public String getReceiver_email_normalized() {
        return receiver_email_normalized;
    }

    /**
     * Pushes sort such that newer pushes will be at the beginning
     * of a list. This is in keeping with Pushbullet.com's policy of
     * sending pushes newest first.
     * @param t Push to compare
     * @return comparison value
     */
    @Override
    public int compareTo(Push t) {
        return Double.compare(t.getModified(),this.getModified()); // Newest first
        //return Double.compare(this.getModified(),t.getModified()); // Oldest first
    }
    
    
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append( "{").append(this.getClass().getSimpleName());
        for( Field f : this.getClass().getDeclaredFields() ){
            s.append(", ");
            s.append( f.getName() ).append("=");
            try {
                s.append( f.get(this) );
            } catch (Exception ex) {
                //Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        s.append("}");
        return s.toString();
    }
    
}   // end class Push