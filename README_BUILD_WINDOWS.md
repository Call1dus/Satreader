# Build (Windows / Minecraft Java / Fabric)

This is a **client-only Fabric mod** for Minecraft **1.21.11**.

## Requirements
1) **Java 21 JDK**
   - Check: `java -version`
   - If needed (PowerShell): `winget install EclipseAdoptium.Temurin.21.JDK`

2) Either:
   - **Gradle installed** (recommended), OR
   - IntelliJ IDEA (it can import and run Gradle projects)

### Install Gradle (PowerShell)
```powershell
winget install Gradle.Gradle
```

Close and reopen PowerShell, then confirm:
```powershell
gradle --version
```

## Build the mod jar
Open PowerShell in the folder that contains `build.gradle` and run:
```powershell
gradle build
```

Your jar will be in:
`build\libs\`

## Run a dev client (optional)
```powershell
gradle runClient
```
