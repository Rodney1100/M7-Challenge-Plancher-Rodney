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

drop database if exists music_store_recommendations;
create database music_store_recommendations;
use music_store_recommendations;

create table label_recommendation (
    label_recommendation_id int primary key auto_increment,
    label_id int not null,
    user_id int not null,
    liked bool not null
);

create table artist_recommendation (
    artist_recommendation_id int primary key auto_increment,
    artist_id int not null,
    user_id int not null,
    liked bool not null
);

create table album_recommendation (
    album_recommendation_id int primary key auto_increment,
    album_id int not null,
    user_id int not null,
    liked bool not null
);

create table track_recommendation (
    track_recommendation_id int primary key auto_increment,
    track_id int not null,
    user_id int not null,
    liked bool not null
);