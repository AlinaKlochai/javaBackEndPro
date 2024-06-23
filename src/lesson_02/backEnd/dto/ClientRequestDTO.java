package lesson_02.backEnd.dto;

public class ClientRequestDTO {
    private String name;
    private String description;

    public ClientRequestDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
