package com.mycompany.congresos_web_app.backend.entities;

/**
 * 
 * @author antho
 */
public class Participante {
    
    private String ID_PERSONAL;
    private String NOMBRE_COMPLETO;
    private String TELEFONO;
    private String ORGANIZACION;
    private String ID_USUARIO;

    public void setID_PERSONAL(String ID_PERSONAL) {
        this.ID_PERSONAL = ID_PERSONAL;
    }

    public void setNOMBRE_COMPLETO(String NOMBRE_COMPLETO) {
        this.NOMBRE_COMPLETO = NOMBRE_COMPLETO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public void setORGANIZACION(String ORGANIZACION) {
        this.ORGANIZACION = ORGANIZACION;
    }

    public void setID_USUARIO(String ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    
    
    public String getID_PERSONAL() {
        return ID_PERSONAL;
    }

    public String getNOMBRE_COMPLETO() {
        return NOMBRE_COMPLETO;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public String getORGANIZACION() {
        return ORGANIZACION;
    }

    public String getID_USUARIO() {
        return ID_USUARIO;
    }
    
    
}
