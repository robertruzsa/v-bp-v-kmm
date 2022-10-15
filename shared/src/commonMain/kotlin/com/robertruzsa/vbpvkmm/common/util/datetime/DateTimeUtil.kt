package com.robertruzsa.vbpvkmm.common.util.datetime

import com.robertruzsa.vbpvkmm.common.util.LocalizedString
import kotlin.time.Duration.Companion.days
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

object DateTimeUtil {

    fun now(): LocalDateTime {
        return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    }

    fun toEpochMillis(dateTime: LocalDateTime): Long {
        return dateTime.toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()
    }

    fun toLocalDateTime(epochMillis: Long): LocalDateTime {
        return Instant.fromEpochMilliseconds(epochMillis)
            .toLocalDateTime(TimeZone.currentSystemDefault())
    }

    fun humanizeDate(date: LocalDateTime, languageCode: String = "hu"): String {
        val isHungarianLanguage = languageCode == "hu"
        val now = now()
        if (isSameDay(date, now)) {
            val todayText = LocalizedString("Ma", "Today")
            return if (isHungarianLanguage) {
                todayText.hu
            } else {
                todayText.en
            }
        }

        val tomorrowText = LocalizedString("Holnap", "Tomorrow")
        if (isSameDay(date, now.plusDays(1))) {
            return if (isHungarianLanguage) {
                tomorrowText.hu
            } else {
                tomorrowText.en
            }
        }

        val dayText = date.dayOfWeek.localized().regular
        val day = if (isHungarianLanguage) {
            dayText.hu
        } else {
            dayText.en
        }
        val monthText = date.month.localized().regular
        val month = if (isHungarianLanguage) {
            monthText.hu
        } else {
            monthText.en
        }
        return "$day, $month ${date.dayOfMonth}."
    }

    fun formatHorizontalPickerDate(dateTime: LocalDateTime): String {
        val dayOfWeek = dateTime.dayOfWeek.localized().short.hu
        val month = dateTime.month.localized().short.hu
        val dayOfMonth = dateTime.dayOfMonth
        return "$dayOfWeek\n$month $dayOfMonth."
    }

    fun isSameDay(date: LocalDateTime, other: LocalDateTime): Boolean =
        date.year == other.year && date.month == other.month && date.dayOfMonth == other.dayOfMonth

    fun LocalDateTime.plusDays(daysToAdd: Long): LocalDateTime {
        val timeZone = TimeZone.currentSystemDefault()
        return this.toInstant(timeZone).plus(daysToAdd.days).toLocalDateTime(timeZone)
    }

    fun getSelectableDates(startDateTime: LocalDateTime?): List<LocalDateTime> {
        val selectableDates = mutableListOf<LocalDateTime>()
        var date = startDateTime ?: now()
        selectableDates.add(date)
        repeat(NUMBER_OF_SELECTABLE_DATES) {
            date = date.plusDays(1)
            selectableDates.add(date)
        }
        return selectableDates
    }

    private const val NUMBER_OF_SELECTABLE_DATES = 14
}
