package com.edsonsuarez.date;

import java.sql.Date;
import java.util.Calendar;

public class FechasSQL {
    public static void main(String[] args) {
        Date fecha = obtenerFechaActual();
    }

    private static Date obtenerFechaActual() {
        Date fecha = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        System.out.println("fechaActual : " + fecha);
        return fecha;
    }

}
