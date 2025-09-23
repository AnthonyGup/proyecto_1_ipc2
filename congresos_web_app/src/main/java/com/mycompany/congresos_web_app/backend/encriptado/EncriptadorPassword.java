/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.encriptado;

import java.util.Base64;

/**
 *
 * @author antho
 */
public class EncriptadorPassword {
    
    public String codificar(String password) {
        String codificado = Base64.getEncoder().encodeToString(password.getBytes());
        return codificado;
    }
    
    public String decodificar(String codificado) {
        byte[] decodedBytes = Base64.getDecoder().decode(codificado);
        String password = new String(decodedBytes);
        return password;
    }
    
}
