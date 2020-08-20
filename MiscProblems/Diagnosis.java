import java.util.*;
import java.io.*; 
import java.util.Map.*;

public class Diagnosis {


    public Diagnosis() {
    }



    // 1) get all Pairs for a patient
    // 2) Keep a global/higher scope track of the count for each pair
    // 3) once all rows have been processed, order the data structure in which I have been keeping
    // track of the counts

    /*
      
      Most commonly cooccurring pairs of diagnoses
      
     */
    public static List<Entry<String,Integer>> getOrderedPairs(Map<String, Integer> pairCount) {
	
	// Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
	    new LinkedList<Map.Entry<String, Integer> >(pairCount.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
		public int compare(Map.Entry<String, Integer> o1,  
				   Map.Entry<String, Integer> o2) 
		{ 
		    return (o1.getValue()).compareTo(o2.getValue()); 
		} 
	    }); 

	return list;
    }

    public static void getPairs(List<String> row, Map<String, Integer> pairCount) {
	List<String> pairs = new ArrayList<String>();
	for (int i = 0; i < row.size(); i++) {
	    for (int j = i+1; j < row.size(); j++) {
		String disease1 = row.get(i);
		String disease2 = row.get(j);
		String key = disease1+","+disease2;
		if (!pairCount.containsKey(key)) pairCount.put(key, 0);
		int val = pairCount.get(key);
		pairCount.put(key, val+1);
	    }
	}
	//return pairs;
    }

    public static void main(String[] args) {
	File file = new File("/Users/karanwarrier/Downloads/medclaimscode_1k_slice.txt"); 
	
	String thisLine = null;
	Map<String, Integer> pairCount = new HashMap<String,Integer>();
      
	try {
	    // open input stream test.txt for reading purpose.
      
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    
	    boolean good = true;
	    while ((thisLine = br.readLine()) != null) {
		//System.out.println(thisLine);
		List<String> row = Arrays.asList(thisLine.split(","));
		getPairs(row, pairCount);
	    }

	    List<Entry<String,Integer>> orderedLst = getOrderedPairs(pairCount);
	    for (Entry<String, Integer> entry: orderedLst) {
		System.out.println(entry);
	    }

	} catch(Exception e) {
	    e.printStackTrace();
	}
    }
}
