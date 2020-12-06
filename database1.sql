PGDMP     5    %                x         	   database1    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16452 	   database1    DATABASE     f   CREATE DATABASE database1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE database1;
                postgres    false            �            1259    16514    messages    TABLE     {   CREATE TABLE public.messages (
    message_id integer NOT NULL,
    message character varying(255),
    user_id integer
);
    DROP TABLE public.messages;
       public         heap    postgres    false            �            1259    16512    messages_message_id_seq    SEQUENCE     �   CREATE SEQUENCE public.messages_message_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.messages_message_id_seq;
       public          postgres    false    201            �           0    0    messages_message_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.messages_message_id_seq OWNED BY public.messages.message_id;
          public          postgres    false    200            �            1259    16522    users    TABLE     �   CREATE TABLE public.users (
    user_id integer NOT NULL,
    user_password character varying(255),
    user_name character varying(255)
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16520    users_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.users_user_id_seq;
       public          postgres    false    203            �           0    0    users_user_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;
          public          postgres    false    202            )           2604    16517    messages message_id    DEFAULT     z   ALTER TABLE ONLY public.messages ALTER COLUMN message_id SET DEFAULT nextval('public.messages_message_id_seq'::regclass);
 B   ALTER TABLE public.messages ALTER COLUMN message_id DROP DEFAULT;
       public          postgres    false    200    201    201            *           2604    16525    users user_id    DEFAULT     n   ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);
 <   ALTER TABLE public.users ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    202    203    203            �          0    16514    messages 
   TABLE DATA           @   COPY public.messages (message_id, message, user_id) FROM stdin;
    public          postgres    false    201   �       �          0    16522    users 
   TABLE DATA           B   COPY public.users (user_id, user_password, user_name) FROM stdin;
    public          postgres    false    203   �       �           0    0    messages_message_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.messages_message_id_seq', 1, false);
          public          postgres    false    200            �           0    0    users_user_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.users_user_id_seq', 1, false);
          public          postgres    false    202            ,           2606    16519    messages messages_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.messages
    ADD CONSTRAINT messages_pkey PRIMARY KEY (message_id);
 @   ALTER TABLE ONLY public.messages DROP CONSTRAINT messages_pkey;
       public            postgres    false    201            .           2606    16530    users users_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    203            /           2606    16531 $   messages fkpsmh6clh3csorw43eaodlqvkn    FK CONSTRAINT     �   ALTER TABLE ONLY public.messages
    ADD CONSTRAINT fkpsmh6clh3csorw43eaodlqvkn FOREIGN KEY (user_id) REFERENCES public.users(user_id);
 N   ALTER TABLE ONLY public.messages DROP CONSTRAINT fkpsmh6clh3csorw43eaodlqvkn;
       public          postgres    false    2862    203    201            �      x������ � �      �      x������ � �     