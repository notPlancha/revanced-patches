package app.revanced.patches.instagram.misc

import app.revanced.patcher.patch.bytecodePatch

@Suppress("unused")
val sanitizeSharingLinksPatch = bytecodePatch(
    name = "Sanitize sharing links",
    description = "Strips tracking query parameters (e.g. ?igsh=, ?utm_source=) when sharing links from Instagram.",
) {
    compatibleWith("com.instagram.android")

    execute {
        // TODO: Intercept link generator to strip tracking query parameters
    }
}
