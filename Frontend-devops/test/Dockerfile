# Étape 1 : Construire l'application Angular
FROM node:18 AS build

# Définit le répertoire de travail
WORKDIR /app

# Copie le package.json et package-lock.json
COPY package*.json ./

# Installe les dépendances
RUN npm install --legacy-peer-deps

# Copie tout le code de l'application
COPY . .

# Construit l'application pour la production
RUN npm run build --prod

# Étape 2 : Utiliser NGINX pour servir l'application
FROM nginx:alpine

# Copie les fichiers de construction de l'étape précédente  dist\enicar
COPY --from=build /app/dist/enicar/browser /usr/share/nginx/html

# Expose le port 80 pour le serveur NGINX
EXPOSE 80
