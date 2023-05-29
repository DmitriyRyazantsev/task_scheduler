import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    public void testSimpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(7, "сходить в магазин");
        boolean actual = simpleTask.matches("магазин");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(7, "сходить в магазин");
        boolean actual = simpleTask.matches("гулять");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicFalse() {
        Epic epic = new Epic(5, new String[]{"погулять с собакой"});

        boolean actual = epic.matches("выгулять");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicTrue() {
        Epic epic = new Epic(5, new String[]{"погулять с собакой"});

        boolean actual = epic.matches("гулять");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingTrue() {
        Meeting epic = new Meeting(6, "поговорить о погоде", "метеостанция", "5мая");

        boolean actual = epic.matches("станция");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingFalse() {
        Meeting epic = new Meeting(6, "поговорить о погоде", "метеостанция", "5мая");

        boolean actual = epic.matches("23:43");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }
}