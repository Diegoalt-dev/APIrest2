package com.empresa.prueba.Excepctions;
import java.util.Date;

public class ExceptionResponse {
    private Date Fecha;
    private String mensaje;
    private String detalles;

    public ExceptionResponse(Date Fecha, String mensaje, String detalles) {
        super();
        this.Fecha = Fecha;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public Date getTimestamp() {
        return Fecha;
    }

    public String getMessage() {
        return mensaje;
    }

    public String getDetails() {
        return detalles;
    }

}