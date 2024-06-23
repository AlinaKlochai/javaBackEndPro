package lesson_02.backEnd.service;

import lesson_02.backEnd.dto.ClientRequestDTO;
import lesson_02.backEnd.dto.ClientResponseDTO;
import lesson_02.backEnd.entity.Task;
import lesson_02.backEnd.repository.TaskRepository;
import lesson_02.backEnd.service.validation.Validation;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TaskServiceDelete {

    private final TaskRepository repository;

    private final Validation validation;

    public TaskServiceDelete(TaskRepository repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    public ClientResponseDTO<Boolean> deleteTaskById(Integer taskId){
        System.out.println("Received request to delete task by Id: " + taskId );

        // Создаем ClientRequestDTO для валидации (в данном случае, задачи с таким именем и описанием не существует)
        ClientRequestDTO requestDTO = new ClientRequestDTO("SampleName", "SampleDescription");

        List<String> errors = validation.validate(requestDTO);

        if (!errors.isEmpty()) {
            return new ClientResponseDTO<>(400, null, errors);
        }

        boolean isDeletedTask = repository.deleteById(taskId);

        if (isDeletedTask == true) {
            return new ClientResponseDTO<>(200, isDeletedTask, Collections.emptyList());
        } else {
            errors.add("Task with ID " + taskId + " not found");
            return new ClientResponseDTO<>(404, null, errors);
        }
    }
}
