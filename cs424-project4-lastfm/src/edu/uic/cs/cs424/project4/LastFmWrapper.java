package edu.uic.cs.cs424.project4;

import java.util.Collection;

import de.umass.lastfm.Artist;
import de.umass.lastfm.Chart;
import de.umass.lastfm.PaginatedResult;
import de.umass.lastfm.Track;

public class LastFmWrapper {
	private static String key = "16fdacc5a11d94902d8977f40c25cdce"; //this is the key used in the last.fm API examples online.
	public static String getTopTracks(){
		String returnVar = "";
		PaginatedResult<Track> topTracks = Chart.getTopTracks(key);
		System.out.println("Top Tracks on last.fm");
		
		for (Track track : topTracks.getPageResults()) {
			returnVar.concat(track.getName());
			returnVar.concat(Integer.toString(track.getPlaycount()));
			System.out.printf("%s (%d plays)%n", track.getName(), track.getPlaycount());
			}
		return returnVar;	
		}
	public static String getRelArtist(String artist){
		String returnVar = "";
		System.out.println("Related artist to " + artist);
		Collection<Artist> similarArtists = Artist.getSimilar(artist, key);
		for (Artist artist2 : similarArtists) {
			returnVar = returnVar + artist2.getName() + "\n";
			
		}
		return returnVar;
		
	}
	public static void main(String[] args) {
		if(args[0].equals("test")){
			System.out.println(getTopTracks() + getRelArtist("Coldplay"));
		}
		
		
	}
}
