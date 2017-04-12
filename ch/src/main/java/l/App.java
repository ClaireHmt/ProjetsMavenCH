package l;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int monmax = 0 ;

    	try {
    		CSVReader reader = new CSVReader(new FileReader("data.csv")) ;
    		CSVWriter writer = new CSVWriter(new FileWriter("data-filtered.csv"),',', CSVWriter.NO_QUOTE_CHARACTER);
    		try{
    			List<String[]> myEntries = reader.readAll() ;
    		for(String[] line: myEntries){
    			List<String> list = Arrays.asList(line);
            	Vector<String> out = new Vector<String>();
            	CollectionUtils.select(list, new Monpredicat<String>(), out);
            	System.out.println("OUT:" + out);
    			for (String val : line){
    				System.out.println("Valeur lue : "+ val);
    				monmax=max(Integer.parseInt(val), monmax);
    			}
    			writer.writeNext(out.toArray(new String[0]));}

    		System.out.println("maximum : "+ monmax);
    		}
    		catch (IOException e){
    			System.out.println("Erreur all");
    		}
    		reader.close();
    		writer.close();
    	}
    	catch (FileNotFoundException e){
    		System.out.println("Erreur");
    	} catch (IOException e) {
			e.printStackTrace();
		}

        //System.out.println( "Hello World!" );
        //System.out.println("max : " + max(4,5));
    }
    public static int max(int a, int b)
    {
    	return a>b ? a:b;
    	//return a; // Le stagiaire est passe par la
    }}