package lesson_02.backEnd.dto;

public class TaskDto {

    private Integer taskDtoId;
    private String taskNameDto;
    private String taskDescriptionDto;

    public TaskDto(Integer taskDtoId, String taskNameDto, String taskDescriptionDto) {
        this.taskDtoId = taskDtoId;
        this.taskNameDto = taskNameDto;
        this.taskDescriptionDto = taskDescriptionDto;
    }

    public TaskDto(Integer taskDtoId) {
        this.taskDtoId = taskDtoId;
    }

    public TaskDto(String taskNameDto, String taskDescriptionDto) {
        this.taskNameDto = taskNameDto;
        this.taskDescriptionDto = taskDescriptionDto;
    }

    public Integer getTaskDtoId() {
        return taskDtoId;
    }

    public void setTaskDtoId(Integer taskDtoId) {
        this.taskDtoId = taskDtoId;
    }

    public String getTaskNameDto() {
        return taskNameDto;
    }

    public void setTaskNameDto(String taskNameDto) {
        this.taskNameDto = taskNameDto;
    }

    public String getTaskDescriptionDto() {
        return taskDescriptionDto;
    }

    public void setTaskDescriptionDto(String taskDescriptionDto) {
        this.taskDescriptionDto = taskDescriptionDto;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "taskDtoId=" + taskDtoId +
                ", taskNameDto='" + taskNameDto + '\'' +
                ", taskDescriptionDto='" + taskDescriptionDto + '\'' +
                '}';
    }
}
