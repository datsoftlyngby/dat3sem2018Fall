REST APIs - Error Handling

1\) Error Handling with JAX RS - Person

**Prerequisites:** This exercise requires that you have completed the
exercise "REST with JAX RS – Person…."

Again we are going to complete the API-description given in the original
exercise, with a description of the responses for **Error Scenarios** as
sketched below:

In this exercise, we will include the stack trace into the error-JSON,
**but only** when we execute the program in debug-mode, hackers will
love to get this info ;-)

**Error responses for GET: /person/{id}**

{"code": 404, "message": "No person with provided id found",
"stackTrace": "…."}

**Error responses for POST**:

A person must have both a firstName and a lastName

{"code": 400, "message": "First Name or Last Name is missing",
"stackTrace": "…."}

**Error responses for PUT**:

A person must have both a firstName and a lastName

{"code": 400, "message": "First Name or Last Name is missing",
"stackTrace": "…."}

{"code": 404, "message": "Cannot edit. Person with provided id does not
exist", "stackTrace": "…."}

**Error responses for DELETE**:

{"code": 404, "message": "Could not delete. No person with provided id
exists", "stackTrace": "…."}

For all **RunTimeExceptions **

{"code": 500, "message": "Internal Server Problem. We are sorry for the
inconvenience", "stackTrace": "…."}

Request for **non-existing Services**

{"code": 404, "message": "The requested service does not exist",
"stackTrace": "…."}

**Tasks**

**Server:**

1)  Remember, exceptions/stacktraces should **only** be included while
    we are developing/debugging the system. Include (if not
    already done) a Standard Deployment Descriptor file (web.xml) into
    your project and add the following xml:

> &lt;context-param&gt;
>
> &lt;description&gt;If true, the stack trace is included with error
> responses&lt;/description&gt;
>
> &lt;param-name&gt;debug&lt;/param-name&gt;
>
> &lt;param-value&gt;true&lt;/param-value&gt;
>
> &lt;/context-param&gt;
>
> Stack traces should only be included when this context-parameter is
> true.
>
> To read the context-param in your serlvet or rest service java code,
> see how
> [*here*](https://www.mkyong.com/web-development/how-to-get-context-param-value-in-java/)
>
> ![](media/image2.png){width="6.774770341207349in"
> height="4.611111111111111in"}

1)  Design two Exception classes; PersonNotFoundException and
    ValidationErrorException and ExceptionMappers to map these
    exceptions into JSON-responses as described above.

2)  Implement an ExceptionMapper that will Map all Exceptions not having
    their own ExceptionMapper

3)  Implement an ExceptionMapper that will Map NotFound/IndexOutOfBound
    Exceptions to the relevant JSON-Response (This depends on how you
    store the resources, and what sort of exception os thrown when
    trying to access a non-existing one)

4)  Using postman/a webbrowser, verify the error-response for "all"[^1]
    possible error conditions.

[^1]: All of the above errors, caused by whatever scenarios you can
    think of.
