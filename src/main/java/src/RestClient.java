package src;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RestClient {

    public static void main(String[] args) throws IOException {

        /* ---- 1 metoda ---- dla zlozonych jsonow*/
        //podajemy adres bazowy API
        URL urlCatFact = new URL("https://cat-fact.herokuapp.com/facts/random");

        //zaciagamy zawartosc adresu
        InputStreamReader readerCatFact = new InputStreamReader(urlCatFact.openStream());

        //konwertujemy zaciagnietego jsona do pojo (wczesniej tworzac sobie
        //klase CatFact z odpowiednimi polami
        //(model stworzony generatorem online na podstawie odpowiedzi json)
        CatFact catFact = new Gson().fromJson(readerCatFact, CatFact.class);

        //printujemy cos z obiektu korzystajac z metody
        System.out.println(catFact.getText());

        /* ---- 2 metoda ---- dla prostych jsonow*/
        URL urlCatImage = new URL("https://aws.random.cat/meow");
        InputStreamReader readerCatImage = new InputStreamReader(urlCatImage.openStream());
        JsonObject jsonObject = new JsonParser().parse(readerCatImage).getAsJsonObject();
        System.out.println(jsonObject.get("file").getAsString());

    }
}
