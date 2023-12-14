package typicode.response_models;


import com.fasterxml.jackson.annotation.*;

public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("catchPhrase")
    public String getCatchPhrase() { return catchPhrase; }
    @JsonProperty("catchPhrase")
    public void setCatchPhrase(String value) { this.catchPhrase = value; }

    @JsonProperty("bs")
    public String getBs() { return bs; }
    @JsonProperty("bs")
    public void setBs(String value) { this.bs = value; }
}
