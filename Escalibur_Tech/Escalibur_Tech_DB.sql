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
    usuario VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    apellidos varchar (50) not null,
    correo varchar (100) not null UNIQUE,
    empresa VARCHAR(100) NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    telefono varchar(40) NOT NULL,
    activo boolean
);

CREATE TABLE rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre_rol varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuarios(id)
);

CREATE TABLE tiquetes (
    id_tiquete INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion varchar (60) not null,
    fecha_apertura DATE,
    id_usuario INT, -- Agregado para establecer la relación con el usuario
    activo boolean,
    foreign key fk_tiquete_usuario (id_usuario) references usuarios(id)
);


INSERT INTO usuarios (nombre, usuario, password, apellidos, correo, empresa, puesto, salario, telefono, activo)
VALUES
    ('Juan', 'juan123', 'contraseña123', 'Pérez', 'juan@email.com', 'Empresa A', 'Analista', 50000.00, '555-1234', true),
    ('María', 'maria456', 'clave_secreta', 'López', 'maria@email.com', 'Empresa B', 'Desarrollador', 60000.00, '555-5678', true),
    ('Carlos', 'carlos789', 'micontraseña', 'González', 'carlos@email.com', 'Empresa C', 'Gerente', 80000.00, '555-9876', true),
    ('Laura', 'laura101', 'password123', 'Martínez', 'laura@email.com', 'Empresa A', 'Analista', 55000.00, '555-4321', true),
    ('Pedro', 'pedro2022', 'segura123', 'Ramírez', 'pedro@email.com', 'Empresa B', 'Desarrollador', 65000.00, '555-8765', true);

INSERT INTO rol (nombre_rol, id_usuario)
VALUES
    ('Administrador', 1),
    ('Usuario Estándar', 2),
    ('Usuario Estándar', 3),
    ('Administrador', 4),
    ('Usuario Estándar', 5);

INSERT INTO tiquetes (descripcion, fecha_apertura, id_usuario, activo)
VALUES
    ('Problema con la impresora', '2023-01-15', 1, true),
    ('Error en el sistema', '2023-02-10', 2, true),
    ('Solicitud de mantenimiento', '2023-03-05', 3, true),
    ('Consulta sobre el software', '2023-04-20', 4, true),
    ('Problema de red', '2023-05-12', 5, true);
