package features;

import cucumber.api.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

class IsItFriday {
    static String isItFriday(String today) {
        return "Nope";
    }
}

public class Stepdefs implements En {

    private String today;
    private String actualAnswer;

    public Stepdefs() {
        Given("^today is Sunday$", () -> {
            this.today = "Sunday";
        });
        When("^I ask whether it's Friday yet$", () -> {
            this.actualAnswer = IsItFriday.isItFriday(today);
        });
        Then("^I should be told \"([^\"]*)\"$", (String expectedAnswer) -> {
            assertThat(this.actualAnswer).isEqualTo(expectedAnswer);
        });
    }
}
