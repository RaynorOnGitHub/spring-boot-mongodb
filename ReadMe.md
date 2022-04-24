# spring-boot-mongodb
This repository contains a Spring Boot example project for MongoDB.

For a code review of this repo, see my related [blog post](https://springframework.guru/3402-2/).

You can learn more about my (John Thompson - Springframework Guru) courses [here](http://courses.springframework.guru/courses/) on my site.



## Docker MongoDB Container

1. Run/prepare docker image and container

```docker run -p 27017:27017 --name spring-mongo -d mongo:5.0.7```

2. Start MongoDB console in interactive mode (if you need it)

``docker exec -it spring-mongo mongosh``

## Spring-Boot-Application
- Start application with maven target sequence ``clean`` then ``package`` or ``install`` and ``spring-boot:start`` or ``spring-boot:run``

- Open web-app inside a browser on localhost and port ``8080``

- Stop application when needed with maven target ``spring-boot:stop``