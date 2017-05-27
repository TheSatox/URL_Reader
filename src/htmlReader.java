import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by eros14 on 2017-01-20.
 */
public class htmlReader {
    public static void main(String[] args) throws Exception {
        String url = "https://www.oracle.com/index.html";
        URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.contains("href=") && inputLine.contains("http")){
                int start = inputLine.indexOf("href=");
                int stop = inputLine.indexOf("\"", start+6);
                if (stop < 0){
                    stop = inputLine.indexOf(">", start+6);
                }

                String link = inputLine.substring(start+6, stop);
                if (!inputLine.contains("[!--$")){
                    System.out.println(link);
                }

            }


        }


        in.close();

    }

}

