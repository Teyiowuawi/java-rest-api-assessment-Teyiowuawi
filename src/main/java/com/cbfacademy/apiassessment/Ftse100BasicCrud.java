package com.cbfacademy.apiassessment;

import java.util.List;

public interface Ftse100BasicCrud {
    
    List<Ftse100> addFtse100Company(Ftse100 ftse100);
    
    List<Ftse100> getAllFtse100Companies();

    Ftse100 updateFtse100Company(String tickerSymbol);

    List<Ftse100> deleteFtse100Company(String tickerSymbol);

}
