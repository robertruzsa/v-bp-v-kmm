package com.robertruzsa.vbpvkmm.android.ui.components.horizontaldatepicker

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.robertruzsa.vbpvkmm.common.util.DateTimeUtil
import kotlinx.datetime.LocalDateTime

@Composable
fun HorizontalDatePicker(
    selectableDates: List<LocalDateTime>,
    selectedDate: LocalDateTime = DateTimeUtil.now(),
    onDateClick: (LocalDateTime) -> Unit
) {
    LazyRow(
        modifier = Modifier.background(MaterialTheme.colors.surface)
    ) {
        items(selectableDates) { date ->
            HorizontalDateItem(
                dateString = DateTimeUtil.humanizeDate(date),
                isSelected = date == selectedDate,
                onDateClick = {
                    onDateClick(date)
                }
            )
        }
    }
}
