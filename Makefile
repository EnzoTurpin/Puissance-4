#. Nom de la classe principale
BINARY_NAME=Main

#. Liste explicite des fichiers source
SOURCES := src/Main.java \
           src/Player.java \
           src/Puissance4.java \
           src/ConsoleColors.java

#. Commande de build
build:
	@echo "Construction du projet..."
	mkdir -p build
	javac $(SOURCES) -d build

#. Commande pour nettoyer le projet (supprimer les fichiers .class)
clean:
	@echo "Nettoyage..."
	rm -rf build

#. Commande pour exécuter le programme
run: build
	@echo "Exécution du programme..."
	java -cp build $(BINARY_NAME)

#. Option 'phony' pour indiquer que 'clean', 'run', et 'build' ne sont pas des fichiers
.PHONY: build clean run
