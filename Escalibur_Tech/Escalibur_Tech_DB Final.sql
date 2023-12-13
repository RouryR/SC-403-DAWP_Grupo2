drop schema if exists excaliburtech_db;
drop user if exists usuario_proyecto;
CREATE SCHEMA excaliburtech_db;
USE excaliburtech_db;

drop user if exists usuario_proyecto;
create user 'usuario_proyecto'@'%' identified by 'Usuar1o_Proyecto.';

grant all privileges on excaliburtech_db.* to 'usuario_proyecto'@'%';
flush privileges;


CREATE TABLE IF NOT EXISTS usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    usuario VARCHAR(30) NOT NULL,
    password VARCHAR(255) NOT NULL,
    apellidos varchar (50) not null,
    correo varchar (100) not null UNIQUE,
    empresa VARCHAR(100) NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    telefono varchar(40) NOT NULL,
	rol INT,
    activo boolean
);



CREATE TABLE tiquetes (
    id_tiquete INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    titulo varchar (60) not null,
    descripcion varchar (1080) not null,
    fecha_apertura DATE,
    id_usuario INT, -- Agregado para establecer la relación con el usuario
    activo boolean,
    foreign key fk_tiquete_usuario (id_usuario) references usuarios(id)
);
-- Después de crear la tabla, puedes ajustar la longitud del campo AUTO_INCREMENT
ALTER TABLE tiquetes AUTO_INCREMENT = 10000;

CREATE TABLE IF NOT EXISTS empleados (
    id_empleado INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    puesto VARCHAR(50) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    telefono VARCHAR(40) NOT NULL,
    activo BOOLEAN,
    id_usuario INT,
    FOREIGN KEY fk_empleados_usuario (id_usuario) REFERENCES usuarios(id)
);

INSERT INTO usuarios (nombre, usuario, password, apellidos, correo, empresa, puesto, salario, telefono, activo, rol)
VALUES
    ('Juan', 'juan123', 'contraseña123', 'Pérez', 'juan@email.com', 'Empresa A', 'Analista', 50000.00, '555-1234', true,2),
    ('María', 'maria456', 'clave_secreta', 'López', 'maria@email.com', 'Empresa B', 'Desarrollador', 60000.00, '555-5678', true,2),
    ('Carlos', 'carlos789', '2', 'González', '2', 'Empresa C', 'Gerente', 80000.00, '555-9876', true,2),
    ('Laura', 'laura101', 'password123', 'Martínez', 'laura@email.com', 'Empresa A', 'Analista', 55000.00, '555-4321', true,2),
    ('Pedro', 'pedro2022', 'segura123', 'Ramírez', 'pedro@email.com', 'Empresa B', 'Desarrollador', 65000.00, '555-8765', true,2),
	('Admin', 'Excalibur Tech', '1', 'Esclibur Tech', '1', 'Excalibur Tech', 'Java Developer', 1300000.00, '89432784', true, 1);



INSERT INTO tiquetes (titulo, descripcion, fecha_apertura, id_usuario, activo)
VALUES
    ('Problema con la impresora', 'Descripción del problema: Problema con la impresora', '2023-01-15', 1, true),
    ('Error en el sistema', 'Descripción del problema: Error en el sistema', '2023-02-10', 1, true),
    ('Solicitud de mantenimiento', 'Descripción del problema: Solicitud de mantenimiento', '2023-03-05', 1, true),

    ('Problema de software', 'Descripción del problema: Problema de software', '2023-04-20', 2, true),
    ('Incidente de seguridad', 'Descripción del problema: Incidente de seguridad', '2023-05-12', 2, true),
    ('Consulta sobre el software', 'Descripción del problema: Consulta sobre el software', '2023-06-08', 2, true),

    ('Problema de red', 'Descripción del problema: Problema de red', '2023-07-25', 3, true),
    ('Solicitud de mejora', 'Descripción del problema: Solicitud de mejora', '2023-08-18', 3, true),
    ('Error en la aplicación móvil', 'Descripción del problema: Error en la aplicación móvil', '2023-09-30', 3, true),

    ('Problema de hardware', 'Descripción del problema: Problema de hardware', '2023-10-15', 4, true),
    ('Solicitud de capacitación', 'Descripción del problema: Solicitud de capacitación', '2023-11-22', 4, true),
    ('Consulta sobre el hardware', 'Descripción del problema: Consulta sobre el hardware', '2023-12-05', 4, true),

    ('Error en la base de datos', 'Descripción del problema: Error en la base de datos', '2023-01-08', 5, true),
    ('Problema con la interfaz de usuario', 'Descripción del problema: Problema con la interfaz de usuario', '2023-02-17', 5, true),
    ('Consulta sobre la seguridad', 'Descripción del problema: Consulta sobre la seguridad', '2023-03-23', 5, true),

    ('Solicitud de mantenimiento', 'Descripción del problema: Solicitud de mantenimiento', '2023-04-05', 6, true),
    ('Error de integración', 'Descripción del problema: Error de integración', '2023-05-19', 6, true),
    ('Problema con el servidor', 'Descripción del problema: Problema con el servidor', '2023-06-28', 6, true);

-- Para id_usuario = 1
INSERT INTO empleados (nombre, correo, puesto, salario, telefono, activo, id_usuario)
VALUES
    ('Empleado4 Apellido4', 'empleado4@email.com', 'Analista', 55000.00, '555-4444', true, 1),
    ('Empleado5 Apellido5', 'empleado5@email.com', 'Desarrollador', 60000.00, '555-5555', true, 1),
    ('Empleado6 Apellido6', 'empleado6@email.com', 'Gerente', 70000.00, '555-6666', true, 1),
    ('Empleado7 Apellido7', 'empleado7@email.com', 'Analista', 55000.00, '555-7777', true, 3),
    ('Empleado8 Apellido8', 'empleado8@email.com', 'Desarrollador', 60000.00, '555-8888', true, 3),
    ('Empleado9 Apellido9', 'empleado9@email.com', 'Gerente', 70000.00, '555-9999', true, 3),
    ('Empleado10 Apellido10', 'empleado10@email.com', 'Analista', 55000.00, '555-1010', true, 4),
    ('Empleado11 Apellido11', 'empleado11@email.com', 'Desarrollador', 60000.00, '555-1111', true, 4),
    ('Empleado12 Apellido12', 'empleado12@email.com', 'Gerente', 70000.00, '555-1212', true, 4),
    ('Empleado13 Apellido13', 'empleado13@email.com', 'Analista', 55000.00, '555-1313', true, 5),
    ('Empleado14 Apellido14', 'empleado14@email.com', 'Desarrollador', 60000.00, '555-1414', true, 5),
    ('Empleado15 Apellido15', 'empleado15@email.com', 'Gerente', 70000.00, '555-1515', true, 5),
    ('Empleado16 Apellido16', 'empleado16@email.com', 'Analista', 55000.00, '555-1616', true, 6),
    ('Empleado17 Apellido17', 'empleado17@email.com', 'Desarrollador', 60000.00, '555-1717', true, 6),
    ('Empleado18 Apellido18', 'empleado18@email.com', 'Gerente', 70000.00, '555-1818', true, 6);

    

