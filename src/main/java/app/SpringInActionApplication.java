package app;

import app.data.IngredientRepository;
import app.data.TacoRepository;
import app.data.UserRepository;
import app.model.Ingredient;
import app.model.Ingredient.*;
import app.model.Taco;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class SpringInActionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringInActionApplication.class, args);
	}
	@Bean
	public CommandLineRunner dataLoader(IngredientRepository ingredientRepo, UserRepository userRepo, PasswordEncoder encoder, TacoRepository tacoRepo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Ingredient flourTortilla = new Ingredient(
						"FLTO", "Flour Tortilla", Type.WRAP);
				Ingredient cornTortilla = new Ingredient(
						"COTO", "Corn Tortilla", Type.WRAP);
				Ingredient groundBeef = new Ingredient(
						"GRBF", "Ground Beef", Type.PROTEIN);
				Ingredient carnitas = new Ingredient(
						"CARN", "Carnitas", Type.PROTEIN);
				Ingredient tomatoes = new Ingredient(
						"TMTO", "Diced Tomatoes", Type.VEGGIES);
				Ingredient lettuce = new Ingredient(
						"LETC", "Lettuce", Type.VEGGIES);
				Ingredient cheddar = new Ingredient(
						"CHED", "Cheddar", Type.CHEESE);
				Ingredient jack = new Ingredient(
						"JACK", "Monterrey Jack", Type.CHEESE);
				Ingredient salsa = new Ingredient(
						"SLSA", "Salsa", Type.SAUCE);
				Ingredient sourCream = new Ingredient(
						"SRCR", "Sour Cream", Type.SAUCE);
				Ingredient chicken = new Ingredient(
						"CHKN", "Chicken", Type.PROTEIN);
				ingredientRepo.save(chicken);
				ingredientRepo.save(flourTortilla);
				ingredientRepo.save(cornTortilla);
				ingredientRepo.save(groundBeef);
				ingredientRepo.save(carnitas);
				ingredientRepo.save(tomatoes);
				ingredientRepo.save(lettuce);
				ingredientRepo.save(cheddar);
				ingredientRepo.save(jack);
				ingredientRepo.save(salsa);
				ingredientRepo.save(sourCream);

				userRepo.save(new User("habuma", encoder.encode("password"),
						"Craig Walls", "123 North Street", "Cross Roads", "TX",
						"76227", "123-123-1234"));
				userRepo.save(new User("az", encoder.encode("1"), "1", "1","1","1","1","1"));

				Taco taco1 = new Taco();
				taco1.setName("Carnivore");
				taco1.setIngredients(Arrays.asList(
						flourTortilla, groundBeef, carnitas,
						sourCream, salsa, cheddar));
				tacoRepo.save(taco1);

				Taco taco2 = new Taco();
				taco2.setName("Bovine Bounty");
				taco2.setIngredients(Arrays.asList(
						cornTortilla, groundBeef, cheddar,
						jack, sourCream));
				tacoRepo.save(taco2);

				Taco taco3 = new Taco();
				taco3.setName("Veg-Out");
				taco3.setIngredients(Arrays.asList(
						flourTortilla, cornTortilla, tomatoes,
						lettuce, salsa));
				tacoRepo.save(taco3);
				userRepo.save(new User("az", encoder.encode("1"), "1", "1","1","1","1","1"));

			}
		};
	}
}
