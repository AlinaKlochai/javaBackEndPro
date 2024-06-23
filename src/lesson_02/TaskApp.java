package lesson_02;

import lesson_02.backEnd.repository.TaskRepository;
import lesson_02.backEnd.service.TaskServiceAdd;
import lesson_02.backEnd.service.TaskServiceDelete;
import lesson_02.backEnd.service.TaskServiceRead;
import lesson_02.backEnd.service.TaskServiсeUpdate;
import lesson_02.backEnd.service.validation.Validation;
import lesson_02.frontEnd.ui.UI;

public class TaskApp {
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository();
        Validation validation = new Validation();
        TaskServiceAdd addService = new TaskServiceAdd(repository,validation);
        TaskServiceRead readService = new TaskServiceRead(repository,validation);
        TaskServiсeUpdate updateService = new TaskServiсeUpdate(repository,validation);
        TaskServiceDelete deleteService = new TaskServiceDelete(repository,validation);

        UI ui = new UI(addService,readService,deleteService,updateService);
        ui.start();
    }
}
