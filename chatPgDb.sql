PGDMP         6                x            chatPgDb    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16394    chatPgDb    DATABASE     g   CREATE DATABASE "chatPgDb" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "chatPgDb";
                postgres    false            �           0    0    DATABASE "chatPgDb"    COMMENT     ;   COMMENT ON DATABASE "chatPgDb" IS 'java chatApp database';
                   postgres    false    3001            �            1259    16404    messages    TABLE     r   CREATE TABLE public.messages (
    message_id integer NOT NULL,
    message text,
    user_id integer NOT NULL
);
    DROP TABLE public.messages;
       public         heap    postgres    false            �            1259    16402    messages_message_id_seq    SEQUENCE     �   ALTER TABLE public.messages ALTER COLUMN message_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.messages_message_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    203            �            1259    16397    users    TABLE     �   CREATE TABLE public.users (
    user_id integer NOT NULL,
    user_name character varying(20) NOT NULL,
    user_password character varying(20) NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16395    user_user_id_seq    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    201            �          0    16404    messages 
   TABLE DATA           @   COPY public.messages (message_id, message, user_id) FROM stdin;
    public          postgres    false    203   1       �          0    16397    users 
   TABLE DATA           B   COPY public.users (user_id, user_name, user_password) FROM stdin;
    public          postgres    false    201   N       �           0    0    messages_message_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.messages_message_id_seq', 1, false);
          public          postgres    false    202            �           0    0    user_user_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.user_user_id_seq', 1, false);
          public          postgres    false    200            ,           2606    16411    messages messages_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.messages
    ADD CONSTRAINT messages_pkey PRIMARY KEY (message_id);
 @   ALTER TABLE ONLY public.messages DROP CONSTRAINT messages_pkey;
       public            postgres    false    203            *           2606    16401    users user_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);
 9   ALTER TABLE ONLY public.users DROP CONSTRAINT user_pkey;
       public            postgres    false    201            -           2606    16412    messages fk_messages_users    FK CONSTRAINT     ~   ALTER TABLE ONLY public.messages
    ADD CONSTRAINT fk_messages_users FOREIGN KEY (user_id) REFERENCES public.users(user_id);
 D   ALTER TABLE ONLY public.messages DROP CONSTRAINT fk_messages_users;
       public          postgres    false    203    2858    201            �      x������ � �      �      x������ � �     