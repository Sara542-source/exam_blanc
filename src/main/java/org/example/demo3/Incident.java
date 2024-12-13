package org.example.demo3;

import java.util.Date;

public class Incident {

    private String reference ;
    private Date time  ;
    private String status ;

    public Incident( String reference , Date time , String status  ) {
        this.reference = reference ;
        this.time = time ;
        this.status = status ;
    }
}
