package com.ujjwalagrawal.spectrum.team.adapters;

/**
 * Created by AmanGupta on 30-11-2017.
 */

public class SingleVerticalo {
    private String header, subHeader;


    public SingleVerticalo( ) {

    }

    public SingleVerticalo(String header, String subHeader) {
        this.header = header;
        this.subHeader = subHeader;

    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }


}
