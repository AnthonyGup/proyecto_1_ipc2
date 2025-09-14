package com.mycompany.congresos_web_app.backend.entities;

/**
 * 
 * @author antho
 */
public class Participante {
    
    private final String ID_PERSONAL;
    private final String NOMBRE_COMPLETO;
    private final String TELEFONO;
    private final String ORGANIZACION;
    private final String ID_USUARIO;

    /**
     * Inicializacion de todos los atributos que conforman al participante;
     * @param ID_PERSONAL codigo de identificacion personal del participante
     * @param NOMBRE_COMPLETO nombre del participante
     * @param TELEFONO numero de telefono, puede incluir codigos de pais
     * @param ORGANIZACION nombre de la organizacion de la que proviene el participante
     * @param ID_USUARIO codigo de la cuenta de usuario del participante
     */
    public Participante(String ID_PERSONAL, String NOMBRE_COMPLETO, String TELEFONO, String ORGANIZACION, String ID_USUARIO) {
        this.ID_PERSONAL = ID_PERSONAL;
        this.NOMBRE_COMPLETO = NOMBRE_COMPLETO;
        this.TELEFONO = TELEFONO;
        this.ORGANIZACION = ORGANIZACION;
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
