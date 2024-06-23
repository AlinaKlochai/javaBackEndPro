package lesson_02.backEnd.repository;

import lesson_02.backEnd.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryInterface {

    public Task add(Task newTask);
    public List<Task> findAllTasks();
    public Optional<Task> findById(Integer id);
    public Optional<Task> findByTaskName(String taskName);

    public Optional<Task> updateTaskDescription(Task taskToUpdate);

    public boolean deleteById(Integer id);


}
