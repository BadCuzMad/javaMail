import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.nio.file.Files;

import java.util.List;
import java.util.Map;


public class JsonLib implements FactLib {

    public static void libToJson() throws IOException {
        try(FileWriter writer = new FileWriter("BookInfo.txt", false)) {
            File p = new File("LibFile.txt");
            List<String> jsonString = Files.readAllLines(p.toPath());
            Gson gson = new Gson();
            String jsonFile = gson.toJson(jsonString);
            writer.write(jsonFile);
        }
    }



    @SneakyThrows
    @Override
    public Map<Author, LBook> createLib(@NotNull String fpath) {

        File p = new File(fpath);

        @NotNull String jsonString = String.valueOf(Files.readAllLines(p.toPath()));

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Type type = new TypeToken<Map<Author,LBook>>(){}.getType();

        Map<Author,LBook> map = gson.fromJson(jsonString, type);


        return map;
    }
    public void outputLib(@NotNull String fpath){
        Map<Author,LBook> map = createLib(fpath);
        for(Map.Entry<Author,LBook> item:map.entrySet()){
            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
        }
    }
    public void pickABook(@NotNull String fpath, @NotNull String authorName){
        Map<Author,LBook> map = createLib(fpath);

        Object[] t = map.entrySet().toArray();


        switch (authorName) {
            case "FirstAu":
                System.out.println(t[0]);
                break;
            case "SecondAu":
                System.out.println(t[1]);
                break;
            default:
                System.out.println("Книг такого автора нет");

        }

    }
}
