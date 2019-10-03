For this Project I had to create a program that would read in a txt file that contained the names for different weather stations. Then the program would take in two of the station Id's and find thier Hamming Distance from the Norman station, NRMN. After this the program would then find the number of staions that shared the same Hamming Distance from the stations as Norman did and would print out the results. To create this program I firist had to create a method that would read the txt file into a array of strings that would contain all the station Id's I also had to create a method that would expand the size of the array when the array's capacity was reached. Next I had to create the constructor for the HammingDistance oject the constructor would take Strings that would be the station Id's and assign them to two private instance variables, then the constructor would call the read method to read all the stations from the txt file. Next I created two methods that would calculate the Hamming distance between stations, one calculated distance from Norman, and the other would calculate the distance between any two stations. The last things I had to do were create a method that would take in a station Id and a Hamming Distance and find the number of stations with the shared the same Hamming Distance, then I created a toString method that would format all the information to print out.  

public void read()   
  This method would use a BufferedReader to read in the file Mesonet.txt and would store the station Id for every staion in a String array called stations and if the number of statons would be greater than the capacity of the array it would expand the array.
private void expandArray() 
  This method would double the capacity of the array stations by creating a new String array that would have station copied into it and then the method wouls assign the instance variable stations to the new array.
public int calculateHammingDistFromNRMN(String STID) 
  This method would take a sation Id and calculate the Hamming Distance between Norman, NRMN, and the station. The method would do this by looping through the station Id and would compare the char at each index to see if they were equal, if not the Hamming Distance would be increased by one.
public int calculateHammingDist(String STID1, String STID2) 
  This method would take two staion Id's and calculate the Hamming Distance between the two. The method would do this by looping through the station Ids and would compare the char at each index to see if they were equal, if not the Hamming Distance would be increased by one.
public int NumStationsWithHammingDist(String STID, int hammingDist) 
  This method would take a station Id and a Hamming Distance and would loop through the array numStations and would calculate the Hamming Distance between each station and if the Hamming Distance would was equal to the Hamming Distance that was entered the the number of stations would be incresed.
public String toString() 
  This method  return a String that contains information about the Hamming Distance between stations. Formated as:  
"The Hamming Distance between Norman and station is dist and for station: dist 
For station, number for stations with the Hamming Distance dist is numStations, and 
for station, number for stations with the Hamming Distance dist is numStations."
private String[] stations  
  Array to hold all the station ID's from a file.
private int capacity 
  Capacity of the stations array.
private int numOfStations   
  The number of stations in the stations array.
private final String normanId = "NRMN"  
  The station Id for Norman.
private String STID1 
  The station Id for the first station.
private String STID2  
  The station Id for the second station.
private int hammingDistNRMN  
  The Hamming Distance from Norman.​
