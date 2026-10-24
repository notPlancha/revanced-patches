package app.revanced.patches.instagram.download

import app.revanced.patcher.patch.bytecodePatch

@Suppress("unused")
val downloadMediaPatch = bytecodePatch(
    name = "Download media",
    description = "Enables downloading stories, reels, voice notes, and images directly within Instagram.",
) {
    compatibleWith("com.instagram.android")

    extendWith("extensions/extension.rve")

    execute {
        // TODO: Hook into media viewer context menu / action sheet to trigger download
    }
}
