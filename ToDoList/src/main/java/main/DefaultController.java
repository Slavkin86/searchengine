package main;

import model.ToDoRepository;
import model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class DefaultController {
    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Todo> todoIterable = ToDoRepository.findAll();
        ArrayList<Todo> todos = new ArrayList<>();
        for (Todo todo : todoIterable) {
            todos.add(todo);
        }
        model.addAttribute("todos", todos);
        model.addAttribute("todosCount", todos.size());
        return "index";
    }
}
