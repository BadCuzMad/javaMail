import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface FactLib {
  Map<Author, LBook> createLib(@NotNull String fpath);

}
