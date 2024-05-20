# 使用 OpenJDK 作为基础镜像
FROM openjdk:8-jdk

# 设置工作目录
WORKDIR /app

# 暴露应用程序端口
EXPOSE 8080

#同一目录下，重命名即可
ADD coin-info-1.0-SNAPSHOT.jar app.jar

# 执行命令
RUN bash -c 'touch/app.jar'

# 运行 Spring Boot 应用
ENTRYPOINT ["java", "-jar", "app.jar"]
