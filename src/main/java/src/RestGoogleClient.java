package src;

import com.google.gson.Gson;
import src.model.GooglePlace;
import src.model.Result;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RestGoogleClient {

    public static void main(String[] args) throws IOException{
          /* ---- 1 metoda ---- dla zlozonych jsonow*/
        //podajemy adres bazowy API
        URL url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                "location=52.7049372,21.0726343&" +
                "radius=4000&" +
                "types=church&" +
                "key=AIzaSyAV7ZuOIbXWy3D7oFitHswA3JynZSRvdEI");

        //zaciagamy zawartosc adresu
        InputStreamReader reader = new InputStreamReader(url.openStream());

        //konwertujemy zaciagnietego jsona do pojo (wczesniej tworzac sobie
        //klasy z odpowiednimi polami
        //(model stworzony generatorem online na podstawie odpowiedzi json)
        GooglePlace googlePlace = new Gson().fromJson(reader, GooglePlace.class);

        //printujemy cos z obiektu korzystajac z metody
        System.out.println(googlePlace.toString());

        for (Result result : googlePlace.getResults()) {
            System.out.println(result.getName());
        }
    }
}
