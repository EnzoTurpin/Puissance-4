# Puissance 4 en Java

Ce projet est une implémentation en console du jeu classique Puissance 4, réalisée en Java. Il permet à deux joueurs de jouer l'un contre l'autre en mode console, en insérant alternativement des jetons dans une grille de 7 colonnes par 6 rangées, avec pour objectif d'aligner quatre de leurs jetons horizontalement, verticalement, ou diagonalement.

## Prérequis

Pour compiler et exécuter ce jeu, vous devez avoir installé :

- Java Development Kit (JDK) 8 ou une version ultérieure.

## Installation

1. **Téléchargez le projet** : Clonez le dépôt GitHub ou téléchargez l'ensemble des fichiers du projet dans un dossier local sur votre machine.
2. **Compilation** : Ouvrez un terminal ou une invite de commandes dans le dossier contenant le dossier (`puissance-4-cli`). Compilez le projet en utilisant la commande suivante :

```bash
make build
```

Cela compilera `Main.java` ainsi que les autres fichiers du projet grâce aux liens entre les classes.

## Utilisation

Après la compilation, exécutez le jeu en utilisant la commande Java pour exécuter le fichier `Main.class` généré :

```bash
make run
```

Le jeu démarrera dans le terminal ou dans l'invite de commandes. Suivez les instructions à l'écran pour jouer. Les joueurs seront invités à tour de rôle à choisir une colonne dans laquelle ils souhaitent placer leur jeton.

## Fonctionnalités

- **Jeu multijoueur local** : Puissance 4 pour deux joueurs jouant sur le même ordinateur.
- **Affichage en couleur** : Utilise des couleurs pour différencier les jetons des deux joueurs, améliorant ainsi l'expérience utilisateur.
- **Détection automatique de la victoire** : Le jeu vérifie après chaque coup si un joueur a gagné et annonce le résultat.
- **Gestion des erreurs** : Le jeu gère les entrées invalides sans se planter.

## Comment contribuer

Les contributions à ce projet sont les bienvenues. Voici comment vous pouvez contribuer :

1. **Fork le projet** : Créez une copie du projet sur votre propre compte GitHub.
2. **Créez une branche** : Créez une branche pour vos modifications.
3. **Faites vos modifications** : Ajoutez vos améliorations ou corrections.
4. **Envoyez une pull request** : Proposez vos modifications au projet principal pour examen.

## Support

Si vous rencontrez des problèmes ou si vous avez des questions sur le jeu, n'hésitez pas à ouvrir un issue dans le dépôt GitHub du projet.

## Auteurs

- [Enzo TURPIN],
- [Daryl MATRO],
- [Prince ELLA]

## Remerciements

Nous tenons à remercier tous ceux qui ont contribué à ce projet, ainsi que la communauté Java pour son soutien et ses ressources.
