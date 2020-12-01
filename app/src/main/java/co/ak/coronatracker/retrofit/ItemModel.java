package co.ak.coronatracker.retrofit;

public class ItemModel {

    private String Country, Confirmed, Deaths, Recovered, Active, Date;

    public ItemModel() {
    }

    public ItemModel(String country, String confirmed, String deaths, String recovered, String active, String date) {
        Country = country;
        Confirmed = confirmed;
        Deaths = deaths;
        Recovered = recovered;
        Active = active;
        Date = date;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(String confirmed) {
        Confirmed = confirmed;
    }

    public String getDeaths() {
        return Deaths;
    }

    public void setDeaths(String deaths) {
        Deaths = deaths;
    }

    public String getRecovered() {
        return Recovered;
    }

    public void setRecovered(String recovered) {
        Recovered = recovered;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String active) {
        Active = active;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "Country='" + Country + '\'' +
                ", Confirmed='" + Confirmed + '\'' +
                ", Deaths='" + Deaths + '\'' +
                ", Recovered='" + Recovered + '\'' +
                ", Active='" + Active + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }
}
