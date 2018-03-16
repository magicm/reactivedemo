
# MongoDB, SpringBoot2, ReactJS Reactive Sample

###Tech stack: 
* MondoDB
* Java 8 + SpringBoot2 (ReactiveMongo, WebFlux)
* ReactJS + redux, redux-observable/RxJs 

## How to run
### Backend

Start mongodb service:

```
docker-compose up mongodb
```

Then run the app:

```
mvn spring-boot:run
```

### Client
```
cd client
yarn
yarn start
```
Client app runs at http://localhost:3000

### What to do?
Search for a Player input: R, Ra, Larry, ... 


TODO