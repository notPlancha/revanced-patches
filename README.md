# 🧩 ReVanced Patches

Custom ReVanced Patches repository by [@notPlancha](https://github.com/notPlancha).

## 📌 Overview

This repository contains custom patches for Android apps built using the [ReVanced Patcher](https://github.com/ReVanced/revanced-patcher) framework.

- **Patches Bundle**: Compiles into a `.rvp` (ReVanced Patches) bundle.
- **Extensions**: Custom Android code compiled into `.rve` extensions and injected into target APKs.
- **CI/CD**: GitHub Actions workflow automatically builds the `.rvp` file on every push/PR and releases on tags (`v*`).

---

## 🏗️ Project Structure

```
├── patches/
│   ├── build.gradle.kts           # Patches metadata and build configuration
│   └── src/main/kotlin/
│       └── app/revanced/patches/
│           ├── example/           # Template / example patch
│           │   └── ExamplePatch.kt
│           └── <app_name>/        # Add custom patches organized by app
├── extensions/
│   └── extension/                 # Optional companion Android code (.rve)
├── gradle/
│   └── libs.versions.toml         # Dependency versions (ReVanced Patcher, smali)
└── .github/workflows/
    ├── build.yml                  # Automated build and .rvp artifact upload
    └── release.yml                # Semantic release workflow
```

---

## 🛠️ Prerequisites & Local Setup

### 1. Requirements
- **JDK 17 or JDK 21** (Temurin recommended)
- **Git**
- **GitHub Personal Access Token (PAT)** with `read:packages` scope (required by GitHub Packages to resolve `app.revanced.patches` and `revanced-patcher`).

### 2. Configure GitHub Packages Authentication
Create or edit `~/.gradle/gradle.properties` (e.g. `C:\Users\<User>\.gradle\gradle.properties` on Windows):

```properties
gpr.user=notPlancha
gpr.key=YOUR_GITHUB_PAT_WITH_READ_PACKAGES
```

### 3. Build Locally
Run Gradle to build the `.rvp` patch bundle:

```bash
# On Windows
.\gradlew build

# On Linux / macOS
./gradlew build
```

Compiled `.rvp` patch files will be generated in `patches/build/libs/`.

---

## ✍️ Writing a Patch

Create a Kotlin file in `patches/src/main/kotlin/app/revanced/patches/<app>/`:

```kotlin
package app.revanced.patches.<app>

import app.revanced.patcher.patch.bytecodePatch

@Suppress("unused")
val myCustomPatch = bytecodePatch(
    name = "Patch Name",
    description = "Description of what this patch accomplishes.",
) {
    // Specify compatible package name and versions (or leave versions empty for any)
    compatibleWith("com.target.package"("1.2.3"))

    execute {
        // Find classes and methods via Fingerprints or direct lookup
        // Example:
        // val targetClass = classes.first { it.type.endsWith("TargetClass;") }
        // targetClass.methods.first { it.name == "targetMethod" }.apply { ... }
    }
}
```

---

## 🚀 Testing with ReVanced CLI

To test your compiled patch bundle with an APK:

```bash
# Run ReVanced CLI with your custom patches bundle
revanced-cli patch \
    --patch-bundle patches/build/libs/patches-<version>.rvp \
    path/to/target.apk \
    --out path/to/target-patched.apk
```

---

## 📜 License

Licensed under the [GNU General Public License v3.0](LICENSE).
