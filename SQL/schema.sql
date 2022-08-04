drop database if exists game_store_catalog;
create database game_store_catalog;
use game_store_catalog;

create table game (
    game_id int primary key auto_increment,
    title varchar(50) not null,
    esrb_rating varchar(50) not null,
    description varchar(255) not null,
    price decimal(5, 2) not null,
    studio varchar(50) not null,
    quantity int
);

create table console (
    console_id int primary key auto_increment,
    model varchar(50) not null,
    manufacturer varchar(50) not null,
    memory_amount varchar(20),
    processor varchar(20),
    price decimal(5, 2) not null,
    quantity int not null
);

create table tshirt (
    tshirt_id int primary key auto_increment,
    size varchar(20) not null,
    color varchar(20) not null,
    description varchar(255) not null,
    price decimal(5,2) not null,
    quantity int not null
);

drop database if exists game_store_invoicing;
create database game_store_invoicing;
use game_store_invoicing;

create table invoice (
    invoice_id int primary key auto_increment,
    `name` varchar(50) not null,
    street varchar(100) null,
    city varchar(50) not null,
    state varchar(20) not null,
    zipcode varchar(10) null,
    item_type varchar(50) not null,
    item_id int not null, -- links to either game, console, or t_shirt ids
    unit_price decimal(8,2) not null,
    quantity int not null,
    subtotal decimal(8,2) not null,
    tax decimal(8,2) not null,
    processing_fee decimal(8,2) not null,
    total decimal(8,2) not null
);

create table fee (
    product_type varchar(50) primary key,
    fee decimal(8,2) not null
);

create table tax (
    state char(2) primary key,
    rate decimal(8,2) not null
);

drop database if exists music_store_catalog;
create database music_store_catalog;
use music_store_catalog;

create table label (
    label_id int primary key auto_increment,
    `name` varchar(50) not null,
    website varchar(255) null
);

create table artist (
    artist_id int primary key auto_increment,
    `name` varchar(50) not null,
    instagram varchar(255) null,
    twitter varchar(255) null
);

create table album (
    album_id int primary key auto_increment,
    title varchar(50) not null,
    artist_id int not null,
    release_date date not null,
    label_id int not null,
    list_price decimal(5, 2) not null,
    index fk_artist_id (album_id),
    foreign key (artist_id)
        references artist(artist_id),
    index fk_label_id (label_id),
    foreign key (label_id)
        references label(label_id)
);

create table track (
    track_id int primary key auto_increment,
    album_id int not null,
    title varchar(50) not null,
    run_time int not null,
    index fk_album_id (album_id),
    foreign key (album_id)
        references album(album_id)
);