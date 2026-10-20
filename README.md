# NBCC Course Registration Servlet Assignment Requirements

### Make sure you fix your development artifact after cloning or the application will not run.

## 1. Functional & Behavioral Requirements

Run the provided database.sql script to create the database and tables. You can run it multiple times to reset your database if you like.

Example Screenshots are included at the end of the instructions:


### 1.1 Course and Registration Overview
- **Landing and Overview Dashboard**:
  - Accessing the root URL (`/`) or `/courses` displays the overview dashboard.
  - The dashboard presents two primary sections:
    1. **Available Courses**: Lists all courses available for enrollment, displaying the course name and credit hours for each.
    2. **Registrations**: Lists all confirmed course registrations, displaying the course name, student's first name, and student's last name for each entry.
  - The dashboard provides a visible navigation link ("New Registration") pointing to the registration form (`./registration`).

### 1.2 Course Registration Flow
- **Displaying the Registration Form**:
  - Accessing `/registration` via a GET request displays the course registration form.
  - The form includes:
    - A dropdown selection containing all currently available courses.
    - A text field for the student's first name.
    - A text field for the student's last name.
    - A submit button labeled "Register".
- **Submitting a Registration**:
  - Submitting the form issues a POST request containing the selected course identifier, first name, and last name.
  - The application persists the new registration entry.
  - Upon successful persistence, the application redirects the user back to the courses overview page (`courses`), adhering to the Post-Redirect-Get pattern to avoid duplicate submissions on page refresh.
  - The newly registered student and their selected course are immediately reflected in the registrations list on the overview page.

---

## 2. Completion Requirements for Tasks Marked with TODO

### 2.1 Entity Mapping (`CourseRegistration.java`)
- **JPA Entity Configuration**:
  - Annotate the CourseRegistration class as a JPA entity matching the configured persistence unit.
  - Define `id` as the primary key with identity generation strategy.
  - Map `courseId`, `firstName`, and `lastName` to persist properly into the database table.

### 2.2 Data Access Layer (`CourseRegistrationJPARepository.java`)
- **`getAll()` Implementation**:
  - Execute a JPQL query to retrieve all persisted `CourseRegistration` instances.
  - Return the results as a list, ensuring the `EntityManager` is properly closed.
- **`get(Long id)` Implementation**:
  - Locate and return a single `CourseRegistration` by its primary key. Return `null` if the record does not exist.
  - Ensure the `EntityManager` is properly closed.
- **`insert(CourseRegistration courseRegistration)` Implementation**:
  - Manage transaction: begin a transaction, persist the given `CourseRegistration` instance, commit the transaction.
  - Ensure the `EntityManager` is closed in all scenarios.

### 2.3 Registration Servlet (`CourseRegistrationServlet.java`)
- **`doGet(...)` Implementation**:
  - Retrieve the collection of all available courses from the course repository.
  - Set the courses collection into the request attributes under the key `"courses"`.
  - Forward the request to `/registration.jsp`.
- **`doPost(...)` Implementation**:
  - Convert the request into a `CourseRegistration` object using the  `convertToRegistration(...)` method.
  - Persist the registration using the registration repository's `insert(...)` method.
  - Redirect the response to the courses view (`courses`).
- **`convertToRegistration(...)` Method implementation**:
  - Extract the form parameters (`courseId`, `firstName`, and `lastName`) from the incoming request.
  - Parse `courseId` into a numeric representation.
  - Construct and return a populated `CourseRegistration` instance with the extracted values.
### 2.4 Courses Overview View Presentation (`courses.jsp`)
- **Available Courses Table Body**:
  - Render each course in the request-scoped `courses` list within a `<tr>` row inside `<tbody>`.
  - Display the course name and credit hours in corresponding `<td>` columns.
  - Make sure you use the proper JSTL "for each" tag and do not hard code the values in the jsp.
- **Registrations Table Body**:
  - Render each registration in the request-scoped `registrations` list within a `<tr>` row inside `<tbody>`.
  - Display the associated course name, student first name, and student last name in corresponding `<td>` columns.

### 2.5 Registration View Presentation (`registration.jsp`)
- **Course Selection Options**:
  - Iterate through the request-scoped collection of courses (`courses`) using JSTL "For Each".
  - Render an `<option>` element for each available course inside the `<select name="courseId">` dropdown.
  - Set each `<option>`'s `value` attribute to the respective course's `id`.
  - Display the course's `name` as the visible text for the option.

## Make sure to implement any area of code that is commented with a "Todo"

### Screenshots:
![No Courses.png](screenshots/No%20Courses.png)
![With Courses.png](screenshots/With%20Courses.png)
![New Registration.png](screenshots/New%20Registration.png)
![Registration Drop Down.png](screenshots/Registration%20Drop%20Down.png)
![New Registration with Data.png](screenshots/New%20Registration%20with%20Data.png)
