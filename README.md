# Smart-City-Traveller

Java + JavaFX application that connects to an Oracle database to provide a simple city exploration UI for transport, shopping, and accommodation locations.

## What you get
- A minimal JavaFX GUI (`UI.java`) with a searchable table of locations.
- A `DatabaseManager` that demonstrates JDBC connections to Oracle and basic queries.
- A SQL script (`sql/create_locations_table.sql`) to create and populate the `locations` table.

## Prerequisites
- Java 11+ (or Java 17 recommended)
- JavaFX SDK compatible with your Java version
- Oracle Database (or Oracle XE) with a pluggable database (PDB) or service name
- Oracle JDBC driver `ojdbc8.jar` / `ojdbc11.jar` on your classpath
- Build tool (Maven/Gradle) **optional** — examples below use `javac` and `java`

## Quick setup (manual compile & run)
1. Create the database and table using `sql/create_locations_table.sql`.
2. Edit `src/com/smartcity/DatabaseManager.java` and update `JDBC_URL`, `DB_USER`, and `DB_PASSWORD` to match your Oracle instance.
3. Put the Oracle JDBC driver on the classpath and JavaFX modules (or use your IDE to configure JavaFX).

Example `javac` + `java` commands (Linux/macOS; adapt paths for Windows):

```bash
# compile
javac --module-path /path/to/javafx/lib --add-modules javafx.controls -cp
":/path/to/ojdbc.jar" -d out src/com/smartcity/*.java


# run
java --module-path /path/to/javafx
