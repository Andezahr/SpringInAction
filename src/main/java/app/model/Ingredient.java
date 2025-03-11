package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@RestResource(rel = "ingredients", path = "ingredients")
@NoArgsConstructor (access = AccessLevel.PRIVATE, force = true)
public class Ingredient implements Serializable {

    @Id
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
