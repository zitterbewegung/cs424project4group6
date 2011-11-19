package edu.uic.cs.cs424.project4;

import java.util.Collection;

import de.umass.lastfm.Artist;
import de.umass.lastfm.Chart;
import de.umass.lastfm.PaginatedResult;
import de.umass.lastfm.Track;

/**
 * @author zitterbewegung
 *
 */
public class LastFmWrapper {
	private static String key = "16fdacc5a11d94902d8977f40c25cdce"; //this is the key that I generated
	/**
	 * @return String 
	 * This returns a string with the the set of
	 */
	public static String getTopTracks(){
		String returnVar = "";
		PaginatedResult<Track> topTracks = Chart.getTopTracks(key);
		System.out.println("Top Tracks on last.fm");
		
		for (Track track : topTracks.getPageResults()) {
			returnVar = returnVar + track.getName();
			returnVar = returnVar + Integer.toString(track.getPlaycount());
			//System.out.printf("%s (%d plays)%n", track.getName(), track.getPlaycount());
			}
		return returnVar;	
		}
	
	/**
	 * @param artist 
	 * This parameter is a string which is the artist to get a relative
	 * @return
	 */
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
