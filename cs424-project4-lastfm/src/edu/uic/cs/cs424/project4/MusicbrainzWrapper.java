package edu.uic.cs.cs424.project4;

/**
 * 
 */
import java.io.IOException;
import java.util.List;

import com.hp.hpl.jena.rdf.model.Model;
import com.ldodds.musicbrainz.Artist;
import com.ldodds.musicbrainz.BeanPopulator;
import com.ldodds.musicbrainz.MusicBrainz;
import com.ldodds.musicbrainz.MusicBrainzImpl;


/**
 * @author zitterbewegung
 *
 */
public class MusicbrainzWrapper {
	private MusicBrainz server = new MusicBrainzImpl();
	
	/**
	 * @param args
	 */
	public String getArtistByid(String inputId){
		 Model results = null;
		 try {
			results = server.getArtistById(inputId, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 List<Artist> artists = BeanPopulator.getArtists(results);
		 Artist query = artists.get(0);
		 
		return query.getName();
		
	}
	public static void main(String[] args) {
		MusicbrainzWrapper myMusicBrainzWrapper = new MusicbrainzWrapper();
		System.out.println(myMusicBrainzWrapper.getArtistByid("f1b1cf71-bd35-4e99-8624-24a6e15f133a"));
		
		// TODO Auto-generated method stub

	}

}
