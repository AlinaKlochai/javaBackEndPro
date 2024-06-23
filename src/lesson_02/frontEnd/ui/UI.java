package lesson_02.frontEnd.ui;

import lesson_02.backEnd.dto.ClientRequestDTO;
import lesson_02.backEnd.dto.ClientResponseDTO;
import lesson_02.backEnd.dto.TaskDto;
import lesson_02.backEnd.entity.Task;
import lesson_02.backEnd.service.TaskServiceAdd;
import lesson_02.backEnd.service.TaskServiceDelete;
import lesson_02.backEnd.service.TaskServiceRead;
import lesson_02.backEnd.service.TaskServiсeUpdate;

import java.util.Scanner;

public class UI {

    private TaskServiceAdd addService;
    private TaskServiceRead readService;

    private TaskServiceDelete deleteService;

    private TaskServiсeUpdate updateService;

    public UI(TaskServiceAdd addService, TaskServiceRead readService, TaskServiceDelete deleteService, TaskServiсeUpdate updateService) {
        this.addService = addService;
        this.readService = readService;
        this.deleteService = deleteService;
        this.updateService = updateService;
    }

    public void start(){

        while (true){
            System.out.println("Please enter your choice:");
            System.out.println("1. Add new task");
            System.out.println("2. Find task by id");
            System.out.println("3. Find task by name");
            System.out.println("4. Delete task by id");
            System.out.println("5. Edit task description");
            System.out.println("6. Exit");

            Scanner scanner = new Scanner(System.in);

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput){
                case 1:
                    System.out.println("Please enter task name:");
                    String taskName = scanner.nextLine();
                    System.out.println("Please enter task description:");
                    String taskDescription = scanner.nextLine();

                    ClientResponseDTO<Task> responseDto = addService.addNewTask(new ClientRequestDTO(taskName,taskDescription));

                    if (responseDto.getResponseCode() == 200) {
                        System.out.println("Добавление задачи прошло успешно");
                    } else {
                        System.out.println(responseDto.getErrors());
                    }
                    break;
                case 2:
                    System.out.println("Please enter task id: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine(); // consume newline character

                    ClientResponseDTO<Task> findResponseByID = readService.findTaskById(taskId);

                    if (findResponseByID.getResponseCode() == 200) {
                        Task foundTaskById = findResponseByID.getResponseInfo();
                        System.out.println("Task found: Name: " + foundTaskById.getTaskName() + ", Description: " + foundTaskById.getTaskDescription());
                    } else {
                        System.out.println("Task not found. Errors:");
                        System.out.println(findResponseByID.getErrors());
                    }
                    break;
                case 3:
                    System.out.println("Please enter task name: ");
                    String findByTaskName = scanner.nextLine();

                    ClientResponseDTO<Task> findResponseByName = readService.findTaskByName(findByTaskName);

                    if(findResponseByName.getResponseCode() == 200){
                        Task foundedTaskByName = findResponseByName.getResponseInfo();
                        System.out.println("Task found: Name: " + foundedTaskByName.getTaskName() + ", Description: " + foundedTaskByName.getTaskDescription());
                    }else {
                        System.out.println("Task not found. Errors:");
                        System.out.println(findResponseByName.getErrors());
                    }
                    break;
                case 4:
                    System.out.println("Please enter id task to delete:");
                    Integer idTaskToDelete = scanner.nextInt();
                    scanner.nextLine();

                    ClientResponseDTO<Boolean> isDeletedTask = deleteService.deleteTaskById(idTaskToDelete);

                    if(isDeletedTask.getResponseCode() == 200){
                        System.out.println("Task with ID " + idTaskToDelete + " successfully deleted" );
                    }else {
                        System.out.println("Failed to delete task with ID " + idTaskToDelete + ". Errors:");
                        System.out.println(isDeletedTask.getErrors());
                    }
                case 5:
                    System.out.println("Please enter task id to edit:");
                    int taskIdToUpdate = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Please enter new task description:");
                    String newTaskDescription = scanner.nextLine();

                    ClientResponseDTO<Task> updateResponse = updateService.editTaskDescription(taskIdToUpdate, newTaskDescription);

                    if (updateResponse.getResponseCode() == 200) {
                        Task updatedTask = updateResponse.getResponseInfo();
                        System.out.println("Task with ID " + taskIdToUpdate + " successfully updated. New description: " + updatedTask.getTaskDescription());
                    } else if (updateResponse.getResponseCode() == 400) {
                        System.out.println("Failed to update task with ID " + taskIdToUpdate + ". Validation errors:");
                        System.out.println(updateResponse.getErrors());
                    } else {
                        System.out.println("Failed to update task with ID " + taskIdToUpdate + ". Errors:");
                        System.out.println(updateResponse.getErrors());
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
            }

        }
    }

}
