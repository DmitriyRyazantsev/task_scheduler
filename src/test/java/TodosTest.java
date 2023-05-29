import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Приложение НетоБанка",
                "Выкатка 3й версии приложения",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch1() {
        SimpleTask simpleTask = new SimpleTask(5, "Молоко");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Приложение НетоБанка",
                "Выкатка 3й версии приложения",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Молоко");
        Task[] expected = {simpleTask, epic};             //если поменять местами почему тест не срабатывает, важна последовательность в ожидании правельности ответа?

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSearch2() {
        SimpleTask simpleTask = new SimpleTask(5, "Молоко");

        String[] subtasks = {"Мясо", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Приложение НетоБанка",
                "Выкатка 3й версии приложения",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Молоко");
        Task[] expected = {simpleTask};

        Assertions.assertArrayEquals(actual, expected);
    }
    //не смог понять meeting start

}




