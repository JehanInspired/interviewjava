package typicode.response_models;


import com.fasterxml.jackson.annotation.*;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @JsonProperty("street")
    public String getStreet() { return street; }
    @JsonProperty("street")
    public void setStreet(String value) { this.street = value; }

    @JsonProperty("suite")
    public String getSuite() { return suite; }
    @JsonProperty("suite")
    public void setSuite(String value) { this.suite = value; }

    @JsonProperty("city")
    public String getCity() { return city; }
    @JsonProperty("city")
    public void setCity(String value) { this.city = value; }

    @JsonProperty("zipcode")
    public String getZipcode() { return zipcode; }
    @JsonProperty("zipcode")
    public void setZipcode(String value) { this.zipcode = value; }

    @JsonProperty("geo")
    public Geo getGeo() { return geo; }
    @JsonProperty("geo")
    public void setGeo(Geo value) { this.geo = value; }
}