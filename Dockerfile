# Utilize a imagem base do Eclipse Temurin 17
FROM eclipse-temurin:17 as builder

# Defina o diretório de trabalho
WORKDIR /workspace/app

# Copie o arquivo .jar e o diretório 'target' para a imagem
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Compile a aplicação
RUN ./mvnw install -DskipTests

# Crie uma nova etapa para otimizar a imagem final
FROM eclipse-temurin:17

# Defina o diretório de trabalho
WORKDIR /app

# Copie a aplicação compilada para a imagem
COPY --from=builder /workspace/app/target/*.jar app.jar

# Defina a variável de ambiente para rodar a aplicação em modo de desenvolvimento
ENV SPRING_PROFILES_ACTIVE=dev

# Comando para executar a aplicação
CMD ["java", "-jar", "/app/app.jar"]
