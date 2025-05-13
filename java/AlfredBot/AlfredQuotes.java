import java.util.Date;

public class AlfredQuotes {

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        return String.format("Hello, %s. Lovely to see you.", name);
    }

    public String dateAnnouncement() {
        Date date = new Date();
        return "Current date is: " + date;
    }

    public String respondBeforeAlexis(String conversation) {

        // Check if the conversation contains "Alexis"
        if (conversation.indexOf("Alexis") > -1) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";

            // Check if the conversation contains "Alfred"
        } else if (conversation.indexOf("Alfred") > -1) {
            return "At your service. As you wish, milord.";
        } else {
            return "Right. And with that, I shall retire.";
        }
    }

    // NINJA BONUS
    // See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have
    // learned!
}
