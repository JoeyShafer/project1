//Complete this...
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Class that finds the Hamming distance between two Strings.
 * Reads in file and and then calculates the hamming distance
 * @author Joey Shafer
 * @version 2019-09-19
 */
public class HammingDist 
{
	/*
	 * Array to hold all the station ID's from a file.
	 */
	private String[] stations;
	
	/*
	 * Capacity of stations array.
	 */
	private int capacity;
	
	/*
	 * The number of stations in the station array.
	 */
	private int numOfStations;
	
	/*
	 * The station Id for Norman. 
	 */
	private final String normanId = "NRMN";
	
	/*
	 * The station Id for the first station. 
	 */
	private String STID1;
	
	/*
	 * The station Id for the second station. 
	 */
	private String STID2;
	
	/*
	 * The hamming distance from Norman and another station.
	 */
	private int hammingDistNRMN;
	
	
	/*
	 * Constructor for HammingDist takes two station id's to compare.
	 * 
	 * @param STID1 The station Id of the first station to be compared.
	 * @param STID2 The station Id of the second station to be compared. 
	 */
	public HammingDist(String STID1, String STID2) throws IOException  
	{
		read();
		this.STID1 = STID1;
		this.STID2 = STID2;
	}
	
	/*
	 * Expands the array that is used to hold the station Id's.
	 */
	private void expandArray() {
		//Double the capacity of the array
		int newCapacity = capacity * 2;
		String[] newStations = new String[newCapacity];
		
		//Copy old array into new array.
		for (int i = 0; i < stations.length; i++) {
			newStations[i] = stations[i]; 
		}
		stations = newStations;
		capacity = newCapacity;
		
	}
	
	
	/*
	 * Loads a list of station Id's from a txt file. Each line repersents one station.
	 * 
	 *  @Param filename name of txt file that will be read in.
	 */
	public void read() throws IOException
	{
		// Declare a BufferReader to read in file.
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
        String strg;
        
        // Initialize stations array to a small number.
        capacity = 10;
        stations = new String[capacity];
        // Keep count of number of lines in file.
        int lineNum = 0;
        
        // Read in and throw out the first five lines of the file to get to station Id's.
        for (int i = 0; i < 6; ++i) {
        	strg = br.readLine();
        	++lineNum; 
        }
        
        //read in first line of station Id's.
        strg = br.readLine();
        
        numOfStations = 0;
        while (strg != null) {
        	//Check if the the array has enough capacity to store line if not expand array.
        	if (capacity == lineNum) {
        		expandArray();
        	}
        	
        	// Get the station Id from the line and add to staion array.
        	String stationID = strg.substring(4, 8);
        	stations[numOfStations] = stationID;
        	
        	//Read next line and increase lineNum and index.
        	strg = br.readLine();
        	++lineNum;
        	++numOfStations;
        	
        }
       
        br.close();
		
	}
	
	/*
	 * Calculates the hamming distance between Norman and another station.
	 * 
	 * @param STID The station Id of the station to be compared to Norman.
	 */
	public int calculateHammingDistFromNRMN(String STID) {
		int hammingDist = 0;
		
		// Loop through the station and compare each char.
		for (int i = 0; i < 4; ++i) {
			if (normanId.charAt(i) != STID.charAt(i)) {
				++hammingDist;
			}
		}
		hammingDistNRMN = hammingDist;
		return hammingDistNRMN;
	}
	
	/*
	 * Calculates the hamming distance between two different stations.
	 * 
	 * @param STID1 The station Id of the first station to be compared.
	 * @param STID2 The station Id of the second station to be compared.
	 */
	public int calculateHammingDist(String STID1, String STID2) {
		int hammingDist = 0;
		
		// Loop through the station and compare each char.
		for (int i = 0; i < 4; ++i) {
			if (STID1.charAt(i) != STID2.charAt(i)) {
				++hammingDist;
			}
		}
		return hammingDist;
	}
	
	/*
	 * Takes one station Id and a specific hamming distance and finds the number. 
	 * of stations that the have the same hamming distance from the station.
	 * 
	 * @param STID The station Id.
	 * @Param hammingDist The hamming distance. 
	 */
	public int NumStationsWithHammingDist(String STID, int hammingDist) {
		int numStations = 0;
		
		
		// Loop through every staion and check if if they have the same hamming distance.
		for (int i = 0; i < numOfStations; ++i) {
			int hamDist = calculateHammingDist(STID, stations[i]);
			
			// if hamming distances match increase the number of stations.
			if (hamDist == hammingDist) {
				++numStations;
			}
		}
		return numStations;
	}
	
	/*
	 * Print out formated information about the Hamming Distance between the stations.
	 * 
	 * @return A String that contains information about the Hamming Distance between stations. 
	 * Formated as "The Hamming Distance between Norman and station is dist and for station: dist 
	 * For station, number for stations with the Hamming Distance dist is numStations, and 
	 * for station, number for stations with the Hamming Distance dist is numStations."
	 */
	@Override
	public String toString() {
		// calculate the hamming distance from Norma.n 
		int hammingDistNRMN1 = calculateHammingDistFromNRMN(STID1);
		int hammingDistNRMN2 = calculateHammingDistFromNRMN(STID2);
		
		// Create strings to repersent each line and then combine them.
		String line1 = "The Hamming Distance between Norman and " + STID1 + " is " + hammingDistNRMN1
							+ " and for " + STID2 + ": " + hammingDistNRMN2 + ".\n";
		String line2 = "For " + STID1 + ", number of stations with Hamming Distance " 
						+ hammingDistNRMN1 + " is " + NumStationsWithHammingDist(STID1,hammingDistNRMN)
						+ ", and\n";
		String line3 = "for " + STID2 + ", number of stations with Hamming Distance " 
				+ hammingDistNRMN2 + " is " + NumStationsWithHammingDist(STID2,hammingDistNRMN) + ".";
		return line1 + line2 + line3;
	}
}