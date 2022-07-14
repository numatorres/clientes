FROM openjdk:8u332-jre-slim

ENV APP_HOME=/Apps/clientes

WORKDIR $APP_HOME

COPY clientes-0.0.1-SNAPSHOT.jar $APP_HOME/clientes.jar

RUN groupadd -r clientegrupo && useradd --no-log-init -r clienteuser -g clientegrupo

RUN chown -R clienteuser:clientegrupo /Apps/clientes

USER clienteuser

ENTRYPOINT ["java","-Duser.timezone=America/Lima","-jar","clientes.jar"]

EXPOSE 8080
