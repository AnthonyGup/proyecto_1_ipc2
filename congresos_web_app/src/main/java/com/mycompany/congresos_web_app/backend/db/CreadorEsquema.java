/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author antho
 */
public class CreadorEsquema {

    public void crearTablas(Connection conn) throws SQLException {

        try (Statement stmt = conn.createStatement()) {

            // verificar linea 45 la cantidad de caracteres a aceptar en las validaciones
            String sql = """
                         CREATE DATABASE IF NOT EXISTS congresos_web;
                         USE congresos_web;
                         
                         CREATE TABLE usuario (
                         correo VARCHAR(150) NOT NULL,
                         estado BOOLEAN DEFAULT TRUE,
                         fecha_creacion DATE NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         cartera_digital DECIMAL(10,2),
                         rol ENUM('ADMIN_SISTEMA', 'ADMIN_CONGRESO', 'COMITE', 'PARTICIPANTE') DEFAULT 'PARTICIPANTE',
                         CONSTRAINT pk_usuario PRIMARY KEY (correo)
                        );
                         
                         CREATE TABLE participante (
                         id_personal VARCHAR(20) NOT NULL,
                         telefono VARCHAR(20) NOT NULL,
                         organizacion VARCHAR(200),
                         nombre_completo VARCHAR(200) NOT NULL,
                         id_usuario VARCHAR(150) NOT NULL,
                         CONSTRAINT pk_participante PRIMARY KEY (id_personal),
                         CONSTRAINT fk_participante_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(correo)
                                  );
                         
                         CREATE TABLE institucion (
                         id_institucion INT AUTO_INCREMENT,
                         ubicacion VARCHAR(200) NOT NULL,
                         nombre VARCHAR(150) NOT NULL,
                         descripcion VARCHAR (400) NOT NULL,
                         estado BOOLEAN DEFAULT TRUE,
                         CONSTRAINT pk_institucion PRIMARY KEY (id_institucion)
                                  );
                         
                         CREATE TABLE congreso (
                         id_congreso VARCHAR(12) NOT NULL,
                         ubicacion VARCHAR(150) NOT NULL,
                         titulo VARCHAR(150) NOT NULL,
                         descripcion VARCHAR(400),
                         precio DECIMAL(10,2) DEFAULT 35.00,
                         comision DECIMAL(2,4) NOT NULL,
                         estado BOOLEAN DEFAULT TRUE,
                         fecha_inicio DATE NOT NULL,
                         id_institucion INT,
                         id_admin VARCHAR(150) NOT NULL,
                         CONSTRAINT pk_congreso PRIMARY KEY (id_congreso),
                         CONSTRAINT fk_congreso_institucion FOREIGN KEY (id_institucion) REFERENCES institucion (id_institucion),
                         CONSTRAINT fk_congreso_usuario FOREIGN KEY (id_admin) REFERENCES usuario (correo)
                         );
                         
                         CREATE TABLE comite_cientifico (
                         id_comite INT AUTO_INCREMENT,
                         id_usuario VARCHAR(150) NOT NULL,
                         id_congreso VARCHAR(12) NOT NULL,
                         CONSTRAINT pk_comite PRIMARY KEY (id_comite),
                         CONSTRAINT fk_comite_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (correo),
                         CONSTRAINT fk_comite_congreso FOREIGN KEY (id_congreso) REFERENCES congreso (id_congreso)
                         );
                         
                         CREATE TABLE diploma (
                         id_diploma INT AUTO_INCREMENT,
                         tipo ENUM('PARTICIPACION', 'PRESENTACION') NOT NULL,
                         descripcion VARCHAR(200) NOT NULL,
                         id_participante VARCHAR(20) NOT NULL,
                         id_congreso VARCHAR(12) NOT NULL,
                         CONSTRAINT pk_diploma PRIMARY KEY (id_diploma),
                         CONSTRAINT fk_diploma_participante FOREIGN KEY (id_participante) REFERENCES participante (id_personal),
                         CONSTRAINT fk_diploma_congreso FOREIGN KEY (id_congreso) REFERENCES congreso (id_congreso)
                         );
                         
                         CREATE TABLE inscripcion (
                         id_inscripcion INT AUTO_INCREMENT,
                         id_participante VARCHAR(20) NOT NULL,
                         id_congreso VARCHAR(12) NOT NULL,
                         fecha_pago DATE NOT NULL,
                         monto DECIMAL (10,2) NOT NULL,
                         CONSTRAINT pk_inscripcion PRIMARY KEY (id_inscripcion),
                         CONSTRAINT fk_inscripcion_participante FOREIGN KEY (id_participante) REFERENCES participante (id_personal),
                         CONSTRAINT fk_inscripcion_congreso FOREIGN KEY (id_congreso) REFERENCES congreso (id_congreso)
                         );
                         
                         CREATE TABLE salon (
                         id_salon INT AUTO_INCREMENT,
                         salon VARCHAR(50) NOT NULL,
                         ubicacion VARCHAR(150) NOT NULL,
                         capacidad INT NOT NULL,
                         id_congreso VARCHAR(12) NOT NULL,
                         CONSTRAINT pk_salon PRIMARY KEY (id_salon),
                         CONSTRAINT fk_salon_congreso FOREIGN KEY (id_congreso) REFERENCES congreso (id_congreso)
                         );
                         
                         CREATE TABLE convocatoria (
                         id_convocatoria INT AUTO_INCREMENT,
                         titulo VARCHAR(150) NOT NULL,
                         estado BOOLEAN DEFAULT TRUE,
                         fecha_inicio DATE NOT NULL,
                         fecha_fin DATE NOT NULL,
                         id_congreso VARCHAR(12) NOT NULL,
                         CONSTRAINT pk_convocatoria PRIMARY KEY (id_convocatoria),
                         CONSTRAINT fk_convocatoria_congreso FOREIGN KEY (id_congreso) REFERENCES congreso (id_congreso)
                         );
                         
                         CREATE TABLE trabajo (
                         id_trabajo INT AUTO_INCREMENT,
                         tipo ENUM ('PONENCIA', 'TALLER') NOT NULL,
                         descripcion VARCHAR(200) NOT NULL,
                         titulo VARCHAR (150) NOT NULL,
                         estado BOOLEAN DEFAULT FALSE,
                         id_participante VARCHAR(20) NOT NULL,
                         id_convocatoria INT NOT NULL,
                         CONSTRAINT pk_trabajo PRIMARY KEY (id_trabajo),
                         CONSTRAINT fk_trabajo_participante FOREIGN KEY (id_participante) REFERENCES participante (id_personal),
                         CONSTRAINT fk_trabajo_convocatoria FOREIGN KEY (id_convocatoria) REFERENCES convocatoria (id_convocatoria)
                         );
                         
                         CREATE TABLE actividad (
                         id_actividad VARCHAR(12) NOT NULL,
                         nombre VARCHAR(150) NOT NULL,
                         descripcion VARCHAR(500) NOT NULL,
                         cupo_maximo INT,
                         tipo ENUM ('PONENCIA', 'TALLER'),
                         hora_inicio TIME NOT NULL,
                         hora_fin TIME NOT NULL,
                         id_encargado VARCHAR(150) NOT NULL,
                         id_congreso VARCHAR(12) NOT NULL,
                         id_salon INT NOT NULL,
                         CONSTRAINT pk_actividad PRIMARY KEY (id_actividad),
                         CONSTRAINT fk_actividad_usuario FOREIGN KEY (id_encargado) REFERENCES usuario (correo),
                         CONSTRAINT fk_actividad_congreso FOREIGN KEY (id_congreso) REFERENCES congreso (id_congreso),
                         CONSTRAINT fk_actividad_salon FOREIGN KEY (id_salon) REFERENCES salon (id_salon)
                         );
                         
                         CREATE TABLE reserva_taller ( 
                         id_reserva INT AUTO_INCREMENT,
                         fecha_reserva DATE NOT NULL,
                         id_actividad VARCHAR(12) NOT NULL,
                         id_participante VARCHAR(150) NOT NULL,
                         CONSTRAINT pk_reserva PRIMARY KEY (id_reserva),
                         CONSTRAINT fk_reserva_actividad FOREIGN KEY (id_actividad) REFERENCES actividad (id_actividad),
                         CONSTRAINT fk_reserva_usuario FOREIGN KEY (id_participante) REFERENCES participante (id_personal)
                         );
                         
                         CREATE TABLE asistencia (
                         id_asistencia INT AUTO_INCREMENT,
                         fecha_hora DATETIME NOT NULL,
                         id_actividad VARCHAR(12) NOT NULL,
                         id_participante VARCHAR(20) NOT NULL,
                         CONSTRAINT pk_asistencia PRIMARY KEY (id_asistencia),
                         CONSTRAINT fk_asistencia_actividad FOREIGN KEY (id_actividad) REFERENCES actividad (id_actividad),
                         CONSTRAINT fk_asistencia_participante FOREIGN KEY (id_participante) REFERENCES participante (id_personal)
                         );
                """;

            for (String statement : sql.split(";")) {
                if (!statement.trim().isEmpty()) {
                    stmt.executeUpdate(statement.trim());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
