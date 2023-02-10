package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import model.Todo;
import org.springframework.stereotype.Service;


@Service
public class TodoService {
    private static List<model.Todo> todos = new ArrayList<model.Todo>();
    private static int todoCount = 0;


    public List<model.Todo> retrieveTodos(String user) {
        List<model.Todo> filteredTodos = new ArrayList<model.Todo>();
        for (model.Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addTodo(String name, String desc, Date targetDate,
                        boolean isDone) {
        todos.add(new model.Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<model.Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}