package lesson_02.backEnd.repository;

import lesson_02.backEnd.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository implements TaskRepositoryInterface {
    private Integer taskId = 0;
    private List<Task> taskList = new ArrayList<>();

    @Override
    public Task add(Task newTask) {
        newTask.setId(++taskId);
        taskList.add(newTask);
        return newTask;
    }

    @Override
    public List<Task> findAllTasks() {
        return taskList;
    }

    @Override
    public Optional<Task> findById(Integer id) {
        return taskList.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Task> findByTaskName(String taskName) {
        for (Task task : taskList){
            if (task.getTaskName().equals(taskName)){
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Task> updateTaskDescription(Task taskToUpdate) {
        return findById(taskToUpdate.getId()).map(task -> {
            task.setTaskDescription(taskToUpdate.getTaskDescription());
            return task;
        });
    }

    @Override
    public boolean deleteById(Integer id) {
        Optional<Task> foundedTaskById = findById(id);

        if(foundedTaskById.isPresent()){
            taskList.remove(foundedTaskById.get());
            return true;
        }else {
            return false;
        }
    }
}
