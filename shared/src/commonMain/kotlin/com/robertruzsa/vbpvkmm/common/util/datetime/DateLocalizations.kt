package com.robertruzsa.vbpvkmm.common.util.datetime

import com.robertruzsa.vbpvkmm.common.util.LocalizedString
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.Month

fun DayOfWeek.localized(): LocalizedDateString {
    return when (this) {
        DayOfWeek.MONDAY -> LocalizedDateString(
            regular = LocalizedString(
                hu = "hétfő",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "H",
                en = "Mon"
            ),
        )
        DayOfWeek.TUESDAY -> LocalizedDateString(
            regular = LocalizedString(
                hu = "kedd",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "K",
                en = "Tue"
            ),
        )
        DayOfWeek.WEDNESDAY -> LocalizedDateString(
            regular = LocalizedString(
                hu = "szerda",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "Sze",
                en = "Wed"
            ),
        )
        DayOfWeek.THURSDAY -> LocalizedDateString(
            regular = LocalizedString(
                hu = "csütörtök",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "Cs",
                en = "Thur"
            ),
        )
        DayOfWeek.FRIDAY -> LocalizedDateString(
            regular = LocalizedString(
                hu = "péntek",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "P",
                en = "Fri"
            ),
        )
        DayOfWeek.SATURDAY -> LocalizedDateString(
            regular = LocalizedString(
                hu = "szombat",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "Szo",
                en = "Sat"
            ),
        )
        DayOfWeek.SUNDAY -> LocalizedDateString(
            regular = LocalizedString(
                hu = "vasárnap",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "V",
                en = "Sun"
            ),
        )
        else -> LocalizedDateString(
            regular = LocalizedString(
                hu = "hétfő",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "H",
                en = "Mon"
            ),
        )
    }
}

fun Month.localized(): LocalizedDateString {
    return when (this) {
        Month.JANUARY -> LocalizedDateString(
            regular = LocalizedString(
                hu = "január",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "jan.",
                en = "jan."
            ),
        )
        Month.FEBRUARY -> LocalizedDateString(
            regular = LocalizedString(
                hu = "február",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "feb.",
                en = "feb."
            ),
        )
        Month.MARCH -> LocalizedDateString(
            regular = LocalizedString(
                hu = "március",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "márc.",
                en = "mar."
            ),
        )
        Month.APRIL -> LocalizedDateString(
            regular = LocalizedString(
                hu = "április",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "ápr.",
                en = "apr."
            ),
        )
        Month.MAY -> LocalizedDateString(
            regular = LocalizedString(
                hu = "május",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "máj",
                en = "may"
            ),
        )
        Month.JUNE -> LocalizedDateString(
            regular = LocalizedString(
                hu = "június",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "jún.",
                en = "jun."
            ),
        )
        Month.JULY -> LocalizedDateString(
            regular = LocalizedString(
                hu = "július",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "júl.",
                en = "jul."
            ),
        )
        Month.AUGUST -> LocalizedDateString(
            regular = LocalizedString(
                hu = "augusztus",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "aug.",
                en = "aug."
            ),
        )
        Month.SEPTEMBER -> LocalizedDateString(
            regular = LocalizedString(
                hu = "szeptember",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "szept.",
                en = "sept."
            ),
        )
        Month.OCTOBER -> LocalizedDateString(
            regular = LocalizedString(
                hu = "október",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "okt.",
                en = "okt."
            ),
        )
        Month.NOVEMBER -> LocalizedDateString(
            regular = LocalizedString(
                hu = "november",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "nov.",
                en = "nov."
            ),
        )
        Month.DECEMBER -> LocalizedDateString(
            regular = LocalizedString(
                hu = "december",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "dec.",
                en = "dec."
            ),
        )
        else -> LocalizedDateString(
            regular = LocalizedString(
                hu = "január",
                en = this.name.lowercase()
            ),
            short = LocalizedString(
                hu = "jan.",
                en = "jan."
            )
        )
    }
}
