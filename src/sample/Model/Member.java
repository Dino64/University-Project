package sample.Model;

public class Member extends User {
    private String memberID;
    private boolean verificationCode;
    private String verified;

    public Member(int iduser, String firstName, String lastName, String ssn, String email, String password, String phoneNumber, String memberID, boolean verificationCode, String verified) {
        super(iduser, firstName, lastName, ssn, email, password, phoneNumber);
        this.memberID = memberID;
        this.verificationCode = verificationCode;
        this.verified = verified;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public boolean isVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(boolean verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    @Override
    public boolean matches(String key) {
        if (super.matches(key)){
        return true;
    }
        return memberID.matches(".*"+key+".*");
    }

}


