const questions = {
  html: [
    {
      q: "What is a self-closing (void) tag?",
      correct: true,
    },
    {
      q: "What is the `id` attribute?",
      correct: true,
    },
    {
      q: "What is a block-level element?",
      correct: true,
    },
    {
      q: "What is the DOM?",
      correct: true,
    },
    {
      q: "What is `.preventDefault()`?",
      correct: true,
    },
  ],
  css: [
    {
      q: "What is inline styling?",
      correct: true,
    },
    {
      q: "What does `.highlight` do?",
      correct: true,
    },
    {
      q: "What are ID selectors?",
      correct: true,
    },
    {
      q: "What is margin?",
      correct: true,
    },
    {
      q: "What is Flexbox?",
      correct: true,
    },
  ],
  js: [
    {
      q: "What is the `===` (strict equality) operator?",
      correct: false,
    },
    {
      q: "What is scoping or hoisting?",
      correct: true,
    },
    {
      q: "What are arrow functions?",
      correct: true,
    },
    {
      q: "What `async`?",
      correct: true,
    },
    {
      q: "What is the `capture` phase?",
      correct: true,
    },
  ],
  ts: [
    {
      q: "What is the TypeScript compiler (`tsc`)?",
      correct: true,
    },
    {
      q: "What is `unknown`?",
      correct: true,
    },
    {
      q: "What an interface?",
      correct: true,
    },
    {
      q: "What is the `strict` property in `.tsconfig`?",
      correct: true,
    },
    {
      q: "What is `tsc --init`?",
      correct: false,
    },
  ],
  angular: [
    {
      q: "What is `selector`?",
      correct: false,
    },
    {
      q: "What is a service?",
      correct: true,
    },
    {
      q: 'What is `[src]="imageURL"`?',
      correct: true,
    },
    {
      q: "What is the `async` pipe?",
      correct: false,
    },
    {
      q: "What is a `BehaviorSubject`?",
      correct: true,
    },
  ],
  http: [
    {
      q: "What is the `GET` HTTP method?",
      correct: true,
    },
    {
      q: "What is 4XX?",
      correct: true,
    },
    {
      q: "What are headers?",
      correct: true,
    },
    {
      q: "What is a `Promise`?",
      correct: true,
    },
    {
      q: "What is an `Observable`?",
      correct: true,
    },
  ],
};

const score = Object.entries(questions).reduce((acc, [_, results]) => {
  const total = results.reduce((acc, { correct }, i) => {
    return acc + (correct ? 1 : -1) * ((i + 1) * 200);
  }, 0);
  return acc + total;
}, 0);

console.log(score - 200);
