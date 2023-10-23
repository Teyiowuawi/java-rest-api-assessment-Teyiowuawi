package com.cbfacademy.apiassessment;

import java.math.BigInteger;
import java.net.URL;

public class Ftse100 {
    private String companyName;
    private String tickerSymbol; 
    private String sector;
    private URL stockPrice;
    //URL for stock price doesnt display when request is made in postman - instead its null
    private BigInteger marketCapitalization;
    private double priceToEquityRatio;
    private double priceToBookRatio;
    private double debtToEquityRatio;
    private double esgRiskRating;

  public Ftse100(String companyName, String tickerSymbol, String sector,URL stockPrice, BigInteger marketCapitalization, double priceToEquityRatio, double priceToBookRatio, double debtToEquityRatio, double esgRiskRating){
        this.companyName = companyName;
        this.tickerSymbol = tickerSymbol;
        this.stockPrice = stockPrice;
        this.marketCapitalization = marketCapitalization;
        this.priceToEquityRatio = priceToEquityRatio;
        this.debtToEquityRatio = debtToEquityRatio;
        this.esgRiskRating = esgRiskRating;
  }


    public String getCompanyName() {
        return companyName;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }



    public String getTickerSymbol() {
        return tickerSymbol;
    }


    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }




    public String getSector() {
        return sector;
    }


    public void setSector(String sector) {
        this.sector = sector;
    }


    public URL getStockPrice() {
        return stockPrice;
    }


    public void setStockPrice(URL stockPrice) {
        this.stockPrice = stockPrice;
    }


    public BigInteger getMarketCapitalization() {
        return marketCapitalization;
    }


    public void setMarketCapitalization(BigInteger marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }


    public double getPriceToEquityRatio() {
        return priceToEquityRatio;
    }


    public void setPriceToEquityRatio(double priceToEquityRatio) {
        this.priceToEquityRatio = priceToEquityRatio;
    }


    public double getPriceToBookRatio() {
        return priceToBookRatio;
    }


    public void setPriceToBookRatio(double priceToBookRatio) {
        this.priceToBookRatio = priceToBookRatio;
    }



    public double getDebtToEquityRatio() {
        return debtToEquityRatio;
    }


    public void setDebtToEquityRatio(double debtToEquityRatio) {
        this.debtToEquityRatio = debtToEquityRatio;
    }



    public double getEsgRiskRating() {
        return esgRiskRating;
    }


    public void setEsgRiskRating(double esgRiskRating) {
        this.esgRiskRating = esgRiskRating;
    }

}
