# Kotlin, Spring, Vue.js
- Java/Spring, MyBatis, jsp를 사용하는 팀/프로젝트가 Kotlin/Spring, JPA, Vue.js 를 검토할 수 있도록 소개하는 것을 목적으로한다.
  ## 목차
  - [Basic](https://github.com/saro-example/kotlin-vue--basic)
  - [Spring](https://github.com/saro-example/kotlin-vue--spring)
  - [Vue.js](https://github.com/saro-example/kotlin-vue--vue)

# Spring
- 우선 [Basic](https://github.com/saro-example/kotlin-vue--basic) 과정을 완료 한 후 시작 권장

### 개발환경
* IDE : IntelliJ IDEA (Ultimate, Community)
  * https://www.jetbrains.com/idea/download/#section=windows
    * 커뮤니티 버전 무료 이용가능
  * 인텔리제이에서 Project From Version Control 을 통해 git을 받습니다.
* charset
  * 글자가 깨질경우 -Dfile.encoding=UTF-8 옵션을 추가합니다.
  * IntelliJ 기준 Help -> Edit Custom VM Options
* java 설정 : kotlin jdk 11
  * 컴파일이 되지않는경우
    * File -> Project Structure -> Project 에서 jdk 11


### 실행
각 IDE에서 실행하거나 직접 gradle wrapper를 이용하여 실행


#### 실행/빌드 명령어
```
gradlew bootRun
```

#### 로컬 실행
- 데이터를 초기화하려면 root 폴더 내 다음 파일을 삭제한다.
  - db-local.lock.db
  - db-local.mv.db


#### 로컬 DB 접근 정보
- H2를 탑재하여 별도의 DB세팅 없이 사용 가능합니다.
- 별도의 SQL 클라이언트 사용시 아래의 연결정보를 입력합니다.\
  (최초 bootRun 실행, db-local.mv.db 파일 생성 후 접속 가능)

  |jdbc url|jdbc:h2:<root 경로>/db-local;AUTO_SERVER=TRUE|
  |---|---|
  |user|sa|
  |password|jpa|

  jdbc url example

  |OS|jdbc url example|
  |---|---|
  |windows|jdbc:h2:file:C:/Users/username/IdeaProjects/kotlin-vue--spring/db-local;AUTO_SERVER=TRUE|
  |mac|jdbc:h2:/Users/username/kotlin-vie--spring/db-local;AUTO_SERVER=TRUE|

#### 테스트
* [list.http](https://github.com/saro-example/kotlin-vue--spring/blob/main/src/test/kotlin/jpa/board/list.http)
* [create.http](https://github.com/saro-example/kotlin-vue--spring/blob/main/src/test/kotlin/jpa/board/create.http)