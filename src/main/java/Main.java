import dao.PersonDAO;
import dto.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        Person person = personDAO.getPersonFromId("1");

        if (person != null) {
            System.out.println(person.getAge());
            System.out.println(person.getId());
            System.out.println(person.getName());
        } else {
            System.out.println("テーブルが空です");
        }
    }

    private static String keyIn() {
        String line = null;
        try {
            BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
            line = key.readLine();
        } catch (IOException e) {

        }
        return line;
    }
}
