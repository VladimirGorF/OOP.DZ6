package Notes;

import java.util.Date;
import java.util.Scanner;

public class ViewNote {
    private final NoteController noteController;


    public ViewNote(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {
        Commands com = Commands.NONE;
        showHelp();
        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT)
                    return;
                switch (com) {
                    case CREATE:
                        create();
                        break;
                    case READ:
                        read();
                        break;
                    case DELETE:
                        delete(); 
                        break;  
                    case UPDATE:
                        update();
                        break;
                    case LIST:
                        list();
                        break;
                    case HELP:
                        showHelp();
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Произошла ошибка " + ex.toString());
            }
        }
    }


    private void read() throws Exception {
        String id = prompt("Идентификатор пользователя: ");
        Note note_ = noteController.readNote(id);
        System.out.println(note_);
    }

    private void update() throws Exception {
        String id = prompt("Идентификатор пользователя: ");
        String field_name = prompt("Какое поле (TITLE, TEXT): ").toUpperCase();
        String param = prompt("Введите новые данные. ");
        Note _note = noteController.readNote(id);
        noteController.updateNote(_note, Fields.valueOf(field_name.toUpperCase()), param);
    }

    private void delete() throws Exception {
        String id = prompt("Введите идентификатор пользователя для удаления: ");
        System.out.println(noteController.readNote(id));
        String yes = prompt("Подтвердите удалениe командой YES, а если передумали, то введите любой символ. ")
                .toUpperCase();
        if (yes.equals("YES")) {
            System.out.println("Происходит удаление записи...");
            noteController.deleteNote(id); // включаем удаление в контроллере
        } else {
            System.out.println("Удаление отменено.");
        }
    }

    private void list() throws Exception {
        for (Note note : noteController.getNotes()) {
            System.out.println(note);
        }
    }

    private void create() throws Exception {
        String title = prompt("Заголовок: ");
        String text = prompt("Текст: ");
        String date = new Date().toString();
        noteController.saveNote(new Note(title, text, date));
    }


    private void showHelp() {
        System.out.println("Список команд:");
        for (Commands c : Commands.values()) {
            System.out.println(c);
        }
    }

    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}