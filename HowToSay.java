import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
public class HowToSay{
     
    public static int binarySearch(String arr[], String word){
        int left = 0;
        int right = arr.length -1;
        
        //while not at the same spot 
        while(left<=right){
            //find middle
            int mid = left + (right -left) / 2;
            //if middle index is equal to woord
            String line = arr[mid];
            String lineWord = line.split("  ")[0];
            if(lineWord.equalsIgnoreCase(word)){
                //return mid           
                System.out.println(line.split("  ")[1]); 
                return mid;
            }
            //if mid is not the word
            if (lineWord.compareToIgnoreCase(word) < 0){
                //left is equal to mid +1 (go righ on left end)                
                left = mid + 1;
            }else{
               //else go to right end and go left 1
                right = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        //basic input for word
        Scanner input = new Scanner(System.in);
        System.out.print("Word: ");
        String word = input.next();
        
        boolean completeWhile = false;   
        // holder arryList
        List<String> rec = new ArrayList<>();

        try{
            //try to find fill in folder
            File filePath = new File("/home/murphy/Desktop/JavaStuff/Prononce/cmudict_0_6.txt");
            //make scanner
            Scanner reader = new Scanner(filePath);
            String[] dataSplit = {};
            //while reading through reader            
            while(reader.hasNextLine()){
                String wordData = reader.nextLine();
                String[] dataArray = wordData.split("  ");
                //make a readable array             
                rec.add(wordData);   
                //add string objects into rec                
                //if the word matches print out the pronounciation and complete it 
                if(word.equalsIgnoreCase(dataArray[0])){
                    completeWhile = true; 
                }

            }
            //make a string array object to turn rec into array
            String[] arrayHolder = rec.toArray(new String[0]); 

            //sort it
            Arrays.sort(arrayHolder);
            //call function print resuls where its located at     and the word 
            System.out.println("Word is located at index: "+ binarySearch(arrayHolder, word));            
            //if we havent fufilled our loop then print out the word isnt there
            if(completeWhile !=true){
                System.out.println("Cant find "+ word);
            }
        }catch (FileNotFoundException e){
            System.out.print("Not There");
        }
        
    }
}
