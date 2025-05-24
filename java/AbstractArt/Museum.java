import java.util.ArrayList;
import java.util.Collections;

public class Museum {
    public static void main(String[] args) {
        ArrayList<Art> museum = new ArrayList<Art>();

        // Create Paintings
        Painting p1 = new Painting("Sunset Bliss", "Claude Monet", "A calming view of the sea at sunset.", "Oil");
        Painting p2 = new Painting("Starry Night", "Vincent Van Gogh", "A night full of stars and swirls.", "Acrylic");
        Painting p3 = new Painting("The Scream", "Edvard Munch", "An expression of internal anxiety.", "Watercolor");

        // Create Sculptures
        Sculpture s1 = new Sculpture("The Thinker", "Auguste Rodin", "A man lost in thought.", "Bronze");
        Sculpture s2 = new Sculpture("David", "Michelangelo", "Heroic representation of David from the Bible.", "Marble");

        // Add to museum
        museum.add(p1);
        museum.add(p2);
        museum.add(p3);
        museum.add(s1);
        museum.add(s2);

        // Ninja Bonus
        Collections.shuffle(museum);

        // View artworks
        for (Art art : museum) {
            art.viewArt();
        }
    }
}
