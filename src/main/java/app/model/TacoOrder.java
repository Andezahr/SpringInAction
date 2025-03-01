package app.model;

import app.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Digits;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Taco_Order")
public class TacoOrder implements Serializable {

    private static final Long serialVersionUID = 1L;
    @ManyToOne
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt = new Date();

    @NotBlank(message = "Must not be blank")
    private String name;

    @NotBlank(message = "Must not be blank")
    private String street;

    @NotBlank(message = "Must not be blank")
    private String city;

    @NotBlank(message = "Must not be blank")
    private String state;

    @NotBlank(message = "Must not be blank")
    private String zip;

    @CreditCardNumber(message = "CCNumber invalid")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([2-9]\\d)$", message="Invalid date")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
