package typicode.response_models;


import com.fasterxml.jackson.annotation.*;

public class Geo {
    private String lat;
    private String lng;

    @JsonProperty("lat")
    public String getLat() { return lat; }
    @JsonProperty("lat")
    public void setLat(String value) { this.lat = value; }

    @JsonProperty("lng")
    public String getLng() { return lng; }
    @JsonProperty("lng")
    public void setLng(String value) { this.lng = value; }
}