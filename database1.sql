PGDMP         '        	        x         	   database1    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16601 	   database1    DATABASE     f   CREATE DATABASE database1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE database1;
                postgres    false            �            1259    17355    message    TABLE     x   CREATE TABLE public.message (
    message_id bigint NOT NULL,
    message character varying(255),
    user_id bigint
);
    DROP TABLE public.message;
       public         heap    postgres    false            �            1259    17353    message_message_id_seq    SEQUENCE        CREATE SEQUENCE public.message_message_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.message_message_id_seq;
       public          postgres    false    201            �           0    0    message_message_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.message_message_id_seq OWNED BY public.message.message_id;
          public          postgres    false    200            �            1259    17363 	   user_name    TABLE     �   CREATE TABLE public.user_name (
    user_id bigint NOT NULL,
    user_password character varying(255),
    user_name character varying(255)
);
    DROP TABLE public.user_name;
       public         heap    postgres    false            �            1259    17361    user_name_user_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.user_name_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.user_name_user_id_seq;
       public          postgres    false    203            �           0    0    user_name_user_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.user_name_user_id_seq OWNED BY public.user_name.user_id;
          public          postgres    false    202            )           2604    17358    message message_id    DEFAULT     x   ALTER TABLE ONLY public.message ALTER COLUMN message_id SET DEFAULT nextval('public.message_message_id_seq'::regclass);
 A   ALTER TABLE public.message ALTER COLUMN message_id DROP DEFAULT;
       public          postgres    false    200    201    201            *           2604    17366    user_name user_id    DEFAULT     v   ALTER TABLE ONLY public.user_name ALTER COLUMN user_id SET DEFAULT nextval('public.user_name_user_id_seq'::regclass);
 @   ALTER TABLE public.user_name ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    202    203    203            �          0    17355    message 
   TABLE DATA           ?   COPY public.message (message_id, message, user_id) FROM stdin;
    public          postgres    false    201   �       �          0    17363 	   user_name 
   TABLE DATA           F   COPY public.user_name (user_id, user_password, user_name) FROM stdin;
    public          postgres    false    203   �       �           0    0    message_message_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.message_message_id_seq', 12, true);
          public          postgres    false    200            �           0    0    user_name_user_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.user_name_user_id_seq', 6, true);
          public          postgres    false    202            ,           2606    17360    message message_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_pkey PRIMARY KEY (message_id);
 >   ALTER TABLE ONLY public.message DROP CONSTRAINT message_pkey;
       public            postgres    false    201            .           2606    17371    user_name user_name_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.user_name
    ADD CONSTRAINT user_name_pkey PRIMARY KEY (user_id);
 B   ALTER TABLE ONLY public.user_name DROP CONSTRAINT user_name_pkey;
       public            postgres    false    203            /           2606    17372 #   message fkepv1sn13hvttj96uu0jf6n0e3    FK CONSTRAINT     �   ALTER TABLE ONLY public.message
    ADD CONSTRAINT fkepv1sn13hvttj96uu0jf6n0e3 FOREIGN KEY (user_id) REFERENCES public.user_name(user_id);
 M   ALTER TABLE ONLY public.message DROP CONSTRAINT fkepv1sn13hvttj96uu0jf6n0e3;
       public          postgres    false    2862    203    201            �   �   x�u�M
�0�s�q����LGm6�Ϡ.*[����ƿR!������FS�bÖ-f-�:a�2����s~²��3�3��XD�X@cX����+,☿�6Mh��3�O�X�YB=+��k�w߭C �gW����7e���V������& �3}Ft�yU�q��(����}����=�1�%E?K]�>k���� x �y*      �   ,   x���	 0��o��c�i��%Ȳ=)Um�d���\�2y��$     