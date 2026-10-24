package app.revanced.patches.instagram.ads

import app.revanced.patcher.patch.bytecodePatch

@Suppress("unused")
val hideAdsPatch = bytecodePatch(
    name = "Hide ads",
    description = "Removes sponsored posts, ads in feed, and promoted stories/reels in Instagram.",
) {
    compatibleWith("com.instagram.android")

    execute {
        // TODO: Add bytecode instructions or fingerprints targeting ad model parsers
    }
}
