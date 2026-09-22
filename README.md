# Matthew Brown — Software Engineering Portfolio

A responsive, static portfolio highlighting verified Java, SQL/MariaDB, and web-development coursework, plus H-E-B retail experience. The included Java source files can be compiled and run using JDK 17+ (tested here with JDK 21). The portfolio website itself uses plain HTML, CSS, and JavaScript and can be hosted on GitHub Pages.

## View the website locally

Open `index.html` in a browser, or run `python -m http.server 8000` from the repository root and visit `http://localhost:8000`.

## Run the Java projects

Each project is in a separate folder to avoid Java class-name collisions. From the repository root:

```bash
cd projects/seafood
javac Main.java SeafoodItem.java
java Main
```

```bash
cd projects/password
javac Assessment04.java
java Assessment04
```

```bash
cd projects/stock
javac Stock.java StockDemo.java
java StockDemo
```

The seafood application prompts for three seafood items and validates prices and weights. The password checker prompts for a password and reports unmet criteria. The stock demo prints a formatted price-change summary.

## SQL case study

Read [`projects/database-project.html`](projects/database-project.html) for a representative JOIN-based reporting query and a description of my MariaDB/DBeaver coursework. It is a case study, not a deployable database service.

## Test

Run `bash tests/smoke_test.sh` to compile and smoke-test the Java projects, check the website JavaScript syntax, and validate local website links. Requires Java JDK, Node.js and Python 3.

## GitHub Pages

After creating a public repository and uploading the files to its root, go to **Settings → Pages → Build and deployment → Deploy from a branch**, select `main` and `/ (root)`, and save. Wait for GitHub to report the live site URL before adding it to a résumé.

## About

These are educational/personal projects. This site is not affiliated with or endorsed by H-E-B, Google, Roblox, Microsoft, or Amazon. Contact: matthew.brown.us@outlook.com.
