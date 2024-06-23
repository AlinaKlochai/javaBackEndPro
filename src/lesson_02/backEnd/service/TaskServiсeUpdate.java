package lesson_02.backEnd.service;

import lesson_02.backEnd.dto.ClientRequestDTO;
import lesson_02.backEnd.dto.ClientResponseDTO;
import lesson_02.backEnd.dto.TaskDto;
import lesson_02.backEnd.entity.Task;
import lesson_02.backEnd.repository.TaskRepository;
import lesson_02.backEnd.service.validation.Validation;

import java.util.List;
import java.util.Optional;

public class TaskServiсeUpdate {
    private final TaskRepository repository;

    private final Validation validation;

    public TaskServiсeUpdate(TaskRepository repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }

//    public ClientResponseDTO<Task> editTaskDescription(Integer taskId, String newTaskDescription) {
//        // Получаем задачу из репозитория по ID
//        Optional<Task> taskForEditingOptional = repository.findById(taskId);
//
//        if (taskForEditingOptional.isPresent()) {
//            Task taskForEdit = taskForEditingOptional.get();
//            System.out.println("Received request to edit task description: Task{id=" + taskId +
//                    ", taskName='" + taskForEdit.getTaskName() +
//                    "', taskDescription='" + taskForEdit.getTaskDescription() + "'}");
//
//            // Проводим валидацию данных
//            List<String> errors = validation.validate(requestDto);
//
//            if (errors.isEmpty()) {
//                // Обновляем описание задачи в репозитории
//                taskForEdit.setTaskDescription(newTaskDescription);
//                repository.updateTaskDescription(taskForEdit);
//                return new ClientResponseDTO<>(200, taskForEdit, errors);
//            } else {
//                return new ClientResponseDTO<>(400, taskForEdit, errors);
//            }
//        } else {
//            // Если задача не найдена по указанному ID
//            List<String> errors = new ArrayList<>();
//            errors.add("Task with ID " + taskId + " not found");
//            return new ClientResponseDTO<>(404, null, errors);
//        }
//    }
public ClientResponseDTO<Task> editTaskDescription(Integer taskId, String newTaskDescription){
    ClientRequestDTO requestDTO = new ClientRequestDTO("SampleName", newTaskDescription);
    List<String> errors = validation.validate(requestDTO);

    if(!errors.isEmpty()){
        return new ClientResponseDTO<>(400,null, errors);
    }
    Optional<Task> optionalTask = repository.findById(taskId);
    if(optionalTask.isPresent()){
        Task updatedTask = optionalTask.get();
        return new ClientResponseDTO<>(200,updatedTask,errors);
    }else {
        errors.add("Task not found with ID: " + taskId);
        return new ClientResponseDTO<>(400, null, errors);
    }
}



}


