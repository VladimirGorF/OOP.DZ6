package Notes;
import java.util.List;

public class NoteController {
    private final StorageInterf storageInterf;

    public NoteController(StorageInterf storageInterf) {
        this.storageInterf = storageInterf;
    }

    public void saveNote(Note note) throws Exception {
        storageInterf.CreateNote(note);
    }

    public void updateNote(Note note, Fields field, String param) throws Exception {
        storageInterf.UpdateNote(note, field, param);
    }

    public Note readNote(String noteId) throws Exception {
        List<Note> notes = storageInterf.getAllNote();
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }

        throw new Exception("Note not found");
    }

    public Note deleteNote(String noteId) throws Exception { //   удаление из записок
        List<Note> notes = storageInterf.getAllNote();
        System.out.println("Работает контроллер: запись удаляется из списка...");
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                notes.remove(note);
                storageInterf.deleteNote(notes);  // вызываем интрефейс StoragInterf
                return note;
            }
        }

        throw new Exception("Note not found");
    }

    public List<Note> getNotes() throws Exception {
        return storageInterf.getAllNote();
    }

}
