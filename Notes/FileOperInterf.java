package Notes;

import java.util.List;

public interface FileOperInterf {
    List<String> readAllLines();

    public void saveAllLines(List<String> lines);
}


