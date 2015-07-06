
package chemtrade.entity;

/**
 *
 * @author ASUS
 */
public class SocialMedia {

    private int socialinfo_id;
    private String skype_account;
    private String privfacebook_account;
    private String twitter_account;
    private String email_account;
    private String linkedin;
    private String youtube;

    public SocialMedia(int socialinfo_id, String skype_account, String privfacebook_account, String twitter_account, String email_account, String linkedin, String youtube) {
        this.socialinfo_id = socialinfo_id;
        this.skype_account = skype_account;
        this.privfacebook_account = privfacebook_account;
        this.twitter_account = twitter_account;
        this.email_account = email_account;
        this.linkedin = linkedin;
        this.youtube = youtube;
    }

    public int getSocialinfo_id() {
        return socialinfo_id;
    }

    public String getAccount() {
        return skype_account;
    }

    public String getLink() {
        return privfacebook_account;
    }

    public String getIcon() {
        return twitter_account;
    }

    public String getDate() {
        return email_account;
    }

    public String getStatus() {
        return linkedin;
    }

    public String getYoutube() {
        return youtube;
    }
    
    public void setEmail_account(String email_account) {
		this.email_account = email_account;
	}
    
    public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
    public void setPrivfacebook_account(String privfacebook_account) {
		this.privfacebook_account = privfacebook_account;
	}
    
    public void setSkype_account(String skype_account) {
		this.skype_account = skype_account;
	}
    
    public void setSocialinfo_id(int socialinfo_id) {
		this.socialinfo_id = socialinfo_id;
	}
    
    public void setTwitter_account(String twitter_account) {
		this.twitter_account = twitter_account;
	}
    
    public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

}
