# Validation And Flash Message Demo

- `ExampleForm` class represents the inputs from a form (it's common to have the object be a entity/model, but we can also define a class that just represents one form's inputs).

- In `index.html`, the `th:object` is `exampleForm` and there's a bunch of error-handling code in the `form-group` for the name input.

- Note that the `@GetMapping` and `@PostMapping` methods don't ever explicitly pass the example form or errors to the view, but because they are present as method parameters and follow naming conventions, they are "magically" found by thymeleaf.

- `RedirectAttributes.addFlashAttribute` lets us add a message to the session for one request. Typical use case is when we want to show a success message after an operation was successfully performed (e.g. creating a new resource). In the html, we show a success alert with the contents of this message if it exists.

