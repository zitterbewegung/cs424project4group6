
create table profile (user_mboxsha1 VARCHAR, gender CHAR(1),age INTEGER,country VARCHAR,signup TIMESTAMP);                                                                                       
create table top_ten (usersha1 CHAR(40), musicbrainz_artist_id CHAR(40) ,artist VARCHAR, plays INTEGER); 
copy top_ten from '/data/lastfm-dataset-360K/usersha1-artmbid-artname-plays.tsv' WITH NULL AS '';
copy profile from '/data/lastfm-dataset-360K/usersha1-profile.tsv' WITH NULL AS ''; 
create table tracks_listened (usersha1 CHAR(40), musicbrainz_artist_id CHAR(40) ,artist_name VARCHAR, musicbrainz_track_id CHAR(40), empty CHAR(1), track_name VARCHAR); 