package lesson_02.backEnd.service;

import lesson_02.backEnd.dto.ClientRequestDTO;
import lesson_02.backEnd.dto.ClientResponseDTO;
import lesson_02.backEnd.dto.TaskDto;
import lesson_02.backEnd.entity.Task;
import lesson_02.backEnd.repository.TaskRepository;
import lesson_02.backEnd.service.validation.Validation;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TaskServiceRead {

    private final TaskRepository repository;

    private final Validation validation;

    public TaskServiceRead(TaskRepository repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    public ClientResponseDTO<List<Task>> findAllTasks(ClientRequestDTO requestDTO){
        System.out.println("Received request: " + requestDTO );

        List<String> errors = validation.validate(requestDTO);

        if (errors.isEmpty()) {
            List<Task> tasks = repository.findAllTasks();

            return new ClientResponseDTO<>(200, tasks, errors);
        }else {
            return new ClientResponseDTO<>(400,null,errors);
        }
    }

    public ClientResponseDTO<Task> findTaskById(Integer taskId){
        System.out.println("Received request to find task by Id: " + taskId );

        // Создаем ClientRequestDTO для валидации (в данном случае, задачи с таким именем и описанием не существует)
        ClientRequestDTO requestDTO = new ClientRequestDTO("SampleName", "SampleDescription");

        List<String> errors = validation.validate(requestDTO);

        if (!errors.isEmpty()) {
            return new ClientResponseDTO<>(400, null, errors);
        }

        Optional<Task> taskOptional = repository.findById(taskId);

        if (taskOptional.isPresent()) {
            return new ClientResponseDTO<>(200, taskOptional.get(), Collections.emptyList());
        } else {
            errors.add("Task with ID " + taskId + " not found");
            return new ClientResponseDTO<>(404, null, errors);
        }
    }

    public ClientResponseDTO<Task> findTaskByName(String taskName){
        System.out.println("Received request to find task by name: " + taskName );

        ClientRequestDTO requestDTO = new ClientRequestDTO(taskName, "SampleDescription");

        List<String> errors = validation.validate(requestDTO);

        if(!errors.isEmpty()){
            return new ClientResponseDTO<>(400, null, errors);
        }
        Optional<Task> taskOptional = repository.findByTaskName(taskName);

        if (taskOptional.isPresent()){
            return new ClientResponseDTO<>(200, taskOptional.get(), errors);
        }else {
            errors.add("Task with name " + taskName + " not found");
            return new ClientResponseDTO<>(404,null, errors);
        }
    }

}
