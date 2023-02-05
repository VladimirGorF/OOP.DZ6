package Notes;

import java.util.List;

public interface StorageInterf {
    List<Note> getAllNote();
    void CreateNote(Note note);
    void UpdateNote(Note note, Fields field, String param);
    void deleteNote(List notes);
}
