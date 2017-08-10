package endsstudios.eventbusexample.Util;

/**
 * Created by MEHMET on 9.08.2017.
 */

public class DataModel {
    String Currency;
    String Sale;
    String Buy;

    public void DataModel(String Currency,String Sale,String Buy)
    {
        this.Currency = Currency;
        this.Buy = Buy;
        this.Sale = Sale;
    }

    public String getCurrency()
    {
        return this.Currency;
    }

    public void setCurrency(String Currency)
    {
        this.Currency = Currency;
    }


    public String getSale()
    {
        return this.Sale;
    }

    public void setSale(String Sale)
    {
        this.Sale = Sale;
    }

    public String getBuy()
    {
        return this.Buy;
    }

    public void setBuy(String Buy)
    {
        this.Buy = Buy;
    }

}
