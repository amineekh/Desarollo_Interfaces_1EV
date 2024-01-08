package Properties;

import java.io.IOException;
import java.util.Properties;

public class MyProperties extends Properties{
    public MyProperties(String language){
        if(language.equals("ESPAÑOL")){
            getMyProperties("Espanol.properties");
        }else if(language.equals("INGLES")){
            getMyProperties("Ingles.properties");
        }else {
            getMyProperties("Espanol.properties");
        }
    }
    private void getMyProperties(String language){
        try{
            this.load(getClass().getResourceAsStream(language));
        } catch (IOException ex){
            System.out.println(ex.getCause());
        }
    }

}
