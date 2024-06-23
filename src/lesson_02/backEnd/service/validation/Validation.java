package lesson_02.backEnd.service.validation;

import lesson_02.backEnd.dto.ClientRequestDTO;
import java.util.ArrayList;
import java.util.List;

public class Validation {

    public List<String> validate(ClientRequestDTO requestDto){
        List<String> errors = new ArrayList<>();

        if (requestDto.getName() == null) {errors.add("Имя задачи не может быть null");}
        if (requestDto.getDescription() == null) {errors.add("Описание не может быть null");}
        if (requestDto.getName().length() < 3) {errors.add("Длина имени задачи не может быть меньше 3 символов");}
        if (requestDto.getName().length() > 15) {errors.add("Длина имени задачи не может быть больше 15 символов");}
        if (requestDto.getDescription().length() < 3) {errors.add("Длина описания задачи не может быть меньше 3 символов");}
        if (requestDto.getDescription().length() > 25) {errors.add("Длина описания задачи не может быть больше 25 символов");}

        return errors;
    }
}
