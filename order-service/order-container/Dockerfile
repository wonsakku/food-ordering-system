# 1. 베이스 이미지 (JDK 포함된 경량 이미지 사용)
FROM eclipse-temurin:17-jdk-jammy as base

# 2. 작업 디렉터리 설정
WORKDIR /app

# 3. JAR 파일 복사
COPY target/*.jar app.jar

# 4. 실행 명령
ENTRYPOINT ["java","-jar","/app/app.jar"]