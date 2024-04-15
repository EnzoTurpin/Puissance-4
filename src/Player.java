public class Player {

    // Attributs privés pour le jeton, le nom et la couleur du joueur
    private final char token;
    private final String name;
    private final String color;

    // Constructeur de la classe Player
    public Player(char _token, String _name, String _color) {
        token = _token;
        name = _name;
        color = _color;
    }

    // Méthode pour récupérer le jeton du joueur
    public char getToken() {
        return token;
    }

    // Méthode pour récupérer le nom du joueur
    public String getName() {
        return name;
    }

    // Méthode pour récupérer la couleur du joueur
    public String getColor() {
        return color;
    }
}
