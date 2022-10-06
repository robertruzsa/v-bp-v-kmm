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

    fun humanizeDate(date: LocalDateTime): String {
        val now = now()
        if (isSameDay(date, now)) {
            return LocalizedString("Ma", "Today").hu
        }
        if (isSameDay(date, now.plusDays(1))) {
            return LocalizedString("Holnap", "Tomorrow").hu
        }
        val day = date.dayOfWeek.localized().regular.hu
        val month = date.month.localized().regular.hu
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
}
