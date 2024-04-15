import java.util.Scanner;

public class Puissance4 {
    private final int MAX_ROWS = 6;
    private final int MAX_COLUMNS = 7;
    private final char EMPTY_CASE = '-';
    private final Player player_one;
    private final Player player_two;
    private Player current_player;
    private char[][] board;
    private Scanner scanner;
    private int[][] winnerTokens;

    // Constructeur de la classe Puissance4
    public Puissance4() {
        // Initialisation des joueurs et du joueur actuel
        player_one = new Player('R', "JOUEUR 1", "RED");
        player_two = new Player('Y', "JOUEUR 2", "YELLOW");
        current_player = player_one;

        // Initialisation de la grille et du scanner
        board = new char[MAX_ROWS][MAX_COLUMNS];
        for(int i = 0; i < MAX_ROWS; i++) {
            for(int j = 0; j < MAX_COLUMNS; j++)
                board[i][j] = EMPTY_CASE; // Remplissage avec des cases vides
        }
        scanner = new Scanner(System.in);
    }

    // Méthode pour démarrer le jeu
    public void startGame() {
        System.out.println("Bienvenue dans le jeu Puissance 4 !");
        boolean bool = true;
        while(bool) {
            printBoard(); // Affiche le plateau
            String colorCode = (current_player.getColor().equals("RED") ? ConsoleColors.RED : ConsoleColors.YELLOW);
            System.out.print(current_player.getName() + " (" + colorCode + current_player.getColor() + ConsoleColors.RESET + ") , choisissez une colonne : ");

            int column;
            do {
                // Vérifie si l'entrée est un entier
                while(!scanner.hasNextInt()) {
                    System.out.print(current_player.getName() + " (" + colorCode + current_player.getColor() + ConsoleColors.RESET + ")" + " : Veuillez entrer un numéro de colonne valide : ");
                    scanner.next();
                }
                column = scanner.nextInt();
                // Vérifie la validité de la colonne choisie
                if(column < 1 || column > MAX_COLUMNS)
                    System.out.print(current_player.getName() + " (" + colorCode + current_player.getColor() + ConsoleColors.RESET + ")" + " : Veuillez entrer un numéro de colonne valide : ");
                else if(board[0][column - 1] != EMPTY_CASE)
                    System.out.print(current_player.getName() + " (" + colorCode + current_player.getColor() + ConsoleColors.RESET + ")" + " : La colonne est déjà pleine, veuillez entrer un numéro de colonne valide : ");
            } while(column < 1 || column > MAX_COLUMNS || board[0][column - 1] != EMPTY_CASE);

            placeToken(column); // Place le jeton dans la colonne choisie
            String result = resultOfPlacement(); // Récupère le résultat du placement
            System.out.println(result);
            if(result.equals("NOTHING"))
                current_player = (current_player == player_one ? player_two : player_one); // Change de joueur
            else if(result.equals("WINNER")) {
                printBoard();
                System.out.println(ConsoleColors.BLUE + current_player.getName() + " (" + colorCode + current_player.getColor() + ConsoleColors.BLUE + ") , a gagné ! Félicitations !");
                bool = false; // Termine le jeu
            }
            else {
                printBoard();
                System.out.println("La grille est pleine, Match nul !");
                bool = false; // Termine le jeu
            }
        }
    }

    // Méthode pour afficher le plateau de jeu
    public void printBoard() {
        boolean winner = winnerTokens != null;
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                char token = board[i][j];

                // Vérification si le point actuel est dans winnerTokens
                boolean isWinnerPoint = winner && (i == winnerTokens[0][0] && j == winnerTokens[0][1] ||
                                                   i == winnerTokens[1][0] && j == winnerTokens[1][1] ||
                                                   i == winnerTokens[2][0] && j == winnerTokens[2][1] ||
                                                   i == winnerTokens[3][0] && j == winnerTokens[3][1]);

                // Choix de la couleur en fonction du jeton et du statut de gagnant
                String colorCode = (isWinnerPoint ? ConsoleColors.GREEN : (token == '-' ? "" : (token == player_one.getToken() ? ConsoleColors.RED : ConsoleColors.YELLOW)));

                // Affichage du jeton avec la couleur
                System.out.print(colorCode + token + ConsoleColors.RESET + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < MAX_COLUMNS; i++)
            System.out.print(i + 1 + " ");
        System.out.println();
        System.out.println();
    }

    // Méthode pour placer un jeton dans la colonne spécifiée
    public void placeToken(int column) {
        for(int i = MAX_ROWS - 1; i >= 0; i--) {
            if(board[i][column - 1] == EMPTY_CASE) {
                board[i][column - 1] = current_player.getToken();
                break;
            }
        }
    }

    // Méthode pour déterminer le résultat du placement (gagnant, match nul, ou rien)
    public String resultOfPlacement() {
        if(isWinner())
            return "WINNER";
        else if(isFull())
            return "FULL";
        else
            return "NOTHING";
    }

    // Méthode pour vérifier si la grille est pleine
    public boolean isFull() {
        for(int i = 0; i < MAX_COLUMNS; i++) {
            if(board[0][i] == EMPTY_CASE)
                return false;
        }
        return true;
    }

    public void setWinnerTokens(int t1_i, int t1_j,int t2_i, int t2_j,int t3_i, int t3_j,int t4_i, int t4_j) {
        winnerTokens = new int[][] {
                {t1_i, t1_j},
                {t2_i, t2_j},
                {t3_i, t3_j},
                {t4_i, t4_j}
        };
    }

    // Méthode pour vérifier s'il y a un gagnant
    public boolean isWinner() {
        // Vérification horizontale
        for(int i = 0; i < MAX_ROWS; i++) {
            for(int j = 0; j < MAX_COLUMNS - 3; j++) {
                if(board[i][j] != EMPTY_CASE && board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] == board[i][j + 3]) {
                    setWinnerTokens(i , j , i , j + 1 , i , j + 2,i ,j + 3);
                    return true;
                }
            }
        }
        // Vérification verticale
        for(int i = 0; i < MAX_ROWS - 3; i++) {
            for(int j = 0; j < MAX_COLUMNS; j++) {
                if(board[i][j] != EMPTY_CASE && board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] && board[i][j] == board[i + 3][j]) {
                    setWinnerTokens(i, j, i + 1 , j, i + 2 , j , i + 3 , j);
                    return true;
                }
            }
        }
        // Vérification diagonale droite
        for(int i = 3; i < MAX_ROWS; i++) {
            for(int j = 0; j < MAX_COLUMNS - 3; j++) {
                if(board[i][j] != EMPTY_CASE && board[i][j] == board[i - 1][j + 1] && board[i][j] == board[i - 2][j + 2] && board[i][j] == board[i - 3][j + 3]) {
                    setWinnerTokens(i, j, i - 1 , j + 1 , i - 2 , j + 2 , i - 3 , j + 3);
                    return true;
                }
            }
        }
        // Vérification diagonale gauche
        for(int i = 3; i < MAX_ROWS; i++) {
            for(int j = 3; j < MAX_COLUMNS; j++) {
                if(board[i][j] != EMPTY_CASE && board[i][j] == board[i - 1][j - 1] && board[i][j] == board[i - 2][j - 2] && board[i][j] == board[i - 3][j - 3]) {
                    setWinnerTokens(i, j, i - 1 , j - 1 , i - 2 , j - 2 , i - 3 , j - 3);
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Puissance4 jeu = new Puissance4();
        jeu.startGame();
    }
}
