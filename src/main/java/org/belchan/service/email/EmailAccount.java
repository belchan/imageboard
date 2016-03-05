
package org.belchan.service.email;

public class EmailAccount {
    private String EMAIL;
    private String LOGIN;
    private String PASSWORD;
    private String SERVER;
    private String smtpPort;

    public EmailAccount() {
    }

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String eMAIL) {
        this.EMAIL = eMAIL;
    }

    public String getLOGIN() {
        return this.LOGIN;
    }

    public void setLOGIN(String lOGIN) {
        this.LOGIN = lOGIN;
    }

    public String getPASSWORD() {
        return this.PASSWORD;
    }

    public void setPASSWORD(String pASSWORD) {
        this.PASSWORD = pASSWORD;
    }

    public String getSERVER() {
        return this.SERVER;
    }

    public void setSERVER(String sERVER) {
        this.SERVER = sERVER;
    }

    public String getSmtpPort() {
        return this.smtpPort;
    }

    public void setSmtpPort(String sMTPPORT) {
        this.smtpPort = sMTPPORT;
    }
}
