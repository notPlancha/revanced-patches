package app.revanced.patches.instagram.feed

import app.revanced.patcher.patch.bytecodePatch

@Suppress("unused")
val hideSuggestedPostsPatch = bytecodePatch(
    name = "Hide suggested posts",
    description = "Hides suggested posts, suggested reels, and recommended accounts in the main home feed.",
) {
    compatibleWith("com.instagram.android")

    execute {
        // TODO: Filter out suggested feed items from the feed response model
    }
}
