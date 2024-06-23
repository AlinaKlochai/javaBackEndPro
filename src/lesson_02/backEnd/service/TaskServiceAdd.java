package lesson_02.backEnd.service;

import lesson_02.backEnd.dto.ClientRequestDTO;
import lesson_02.backEnd.dto.ClientResponseDTO;
import lesson_02.backEnd.entity.Task;
import lesson_02.backEnd.repository.TaskRepository;
import lesson_02.backEnd.service.validation.Validation;

import java.util.List;

public class TaskServiceAdd {

    private final TaskRepository repository;
    private final Validation validation;

    public TaskServiceAdd(TaskRepository repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    public ClientResponseDTO<Task> addNewTask(ClientRequestDTO requestDto){
        System.out.println("Received request: " + requestDto);

        // проводим валидацию данных

        List<String> errors =  validation.validate(requestDto);

        if (errors.isEmpty()) {
            Task taskForAdd = new Task(0, requestDto.getName(), requestDto.getDescription());
            Task savedTask = repository.add(taskForAdd);
            return new ClientResponseDTO<>(200,savedTask,errors);
        } else {
            return new ClientResponseDTO<>(400,new Task(),errors);
        }

    }
}

