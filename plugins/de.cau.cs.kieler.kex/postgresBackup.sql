PGDMP     1                    n           kex    8.4.1    8.4.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     )   SET standard_conforming_strings = 'off';
                       false            	           1262    69729    kex    DATABASE     �   CREATE DATABASE kex WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'German_Germany.1252' LC_CTYPE = 'German_Germany.1252';
    DROP DATABASE kex;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                       0    0    public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    3            <           2612    16386    plpgsql    PROCEDURAL LANGUAGE     $   CREATE PROCEDURAL LANGUAGE plpgsql;
 "   DROP PROCEDURAL LANGUAGE plpgsql;
             postgres    false            �           1259    69786    category    TABLE     X   CREATE TABLE category (
    id integer NOT NULL,
    name character varying NOT NULL
);
    DROP TABLE public.category;
       public         postgres    false    3            �           1259    69741    example    TABLE     �   CREATE TABLE example (
    id integer NOT NULL,
    title character varying NOT NULL,
    version character varying(3) DEFAULT 1.0 NOT NULL,
    description character varying NOT NULL,
    contact character varying
);
    DROP TABLE public.example;
       public         postgres    false    1785    3            �           1259    69794    example_resource    TABLE     #   CREATE TABLE example_resource (
);
 $   DROP TABLE public.example_resource;
       public         postgres    false    3            �           1259    69773    example_to_category    TABLE     �   CREATE TABLE example_to_category (
    id integer NOT NULL,
    example integer NOT NULL,
    category character varying NOT NULL
);
 '   DROP TABLE public.example_to_category;
       public         postgres    false    3            �           1259    69750    example_to_resource    TABLE     �   CREATE TABLE example_to_resource (
    id integer NOT NULL,
    example integer NOT NULL,
    resource_path character varying NOT NULL
);
 '   DROP TABLE public.example_to_resource;
       public         postgres    false    3                      0    69786    category 
   TABLE DATA                     public       postgres    false    1506   �                 0    69741    example 
   TABLE DATA                     public       postgres    false    1503   �                 0    69794    example_resource 
   TABLE DATA                     public       postgres    false    1507   �                 0    69773    example_to_category 
   TABLE DATA                     public       postgres    false    1505                    0    69750    example_to_resource 
   TABLE DATA                     public       postgres    false    1504           �           2606    69767 
   pk_example 
   CONSTRAINT     I   ALTER TABLE ONLY example
    ADD CONSTRAINT pk_example PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.example DROP CONSTRAINT pk_example;
       public         postgres    false    1503    1503            �           2606    69780    pk_example_to_category 
   CONSTRAINT     a   ALTER TABLE ONLY example_to_category
    ADD CONSTRAINT pk_example_to_category PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.example_to_category DROP CONSTRAINT pk_example_to_category;
       public         postgres    false    1505    1505            �           2606    69765    pk_example_to_resource 
   CONSTRAINT     a   ALTER TABLE ONLY example_to_resource
    ADD CONSTRAINT pk_example_to_resource PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.example_to_resource DROP CONSTRAINT pk_example_to_resource;
       public         postgres    false    1504    1504                        2606    69768 
   fk_example    FK CONSTRAINT     q   ALTER TABLE ONLY example_to_resource
    ADD CONSTRAINT fk_example FOREIGN KEY (example) REFERENCES example(id);
 H   ALTER TABLE ONLY public.example_to_resource DROP CONSTRAINT fk_example;
       public       postgres    false    1504    1503    1786                       2606    69781 
   fk_example    FK CONSTRAINT     q   ALTER TABLE ONLY example_to_category
    ADD CONSTRAINT fk_example FOREIGN KEY (example) REFERENCES example(id);
 H   ALTER TABLE ONLY public.example_to_category DROP CONSTRAINT fk_example;
       public       postgres    false    1786    1505    1503               
   x���             
   x���             
   x���             
   x���             
   x���         