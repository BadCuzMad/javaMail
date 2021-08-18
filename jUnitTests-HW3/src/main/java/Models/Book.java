package Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Book {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Author author;
}
