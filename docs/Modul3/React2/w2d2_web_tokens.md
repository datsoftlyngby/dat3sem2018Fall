# Security with JWT tokens and Hashing/Salting passwords
### Using server side sessions to store the application state:  
![](img/session_cookie.png)

### Using JSON Web Tokens to store the application state:  

![](img/json_web_token.png)  
Check out JSON Web Token (JWT) [here](https://jwt.io/#debugger-io?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c). Look for the 3 parts:  
1. Header
2. Payload
3. Signature

In our application we will create the JWT on the server and send it to the client. On the client we will store it in the browsers local storage. There are good. This solution has some security [issues](https://auth0.com/docs/security/store-tokens). Read about them to understand some alternatives. We do it for reasons of simplisity in our exercise.
- Read more about JWT [here](https://jwt.io/introduction/).
- Read this stack overflow answer about implementing JWT on backend [here](https://stackoverflow.com/questions/26777083/best-practice-for-rest-token-based-authentication-with-jax-rs-and-jersey).

## Hashing and salting passwords
- Watch this 7 minutes [video](https://www.youtube.com/watch?v=O6cmuiTBZVs) about hashing and salting.

#### Hashing a password
![](img/hashing.png)  

#### Salting after hashing
![](img/salting.png)

#### verify hashed passwords
![](img/compare_passwords.png)

[**Do this tutorial / exercise here.**](../../exercises/daily/REACT_W2D2_Security.md)
