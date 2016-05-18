-- Creación de DB: "GestorDeportivo"

CREATE DATABASE "GestorDeporfdhgtivo"
  WITH OWNER = postgres;


  

-- Creación de tabla: campeonato

CREATE TABLE public.campeonato
(
  "NOMBRE" text NOT NULL,
  CONSTRAINT campeonato_pkey PRIMARY KEY ("NOMBRE")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.campeonato
  OWNER TO postgres;




-- Creación de tabla: posicion

CREATE TABLE public.posicion
(
  "POSICION" text NOT NULL,
  CONSTRAINT posicion_pkey PRIMARY KEY ("POSICION")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.posicion
  OWNER TO postgres;




-- Creación de tabla: estadio

CREATE TABLE public.estadio
(
  "NOMBRE" text NOT NULL,
  "CAPACIDAD" numeric,
  CONSTRAINT estadio_pkey PRIMARY KEY ("NOMBRE")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.estadio
  OWNER TO postgres;




-- Creación de tabla: equipo

CREATE TABLE public.equipo
(
  "NOMBRE" text NOT NULL,
  "ESTADIO" text,
  "CAMPEONATO" text,
  CONSTRAINT equipo_pkey PRIMARY KEY ("NOMBRE"),
  CONSTRAINT "equipo_CAMPEONATO_fkey" FOREIGN KEY ("CAMPEONATO")
      REFERENCES public.campeonato ("NOMBRE") MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT "equipo_ESTADIO_fkey" FOREIGN KEY ("ESTADIO")
      REFERENCES public.estadio ("NOMBRE") MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.equipo
  OWNER TO postgres;




-- Creación de tabla: entrenador

CREATE TABLE public.entrenador
(
  "ID" integer NOT NULL,
  "NOMBRE" text,
  "APELLIDOS" text,
  "EDAD" numeric,
  "PAIS" text,
  "TELEFONO" numeric,
  "CORREO" text,
  "EQUIPO" text,
  "ESTADO" text,
  CONSTRAINT entrenador_pkey PRIMARY KEY ("ID"),
  CONSTRAINT "entrenador_EQUIPO_fkey" FOREIGN KEY ("EQUIPO")
      REFERENCES public.equipo ("NOMBRE") MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.entrenador
  OWNER TO postgres;




-- Creación de tabla: jugador

CREATE TABLE public.jugador
(
  "ID" integer NOT NULL,
  "NOMBRE" text,
  "APELLIDOS" text,
  "NUMERO" numeric,
  "EDAD" numeric,
  "PAIS" text,
  "TELEFONO" numeric,
  "CORREO" text,
  "EQUIPO" text,
  "POSICION" text,
  "ESTADO" text,
  CONSTRAINT jugador_pkey PRIMARY KEY ("ID"),
  CONSTRAINT "jugador_EQUIPO_fkey" FOREIGN KEY ("EQUIPO")
      REFERENCES public.equipo ("NOMBRE") MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT "jugador_POSICION_fkey" FOREIGN KEY ("POSICION")
      REFERENCES public.posicion ("POSICION") MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.jugador
  OWNER TO postgres;