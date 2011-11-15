
create table tracks_listened (userid CHAR(11), when_listened TIMESTAMP ,artist_id CHAR(36), artist_name VARCHAR, track_id CHAR(36), track_name VARCHAR) ; 
COPY tracks_listened from '/data/lastfm-dataset-1K/userid-timestamp-artid-artname-traid-traname.tsv'  WITH NULL AS ''; 