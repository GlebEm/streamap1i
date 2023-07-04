import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    /**
    *Найдите все заголовки задач с TaskType READING, и отсортируйте их по дате создания.
    *Решить необходимо в 1 stream.
    */

    public static void main(String[] args) {
        Task task1 = new Task(1, "Read Version Control with Git book", TaskType.READING, LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books");
        Task task2 = new Task(2, "Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books");
        Task task3 = new Task(3, "Write a mobile application to store my tasks", TaskType.CODING, LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile");
        Task task4 = new Task(4, "Write a blog on Java 8 Streams", TaskType.WRITING, LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams");
        Task task5 = new Task(5, "Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading");
        List<Task> tasks = Arrays.asList(task1, task2, task3, task4, task5);

        allReadingTasks(tasks).forEach(System.out::println);

    }

    private static List<String> allReadingTasks(List<Task> tasks) {
        List<String>readingTasks =  tasks.stream()
                .filter(task->task.getType()==TaskType.READING)
                .sorted((x,y)->
                        x.getCreatedOn().compareTo(y.getCreatedOn()))
                .map(task -> task.getTitle())   //                                                                                                  .map(Task::toString) было так не мог понять почему выводит не формат, не посмотрел в методы...
                .collect(Collectors.toList());
        return readingTasks;
    }
}