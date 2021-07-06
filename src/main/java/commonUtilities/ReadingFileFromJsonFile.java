package commonUtilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ReadingFileFromJsonFile {

    public Map<String,String> readJsonFileAndConvertToMap() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/main/resources/samplejson.txt"));
        Map<String, String> hashMap = new HashMap<>();
        String jsonText = "";
        try{
            StringBuilder sb = new StringBuilder();
            // since we have taken string builder class while appenidn new text it consume existing object reference and update the string where as string it will  new object reference everytime it update and memore will be match out in heap so stringbuilder referred here.
            String line = bufferedReader.readLine();
            while(line!=null){
                sb.append(line);
                sb.append("\n");
                line = bufferedReader.readLine();
            }
            jsonText = sb.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            hashMap = objectMapper.readValue(jsonText, new TypeReference<Map<String, String>>() {
                    });
                    System.out.println(hashMap);
        }catch(Exception e){
            e.printStackTrace();
        }

        return hashMap;
    }

    public static void main(String[] args) throws Exception {
//readJsonFileAndConvertToMap();
    }
}
