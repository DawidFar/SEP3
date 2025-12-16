# SEP3 Project - Submission Package

## Structure
- `src/csharp-server` - Minimal ASP.NET Core server (Program.cs, Dockerfile, .dockerignore).
- `src/java-server` - Your original SEP3 project files (copied from your uploaded SEP3.zip).
- `docker-compose.yml` - Compose to run C# server and optional Postgres for testing.
- `docs/` - (empty) place to add architecture diagrams, deployment notes, and evidence (Wireshark captures).

## How to run (basic)
1. Build & run C# server in Docker:
   ```bash
   docker-compose up --build csharp-server
   ```
   or, to run both services (C# + Postgres):
   ```bash
   docker-compose up --build
   ```

2. Verify endpoints:
   ```bash
   curl http://localhost:5000/health
   curl http://localhost:5000/api/items
   ```

3. To run your Java server, navigate to `src/java-server` and follow your project's usual build/run steps (Maven/Gradle/java commands).

## What to include before final submission
- Ensure `src/java-server` contains your Java server code and build files.
- Add DB migrations / schema to `src/db` if applicable.
- Add `docs/architecture.png` and `docs/wireshark.png` as evidence of distributed deployment.

## Notes
This package organizes files for review and ease of deployment. If you want, I can also:
- detect and move Java source files into a Maven/Gradle layout,
- add a sample JDBC snippet in `src/java-server/snippets/`,
- add EF Core + Postgres example integrated into C# server.
