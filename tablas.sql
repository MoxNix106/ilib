CREATE SCHEMA libros AUTHORIZATION postgres; 
SET search_path TO libros;

-- Script para crear las tablas de la base de datos
CREATE TABLE IF NOT EXISTS public.administradores (
    id SERIAL PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT now() NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT now() NOT NULL
);

CREATE TABLE IF NOT EXISTS public.books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    date VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    edit VARCHAR(255) NOT NULL,
    lang VARCHAR(255) NOT NULL,
    pages VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    ejemplares VARCHAR(255) NOT NULL,
    stock INTEGER NOT NULL,
    available INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS public.lendings (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    date_out VARCHAR(255) NOT NULL,
    date_return VARCHAR(255),
    CONSTRAINT fk_lendings_book FOREIGN KEY (book_id) REFERENCES public.books (id) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_lendings_user FOREIGN KEY (user_id) REFERENCES public.users (id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE INDEX IF NOT EXISTS idx_lendings_user ON public.lendings (user_id);

CREATE TABLE IF NOT EXISTS public.personal (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    id_administrador INTEGER,
    fecha_creacion TIMESTAMP DEFAULT now() NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT now() NOT NULL,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    CONSTRAINT personal_id_administrador_fkey FOREIGN KEY (id_administrador) REFERENCES public.administradores (id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    last_name_p VARCHAR(30) NOT NULL,
    last_name_m VARCHAR(30) NOT NULL,
    domicilio VARCHAR(250),
    tel VARCHAR(25),
    sanctions INTEGER DEFAULT 0,
    sanc_money INTEGER DEFAULT 0 NOT NULL
);


set search_path to libros;
set datestyle to sql, dmy;

INSERT INTO public.administradores VALUES
	(1, 'administrador1', 'admin1', 'administrador@gamail.com');

