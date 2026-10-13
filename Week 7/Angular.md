# Angular

## MPA vs SPA

- **A SPA is** a web application that loads one main HTML page and dynamically updates its content as the user interacts with it, without fully reloading the page.
  - The browser initially loads the application.
  - JavaScript retrieves and displays new data as needed.
  - Navigation usually happens without a complete page refresh.
  - Frameworks such as React, Angular, and Vue are commonly used.
- **A MPA is** a web application consisting of multiple HTML pages.
  - When the user navigates to a different section, the browser generally requests a new page from the server and reloads the document.

## Angular Commands

- `ng generate component nested/componentName`.
- `ng g c nested/componentName`.
- `ng generate interface Student`.

## Components

- A **component** is a reusable piece of the UI that has its own logic and appearance, consisting of:
  - CSS styles: defines how the component looks.
  - HTML template: defines what appears on the screen.
  - TypeScript class: contains the component's data and behavior.
- **Component composition**: the term to describe how components are nested and structured to compose our application

## Component Communication

- **Interpolation**: the process of reading data from component logic (i.e. the `.ts` file).
  - `{{ student() }}`.
- Signals must be invoked while regular properties can be referenced directly.
- `input()`: allows us to take in data from a parent component.
- `output()`: allows us to emit data to a parent component.
- `@Input` & `@Output`: older syntax, but it won't benefit however from Angular's signal API and reactivity.

## Binding

- **Property binding**: passing the value of student down to the input expected in the child component .
  - `[student]="student"`.
- **Event binding**: listening for the `selected` event emitted in the child component.
  - `(selected)=“onStudentSelected”`.

## Control Flow

- `@if`, `@else if`.
- `@switch`, `@case`, `@default`.
- `@for`, `@empty`: control flow block for iteration.
  - Important to use `track` on unique elements so Angular can make changes to single items and doesn't need to rebuild/regenerate the entire list when the collection changes.

## Services

- **Services provide** a way for you to separate Angular app data and functions that can be used by multiple components in your app.
- A service must be made injectable to be used by multiple components.
- `npm run ng generate service studentService`.

## Routing

- The process to provide easy navigation between different views based on the browser URL.
  - This enables deep linking.
  - Handle URL parameters and query strings.
  - Manage browser history & navigation.
  - Create nested routes and layouts.
  - Implement protected routes for authentication.
- **Deep linking**: the practice of using hyperlinks to send users directly to specific content within our applications.
  - 1-2 levels deep: most apps.
    - `/dashboard`.
    - `/products/45`.
  - 3-4 levels deeps: common for structured apps.
    - `/dashboard/reports/weekly`.
    - `/shop/products/46/reviews`.
  - 5+ levels deep: usually in enterprise.
    - `/orgs/12/projects/55/tasks/34/comments/2`.
- The build tool will typically autogenerate `app.config.ts` & `app.routes.ts` which pre-configures routing.
  - We just need to add routes to `app.routes.ts`.

### Eager Loading

```ts
export const routes: Routes = [
  {
    path: "",
    component: Home,
  },
];
```

### Lazy Loading

- Ensures the client doesn't need to download the JavaScript until they visit that page.
- This is great for optimization of large sites & rarely used views

```ts
export const routes: Routes = [
  {
    path: "about",
    loadComponent: () => import("./about/about").then((m) => m.About),
  },
];
```

## Implementing Routing

- Make sure to import `RouterLink`.
- Use `routerLink` to set our activated route.
- The activated route will render the `<router-outlet>`.
