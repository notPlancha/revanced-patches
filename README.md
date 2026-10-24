# 🧩 ReVanced Patches

Custom ReVanced Patches repository by [@notPlancha](https://github.com/notPlancha).

## 📌 Overview

This repository contains custom patches for Android apps built using the [ReVanced Patcher](https://github.com/ReVanced/revanced-patcher) framework.

- **Patches Bundle**: Compiles into a `.rvp` (ReVanced Patches) bundle.
- **Extensions**: Custom Android code compiled into `.rve` extensions and injected into target APKs.
- **CI/CD**: GitHub Actions workflow automatically builds the `.rvp` file on every push/PR and releases on tags (`v*`).

---

## 📱 Included Patches

### Instagram (`com.instagram.android`)
* **Hide Ads** (`app.revanced.patches.instagram.ads.hideAdsPatch`): Hides sponsored posts, ads in feed, and promoted stories/reels.
* **Hide Suggested Posts** (`app.revanced.patches.instagram.feed.hideSuggestedPostsPatch`): Hides suggested posts, suggested reels, and suggested accounts from the main feed.
* **Sanitize Sharing Links** (`app.revanced.patches.instagram.misc.sanitizeSharingLinksPatch`): Strips tracking query parameters (such as `?igsh=...`, `?utm_source=...`) when copying or sharing links.
* **Download Media** (`app.revanced.patches.instagram.download.downloadMediaPatch`): Enables downloading stories, reels, voice notes, and images.

---

## 🏗️ Project Structure

```
├── patches/
│   ├── api/                       # Public API signatures (Kotlin binary compatibility)
│   ├── build.gradle.kts           # Patches metadata and build configuration
│   └── src/main/kotlin/
│       └── app/revanced/patches/
│           ├── instagram/         # Instagram patches
│           │   ├── ads/           # Ad blocking & sponsored post filtering
│           │   ├── download/      # Media download functionality
│           │   ├── feed/          # Feed tweaks & suggestions removal
│           │   └── misc/          # URL sanitization and utilities
│           └── <new_app>/         # Add future app patches here
├── extensions/
│   └── extension/                 # Optional companion Android code (.rve)
├── gradle/
│   └── libs.versions.toml         # Dependency versions (ReVanced Patcher, smali)
└── .github/workflows/
    ├── build.yml                  # Automated build and .rvp artifact upload
    └── release.yml                # Semantic release workflow
```

---

## 🛠️ Building Locally

```powershell
# Build all patches and extension bundles (.rvp)
.\gradlew.bat build

# Update the public binary API definition when adding/modifying patches
.\gradlew.bat :patches:apiDump
```

Compiled `.rvp` files are output to `patches/build/libs/patches-<version>.rvp`.

---

## ➕ Adding a New App in the Future

To add patches for another app:
1. Create a directory under `patches/src/main/kotlin/app/revanced/patches/<app_name>/`.
2. Define a patch:
   ```kotlin
   package app.revanced.patches.<app_name>

   import app.revanced.patcher.patch.bytecodePatch

   @Suppress("unused")
   val myPatch = bytecodePatch(
       name = "Patch Name",
       description = "Description of the patch",
   ) {
       compatibleWith("com.target.package")

       execute {
           // Fingerprint matching and bytecode edits
       }
   }
   ```
3. Run `.\gradlew.bat :patches:apiDump` to register the new public symbols.
4. Run `.\gradlew.bat build` to verify the build.

---

## 🚀 Patching an APK with ReVanced CLI

```bash
revanced-cli patch \
    --patch-bundle patches/build/libs/patches-1.0.4.rvp \
    path/to/instagram.apk \
    --out path/to/instagram-patched.apk
```

---

## 📜 License

Licensed under the [GNU General Public License v3.0](LICENSE).
