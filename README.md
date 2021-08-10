**1. /user/signup
**```POST: 
  request:
    { userId:string, password:string, name:string }

  response:
    { id:long, userId:string, password:string, name:string, authority:enum, createdDate:date, modifiedDate:date }

  response_format: 
    application/json

  description:
    If existing user information wasn't found, inserts user and returns the user info,
    else returns nothing.
```
**2. /user/login
**```POST:
  request:
    { userId:string, password:string }

  response:
    { userId:string, name:string }

  response_type:
    application/json

  description:
    checks the user is valid or not
    If valid user, make a session and returns userId and name
    else returns nothing.
```
**3. /user/update
**```POST:
  request: 
    { userId:string, password:string, name:string }

  response:
    { userId:string, Name:string }

  response_type:
    application/json

  description:
    If valid user, updates user information and returns userId and Name
    else returns nothing.
```
