package sample.Model;


public class Address implements Model{
    private int id;
    private String street;
    private String zip;
    private String state;

    public Address(int id, String street, String zip, String state) {
        this.id = id;
        this.street = street;
        this.zip = zip;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean matches(String key) {
        if (street.matches(".*"+key+".*") || street.toLowerCase().matches(".*"+key+".*")) {
            return true;
        } else if (zip.matches(".*"+key+".*")) {
            return true;
        } else if (state.matches(".*"+key+".*") || state.toLowerCase().matches(".*"+key+".*")) {
            return true;
        } else {
            return false;
        }
    }
}
