import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebpageCounter {
    public static int countLine(String urlString)
        throws MalformedURLException, IOException{
            int count = 0; 
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            while(input.hasNext()){
                input.nextLine();
                count++;
            }
            return count;

        }

}

class TestWebpageCounter {
    public static void main(String[]args){
        System.out.print("Enter a URL");
        Scanner input = new Scanner(System.in);
        String urlString = input.next();
        try{
            int count = WebpageCounter.countLine(urlString);
            System.out.print("The webpage has "+ count +" lines of code.");

        }
        catch(MalformedURLException ex){
            System.out.print("Error: URL must have a protocol such as https;//");
        
        }
        catch(IOException ex){
            System.out.print("Error: The URL does not exist or does not accept connection");
        }

    }
}