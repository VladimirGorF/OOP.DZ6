package Notes;

public class Programm {
    public static void main(String[] args) {
        FileOperInterf fileOperInterf = new FileOperator("notes.txt");
        StorageInterf storageInterf = new Storage(fileOperInterf);
        NoteController controller = new NoteController(storageInterf);
        ViewNote view = new ViewNote(controller);
        view.run();
    }
}
